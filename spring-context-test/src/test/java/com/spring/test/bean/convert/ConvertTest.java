package com.spring.test.bean.convert;

import com.spring.test.bean.customize.bean.Phone;
import com.spring.test.bean.customize.bean.User;
import com.spring.test.bean.customize.handler.MyNamespaceHandler;
import com.spring.test.bean.customize.parser.UserBeanDefinitionParser;
import com.spring.test.module.CarFactory;
import com.spring.test.utils.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 扩展 Spring 自定义标签配置一般需要以下几个步骤：
 *
 * <ul>
 *     <li>创建一个需要扩展的组件{@link User} and {@link Phone}</li>
 *     <li>定义一个 XSD 文件，用于描述组件内容</li>
 *     <li>创建一个实现 AbstractSingleBeanDefinitionParser 接口的类，{@link UserBeanDefinitionParser}用来解析 XSD 文件中的定义和组件定义</li>
 *     <li>创建一个 Handler，继承 NamespaceHandlerSupport ，{@link MyNamespaceHandler}用于将组件注册到 Spring 容器</li>
 *     <li>编写 Spring.handlers 和 Spring.schemas 文件</li>
 * </ul>
 */
public class ConvertTest {

	@Test
	public void MyTestBeanTest() {
		ClassPathXmlApplicationContext context = SpringContextUtil.context("classpath:bean/convert/spring-convert.xml");
		CarFactory bean = context.getBean(CarFactory.class);
		System.out.println(bean);
	}

}
