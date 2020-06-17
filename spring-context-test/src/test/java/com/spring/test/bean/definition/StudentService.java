package com.spring.test.bean.definition;

import org.springframework.stereotype.Component;

/**
 * @author xuweizhi
 * @since 2020/06/17 16:57
 */
@Component
public class StudentService {

	private String name;

	private Integer age;

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
