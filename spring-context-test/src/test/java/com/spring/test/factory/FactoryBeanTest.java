package com.spring.test.factory;

import com.spring.test.module.Car;
import com.spring.test.utils.SpringContextUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * FactoryBeanTest
 *
 * @author xuweizhi
 * @since 2020/06/15 13:41
 */
public class FactoryBeanTest {

    /**
     * 对此我的理解是 FactoryBean 把复杂 bean 实例简单化。
     * <p>
     * 当调用getBean("car")时，Spring通过反射机制发现CarFactoryBean实现了FactoryBean的接口，
     * 这时Spring容器就调用接口方法CarFactoryBean#getObject()方法返回。
     * <p>
     * 如果希望获取CarFactoryBean的实例，则需要在使用getBean(beanName)方法时在beanName前显示
     * 的加上"&"前缀：如getBean("&car");
     */
    @Test
    public void testCarFactoryBean() {
        ApplicationContext context = SpringContextUtil.context("classpath:factory/spring-book.xml");
        Car car = context.getBean(Car.class);
        // & 获取对应 factoryBean 工厂
        CarFactoryBean carFactoryBean = (CarFactoryBean) context.getBean("&car");
        System.out.println(car);
    }
}
