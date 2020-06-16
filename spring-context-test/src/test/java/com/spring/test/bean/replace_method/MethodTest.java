package com.spring.test.bean.replace_method;

import com.spring.test.utils.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 动态替换方法测试
 *
 * @author xuweizhi
 * @since 2020/06/16 11:27
 */
public class MethodTest {

	@Test
	public void testReplaceMethod() {
		ClassPathXmlApplicationContext context = SpringContextUtil.context("classpath:XmlBeanFactory.xml");
		Method bean = context.getBean(Method.class);
		bean.display();
	}
}
