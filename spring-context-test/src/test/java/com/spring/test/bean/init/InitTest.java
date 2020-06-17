package com.spring.test.bean.init;

import com.spring.test.utils.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuweizhi
 * @since 2020/06/17 15:52
 */
public class InitTest {

	/**
	 *{@link AbstractAutowireCapableBeanFactory#initializeBean(String, Object, RootBeanDefinition)}
	 */
	@Test
	public void testInit() throws Exception {
		ClassPathXmlApplicationContext context = SpringContextUtil.context("classpath:bean/init/spring-init.xml");
		Initializing bean = context.getBean(Initializing.class);
		System.out.println(bean.getName());
	}
}
