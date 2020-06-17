package com.spring.test.bean.processor;

import com.spring.test.utils.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuweizhi
 * @since 2020/06/17 15:10
 */
public class BeanProcessorTest {

	@Test
	public void test(){
		ClassPathXmlApplicationContext context = SpringContextUtil.context("classpath:bean/aware/spring-aware.xml");
		BeanProcessor test = (BeanProcessor) context.getBean("beanProcessor");
		test.display();
	}
}
