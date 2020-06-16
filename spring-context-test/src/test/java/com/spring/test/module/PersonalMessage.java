package com.spring.test.module;

/**
 * 私人消息
 *
 * @author xuweizhi
 * @since 2020/06/15 10:19
 */
public class PersonalMessage implements Message {


    @Override
    public String message() {
        return "私人信息";
    }
}
