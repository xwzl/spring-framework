package com.spring.test.bean.replace_method;


import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * replaced-method ：可以在运行时调用新的方法替换现有的方法，还能动态的更新原有方法的逻辑。
 */
public class MethodReplace implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("我是替换方法");
		return null;
	}


}
