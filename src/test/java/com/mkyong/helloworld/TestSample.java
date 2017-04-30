package com.mkyong.helloworld;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.mkyong.helloworld.domain.AbstractDomain;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.kubun.i.Kubun;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import junit.framework.TestCase;

public class TestSample extends TestCase {

	@Test
	public void test01() {
		Class<BushoDomain> clazz = BushoDomain.class;
		Constructor<BushoDomain> ctor;
		try {

			ctor = clazz.getConstructor();
			BushoDomain instance = ctor.newInstance();
			// System.out.println(instance.isEigyosho());

		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		try {

			CtClass origCtClass = ClassPool.getDefault().get(BushoDomain.class.getName());
			CtClass emptyCtClass = ClassPool.getDefault().makeClass(origCtClass.getName() + "Empty", origCtClass);

			CtMethod m = CtNewMethod.make("public void madeMethod(String bar) { throw new RuntimeException(bar); }",
					emptyCtClass);
			emptyCtClass.addMethod(m);
			Class emptyClass = emptyCtClass.toClass();

			BushoDomain empty = (BushoDomain) emptyClass.newInstance();
			// System.out.println(empty.getClass().getName());
			// System.out.println(empty.isEigyosho());

			Method addedMethod = empty.getClass().getMethod("madeMethod", String.class);

		} catch (CannotCompileException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test03() {
		Class originalClass = BushoDomain.class;
		Method[] methods = originalClass.getDeclaredMethods();
		for (Method method : methods) {
			// System.out.println(method.getName() + " :=> " +
			// method.getReturnType());
			Class<?> returnType = method.getReturnType();
			if (returnType.isAssignableFrom(BushoKubun.class)) {
				// System.out.println("BushoKubun が 返却の型だよ！！");
			}
			if (returnType.isAssignableFrom(boolean.class)) {
				// System.out.println("boolean が 返却の型だよ!!!!");
			}
		}
	}

	@Test
	public void test04() throws Exception {

		ClassPool classPool = ClassPool.getDefault();
		CtClass origCtClass = classPool.get(KokyakuDomain.class.getName());
		CtClass emptyCtClass = classPool.makeClass(origCtClass.getName() + "Empty", origCtClass);

		CtMethod[] origMethods = origCtClass.getDeclaredMethods();
		CtMethod[] emptyMethods = emptyCtClass.getMethods();

		// exclude superclass method from empty method
		// TODO

		for (CtMethod method : emptyMethods) {

			System.out.println("---");
			System.out.println(method.getName());

			CtClass returnType = method.getReturnType();

			if (returnType.equals(CtClass.voidType)) {
				method.setBody(";");
			} else if (returnType.equals(CtClass.booleanType)) {
				method.setBody("return false;");
			}

			boolean isDomain = returnType.subclassOf(classPool.get(AbstractDomain.class.getName()));
			if (isDomain) {
			}

			CtClass[] interfaces = returnType.getInterfaces();
			for (CtClass _interface : interfaces) {
				boolean isKubun = _interface.equals(classPool.get(Kubun.class.getName()));
				if (isKubun) {
					method.setBody("return null;");
				}
			}
		}
	}

}
