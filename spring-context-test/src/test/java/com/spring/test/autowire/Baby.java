package com.spring.test.autowire;

import com.spring.test.module.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xuweizhi
 * @since 2020/06/17 11:09
 */
@Component
public class Baby {

	@Autowired
	private Car car;

	@Override
	public String toString() {
		return "Baby{" +
				"car=" + car +
				'}';
	}
}
