package com.spring.test.bean.definition;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuweizhi
 * @since 2020/06/17 16:58
 */
public class DefinitionTest {

	@Test
	public void definitionTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean/definition/spring-definition.xml");

		StudentService studentService = (StudentService) context.getBean("studentService");
		System.out.println("student name:" + studentService.getName() + "-- age:" + studentService.getAge());

	}
}
