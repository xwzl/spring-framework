package com.spring.test.bean.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean 初始化前后执行该方法
 */
public class BeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean [" + beanName + "] 开始初始化");
		// 这里一定要返回 bean，不能返回 null
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean [" + beanName + "] 完成初始化");
		return bean;
	}

	public void display() {
		System.out.println("hello BeanPostProcessor!!!");
	}
}
