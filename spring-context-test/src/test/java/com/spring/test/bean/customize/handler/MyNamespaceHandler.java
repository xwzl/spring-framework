package com.spring.test.bean.customize.handler;

import com.spring.test.bean.customize.parser.PhoneBeanDefinitionParser;
import com.spring.test.bean.customize.parser.UserBeanDefinitionParser;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 定义 Handler 类，继承 NamespaceHandlerSupport ,主要目的是将上面定义的解析器Parser类注册到 Spring 容器中。
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

	/**
	 * {@link DefaultNamespaceHandlerResolver#resolve} 调用
	 */
	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
		registerBeanDefinitionParser("phone", new PhoneBeanDefinitionParser());
	}

}
