package com.spring.test.bean.customize.parser;

import com.spring.test.bean.customize.bean.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 定义一个 Parser 类，该类继承 AbstractSingleBeanDefinitionParser ，并实现 getBeanClass() 和
 * doParse() 两个方法。主要是用于解析 XSD 文件中的定义和组件定义。这里定义了两个Parser类，一个是解析
 * User类，一个用来解析Phone类。
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	/**
	 * {@link AbstractSingleBeanDefinitionParser#parseInternal} 调用
	 */
	@Override
	protected Class getBeanClass(Element ele) {
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String id = element.getAttribute("id");
		String userName = element.getAttribute("userName");
		String email = element.getAttribute("email");
		if (StringUtils.hasText(id)) {
			builder.addPropertyValue("id", id);
		}
		if (StringUtils.hasText(userName)) {
			builder.addPropertyValue("userName", userName);
		}
		if (StringUtils.hasText(email)) {
			builder.addPropertyValue("email", email);
		}

	}
}
