package com.mkyong.helloworld.system;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EmptyObjectProxy implements InvocationHandler {
	public static Object create(Class interfaceClass) {
		return create(new Class[] { interfaceClass });
	}

	public static Object create(Class[] interfaceClass) {
		return Proxy.newProxyInstance(interfaceClass[0].getClassLoader(), interfaceClass, new EmptyObjectProxy());
	}

	public Object invoke(Object proxy, Method method, Object[] args) {
		return getDefaultInstance(method.getReturnType());
	}

	public static Object getDefaultInstance(Class param) {
		if (param == int.class)
			return new Integer(0);
		if (param == boolean.class)
			return Boolean.FALSE;
		if (param == byte.class)
			return new Byte("0");
		if (param == short.class)
			return new Short("0");
		if (param == long.class)
			return new Long("0");
		if (param == float.class)
			return new Float("0");
		if (param == double.class)
			return new Double("0");
		return null;
	}
}