package com.mkyong.helloworld.system;

import java.util.HashMap;

import com.mkyong.helloworld.domain.AbstractDomain;
import com.mkyong.helloworld.system.exception.SystemException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

public class EmptyObjectProxy {

	private static HashMap<Class, Object> INSTANCES = new HashMap<Class, Object>();

	public static <T extends AbstractDomain> T get(Class<T> clazz) {
		return getEmpty(clazz);
	}

	private static <T extends Object> T getEmpty(Class<T> clazz) {

		try {

			Object _instance = INSTANCES.get(clazz);
			if (_instance != null) {
				System.out.println("already exists : " + clazz.getSimpleName());
				return (T) _instance;
			}

			ClassPool cp = ClassPool.getDefault();
			CtClass origCtClass = cp.get(clazz.getName());
			CtClass emptyCtClass = cp.makeClass(origCtClass.getName() + "Empty", origCtClass);

			// overrode methods of empty class

			// cretate instance
			Class emptyClass = emptyCtClass.toClass();
			T empty = (T) emptyClass.newInstance();

			// done
			INSTANCES.put(clazz, empty);
			return empty;

		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new SystemException("クラスプールに存在しないクラスかもしれません : " + clazz.getSimpleName());
		} catch (CannotCompileException e) {
			e.printStackTrace();
			throw new SystemException("コンパイルできず : " + clazz.getSimpleName());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new SystemException("No Args Constructorが実装されていない可能性 : " + clazz.getSimpleName());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new SystemException("Constructorがpublicでない可能性 : " + clazz.getSimpleName());
		}
	}

}