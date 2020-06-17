package com.spring.test.bean.life;

import com.spring.test.utils.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuweizhi
 * @since 2020/06/17 15:52
 */
public class LifeTest {

	@Test
	public void testInit() throws Exception {
		ClassPathXmlApplicationContext context = SpringContextUtil.context("classpath:bean/life/spring-init.xml");
		LifeCycleBean lifeCycleBean = (LifeCycleBean) context.getBean("lifeCycleBean");
		lifeCycleBean.display();
		System.out.println("方法调用完成，容器开始关闭....");
	}
}
