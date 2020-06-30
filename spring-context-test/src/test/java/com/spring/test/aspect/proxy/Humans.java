package com.spring.test.aspect.proxy;

/**
 * @author xuweizhi
 * @since 2019/03/16 11:31
 */
public class Humans implements Behavior<String>, Interest<Integer> {


	@Override
	public void sing(String sing) {
		System.out.println("Sing :" + sing);
	}

	@Override
	public void dance(String dance) {
		System.out.println("Dance :" + dance);
	}

	@Override
	public void hobby(String hobby) {
		System.out.println("Hobby :" + hobby);
	}
}
