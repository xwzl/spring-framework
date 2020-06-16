package com.spring.test;

import com.spring.test.bean.look_up.Display;
import com.spring.test.module.Book;
import com.spring.test.module.Car;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuweizhi
 * @since 2020/06/15 10:21
 */
public class SpringTest {

    @Test
    public void test(){
        // 用我们的配置文件来启动一个 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:XmlBeanFactory.xml");
        System.out.println("context 启动成功");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
		Object car1 = context.getBean("car");

		// look-up
		Display display = (Display) context.getBean("display");
		display.display();

		Car car = context.getBean(Car.class);
		Book bean = context.getBean(Book.class);
		DefaultListableBeanFactory factory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();

		BeanDefinition carBean = factory.getBeanDefinition("car");
		Object attribute = carBean.getAttribute("meta-test");

		System.out.println(attribute);
		// 这句将输出: hello world
        System.out.println(car);
    }

}
