package com.spring.test.bean.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * 实现 aware 接口，可以动态增强bean
 * <p>
 * Aware 接口为 Spring 容器的核心接口，是一个具有标识作用的超级接口，实现了该接口的 bean 是具有被 Spring 容
 * 器通知的能力，通知的方式是采用回调的方式。
 * <p>
 * Aware 接口是一个空接口，实际的方法签名由各个子接口来确定，且该接口通常只会有一个接收单参数的 set 方法，该 set 方
 * 法的命名方式为 set + 去掉接口名中的 Aware 后缀，即 XxxAware 接口，则方法定义为 setXxx()，例如 BeanNameAware（
 * setBeanName），ApplicationContextAware（setApplicationContext）
 *
 * @author xuweizhi
 * @since 2020/06/17 14:39
 */
public class SpringAware implements BeanFactoryAware {

	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	public void testAware() {
		SpringBean bean = beanFactory.getBean(SpringBean.class);
		bean.printInfo();
	}
}
