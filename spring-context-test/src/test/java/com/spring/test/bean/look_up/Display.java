package com.spring.test.bean.look_up;

/**
 * lookup-method ：获取器注入，是把一个方法声明为返回某种类型的 bean 但实际要返回的 bean 是在配置
 * 文件里面配置的。该方法可以用于设计一些可插拔的功能上，解除程序依赖。
 */
public abstract class Display {

	public void display() {
		getCar().display();
	}

	public abstract Car getCar();

}
