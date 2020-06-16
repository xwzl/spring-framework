package com.spring.test.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 获取 Spring Context 对象
 *
 * @author xuweizhi
 * @since 2020/06/15 13:45
 */
public class SpringContextUtil {

    /**
     * 获取 xml context
     *
     * @param xmlPath xml path
     * @return spring context
     */
    public static ClassPathXmlApplicationContext context(String xmlPath) {
        return new ClassPathXmlApplicationContext(xmlPath);
    }
}
