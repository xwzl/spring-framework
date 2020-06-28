package com.spring.test.aspect;

import org.junit.jupiter.api.Test;
import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试
 */
public class AopTest {

	/**
	 * 解析自定义标签时调用 {@link AopNamespaceHandler#init()} 初始化解析器
	 *
	 * 何时调用呢？
	 *
	 * {@link AbstractAutowireCapableBeanFactory#initializeBean(String, Object, RootBeanDefinition)}
	 *
	 * applyBeanPostProcessorsBeforeInitialization
	 * applyBeanPostProcessorsAfterInitialization

	 *
	 */
	@Test
	public void testAop() {
		ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:aspect/spring-aop.xml");
		TestBean bean = (TestBean) bf.getBean("test");
		bean.test();
	}
}
