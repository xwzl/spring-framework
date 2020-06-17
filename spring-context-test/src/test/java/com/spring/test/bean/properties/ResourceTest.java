package com.spring.test.bean.properties;

import com.spring.test.bean.definition.StudentService;
import com.spring.test.utils.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuweizhi
 * @since 2020/06/17 17:29
 */
public class ResourceTest {

	/**
	 * 启动参数：-Dspring.profiles.active=dev
	 *
	 */
	@Test
	public void testResource() {
		ClassPathXmlApplicationContext context = SpringContextUtil.context("classpath:bean/properties/spring-properties.xml");
		StudentService studentService = (StudentService) context.getBean("studentService");
		System.out.println("student name:" + studentService.getName());
	}

	/**
	 * 启动参数：-Dspring.profiles.active=dev
	 *
	 */
	@Test
	public void testValue() {
		ClassPathXmlApplicationContext context = SpringContextUtil.context("classpath:bean/properties/spring-properties.xml");
		Gun gun = (Gun) context.getBean("gun");
		System.out.println("gun name:" + gun.getPower());
	}

	@Test
	public void testOverrideValue() {
		ClassPathXmlApplicationContext context = SpringContextUtil.context("classpath:bean/properties/spring-override-properties.xml");
		StudentService studentService = (StudentService) context.getBean("student");
		System.out.println("student name:" + studentService.getName());
	}
}
