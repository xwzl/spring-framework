package com.spring.test.aspect.proxy;

import java.lang.reflect.Proxy;

/**
 * jdk 动态代理
 *
 * @author xuweizhi
 * @since 2020/06/30 10:56
 */
public class JdkProxy implements JdkProxyInterface {


	@Override
	public String dance() {
		System.out.println("This is a dance queue !");
		return "happy";
	}

	public static void main(String[] args) {
		DanceHandler handler = new DanceHandler(new JdkProxy());
		JdkProxyInterface proxyInterface = (JdkProxyInterface) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), JdkProxy.class.getInterfaces(), handler);
		String dance = proxyInterface.dance();
		System.out.println(dance);
	}


}

