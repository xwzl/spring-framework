package com.spring.test.aspect;

import com.spring.test.aspect.proxy.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author xuweizhi
 * @since 2020/07/01 14:13
 */
@Configuration
public class AppConfig {

	@Bean
	public Student student() {
		return new Student();
	}
}
