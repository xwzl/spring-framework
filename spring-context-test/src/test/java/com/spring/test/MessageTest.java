package com.spring.test;

import com.spring.test.interfaces.Message;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 私人消息 Bean 测试
 *
 * @author xuweizhi
 * @since 2020/06/15 9:51
 */
public class MessageTest {

	/**
	 * https://blog.csdn.net/nuomizhende45/article/details/81158383?utm_source=app
	 */
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

		System.out.println("context 启动成功");
		// 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
		Message messageService = context.getBean(Message.class);
		// 这句将输出: hello world
		System.out.println(messageService.message());

	}
}
