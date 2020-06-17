package com.spring.test.bean.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xuweizhi
 * @since 2020/06/17 17:47
 */
@Component
public class Gun {

	@Value("${gun.power}")
	private String power;

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
}
