package com.spring.test.aspect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xuweizhi
 * @since 2020/06/30 11:11
 */
class DanceHandler implements InvocationHandler {

	private final JdkProxy jdkProxy;

	public DanceHandler(JdkProxy jdkProxy) {
		this.jdkProxy = jdkProxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("dance") && method.getTypeParameters().length == 0) {
			System.out.println("动态");
		}
		return method.invoke(proxy, args);
	}
}
