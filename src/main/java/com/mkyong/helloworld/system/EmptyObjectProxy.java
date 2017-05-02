package com.mkyong.helloworld.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.mkyong.helloworld.domain.AbstractDomain;
import com.mkyong.helloworld.kubun.i.Kubun;
import com.mkyong.helloworld.system.exception.SystemException;
import com.mkyong.helloworld.value.AbstractValue;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

public class EmptyObjectProxy {

	/**
	 * 生成済みのEmpty Object
	 */
	private static HashMap<Class<?>, Object> INSTANCES = new HashMap<Class<?>, Object>();

	/**
	 * DomainのEmptyを取得
	 * 
	 * @param clazz
	 *            クラス
	 * @return Empty
	 */
	public static <T extends AbstractDomain> T domain(Class<T> clazz) {
		return get(clazz);
	}

	/**
	 * ValueのEmptyを取得
	 * 
	 * @param clazz
	 *            クラス
	 * @return Empty
	 */
	public static <T extends AbstractValue> T value(Class<T> clazz) {
		return get(clazz);
	}

	/**
	 * Emptyを取得する。
	 * 
	 * @param clazz
	 * @return
	 */
	private static <T extends Object> T get(Class<T> clazz) {

		// get if already made
		Object _instance = INSTANCES.get(clazz);
		if (_instance != null) {
			return (T) _instance;
		}

		try {

			// get base class
			ClassPool cp = ClassPool.getDefault();
			CtClass origCtClass = cp.get(clazz.getName());

			// make empty class
			CtClass emptyCtClass = cp.makeClass(origCtClass.getName() + "Empty", origCtClass);

			// override methods of empty class
			CtMethod[] emptyMethods = emptyCtClass.getMethods();
			List<CtMethod> methodsForOverride = new ArrayList<CtMethod>(Arrays.asList(emptyMethods));

			// exclude superclass methods from empty object methods
			CtClass superClass = origCtClass.getSuperclass();
			List<CtMethod> superClassMethods = new ArrayList<CtMethod>();
			if (superClass != null) {
				superClassMethods.addAll(Arrays.asList(superClass.getMethods()));
			}
			methodsForOverride.removeIf(target -> {
				boolean match = superClassMethods.stream().anyMatch(superMethod -> {
					boolean sameName = target.getName().equals(superMethod.getName());
					boolean sameSignature = target.getSignature().equals(superMethod.getSignature());
					return sameName && sameSignature;
				});
				return match;
			});

			// override
			for (CtMethod _m : methodsForOverride) {

				CtMethod method = CtNewMethod.copy(_m, emptyCtClass, null);

				CtClass returnType = method.getReturnType();

				// if return type is Primitive
				if (returnType.equals(CtClass.voidType)) {
					method.setBody("return;");
				} else if (returnType.equals(CtClass.booleanType)) {
					method.setBody("return false;");
				} else if (returnType.equals(CtClass.byteType)) {
					method.setBody("return 0;");
				} else if (returnType.equals(CtClass.charType)) {
					method.setBody("return 0;");
				} else if (returnType.equals(CtClass.doubleType)) {
					method.setBody("return 0;");
				} else if (returnType.equals(CtClass.floatType)) {
					method.setBody("return 0;");
				} else if (returnType.equals(CtClass.intType)) {
					method.setBody("return 0;");
				} else if (returnType.equals(CtClass.longType)) {
					method.setBody("return 0;");
				} else if (returnType.equals(CtClass.shortType)) {
					method.setBody("return 0;");
				}

				// String
				boolean isString = returnType.equals(cp.get(String.class.getName()));
				if (isString) {
					if (method.getName().equals("toString")) {
						method.setBody("return \"Empty Object of " + clazz.getSimpleName() + "\";");
					} else {
						method.setBody("return new String();");
					}
				}

				// Integer
				boolean isInteger = returnType.equals(cp.get(Integer.class.getName()));
				if (isInteger) {
					method.setBody("return new Integer(0);");
				}

				// TODO Others

				// Domain
				boolean isDomain = returnType.subclassOf(cp.get(AbstractDomain.class.getName()));
				if (isDomain) {
					String body = "return (" + returnType.getName() + ") " + EmptyObjectProxy.class.getName()
							+ ".domain(" + returnType.getName() + ".class);";
					method.setBody(body);
				}

				// Value Object
				boolean isValue = returnType.subclassOf(cp.get(AbstractValue.class.getName()));
				if (isValue) {
					String body = "return (" + returnType.getName() + ") " + EmptyObjectProxy.class.getName()
							+ ".value(" + returnType.getName() + ".class);";
					method.setBody(body);
				}

				// Kubun
				CtClass[] interfaces = returnType.getInterfaces();
				boolean isKubun = Arrays.asList(interfaces).stream().anyMatch(i -> {
					try {
						return i.equals(cp.get(Kubun.class.getName()));
					} catch (NotFoundException e) {
						throw new SystemException("ClassPool にないかもしれません : " + Kubun.class.getName(), e);
					}
				});
				if (isKubun) {
					method.setBody("return " + returnType.getName() + ".EMPTY;");
				}

				// add method
				emptyCtClass.addMethod(method);
			}

			// TODO add isEmpty

			// cretate instance
			// TODO how to create instance that doesn't have NoArgsConstructor
			Class<?> emptyClass = emptyCtClass.toClass();
			T empty = (T) emptyClass.newInstance();

			// done
			INSTANCES.put(clazz, empty);
			return empty;

		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new SystemException("ClassPoolに存在しないクラスかもしれません : " + clazz.getSimpleName(), e);
		} catch (CannotCompileException e) {
			e.printStackTrace();
			throw new SystemException("コンパイルできず : " + clazz.getSimpleName(), e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new SystemException(
					"@NoArgsConstructorが設定されていない、あるいは引数なしのConstructorが実装されていない可能性 : " + clazz.getSimpleName(), e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new SystemException("Constructorがpublicでない可能性 : " + clazz.getSimpleName(), e);
		}
	}

}