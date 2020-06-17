package com.spring.test.bean.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean 初始化前后执行该方法：
 * <p>
 * BeanPostProcessor 的作用域是容器级别的，它只和所在的容器相关 ，当 BeanPostProcessor 完成注册后，
 * 它会应用于所有跟它在同一个容器内的 bean 。
 * <p>
 * BeanFactory 和 ApplicationContext 对 BeanPostProcessor 的处理不同，ApplicationContext 会自
 * 动检测所有实现了 BeanPostProcessor 接口的 bean，并完成注册，但是使用 BeanFactory 容器时则需要手
 * 动调用 AbstractBeanFactory#addBeanPostProcessor(BeanPostProcessor beanPostProcessor) 方法
 * 来完成注册。
 * <p>
 * ApplicationContext 的 BeanPostProcessor 支持 Ordered，而 BeanFactory 的 BeanPostProcessor
 * 是不支持的，原因在于ApplicationContext 会对 BeanPostProcessor 进行 Ordered 检测并完成排序，而
 * BeanFactory 中的 BeanPostProcessor 只跟注册的顺序有关。
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
