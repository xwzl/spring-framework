package com.spring.test.aspect.proxy;

/**
 * 静态代理
 *
 * @author xuweizhi
 * @since 2020/06/30 11:18
 */
public class Student implements JdkProxyInterface {

	@Override
	public String dance() {
		return "How are you !";
	}
}
