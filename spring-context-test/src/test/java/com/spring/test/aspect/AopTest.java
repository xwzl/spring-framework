package com.spring.test.aspect;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试
 */
public class AopTest {

	@Test
	public void testAop() {
		ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:aspect/spring-aop.xml");
		TestBean bean = (TestBean) bf.getBean("test");
		bean.test();
	}
}
