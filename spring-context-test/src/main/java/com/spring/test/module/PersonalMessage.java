package com.spring.test.module;

import com.spring.test.interfaces.Message;

/**
 * 私人消息
 *
 * @author xuweizhi
 * @since 2020/06/15 9:50
 */
public class PersonalMessage implements Message {

	@Override
	public String message() {
		return "返回私人信息";
	}
}
