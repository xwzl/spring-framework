package com.spring.test.aspect.proxy;

/**
 * 静态代理
 *
 * @author xuweizhi
 * @since 2020/06/30 11:18
 */
public class StudentProxy implements JdkProxyInterface {

	private final Student student;

	public StudentProxy(Student student) {
		this.student = student;
	}

	@Override
	public String dance() {
		return student.dance();
	}

	public static void main(String[] args) {
		StudentProxy proxy = new StudentProxy(new Student());
		System.out.println(proxy.dance());
	}
}
