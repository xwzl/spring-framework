package com.spring.test.bean.aware;

import com.spring.test.utils.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuweizhi
 * @since 2020/06/17 14:43
 */
public class AwareTest {

	@Test
	public void testAware(){
		ClassPathXmlApplicationContext context = SpringContextUtil.context("classpath:bean/aware/spring-aware.xml");
		SpringAware bean = (SpringAware) context.getBean("springAware");
		bean.testAware();
	}

	@Test
	public void testAwareTwo(){
		ClassPathXmlApplicationContext context = SpringContextUtil.context("classpath:bean/aware/spring-aware.xml");
		MyApplicationAware applicationAware = (MyApplicationAware) context.getBean("myApplicationAware");
		applicationAware.display();
	}
}
