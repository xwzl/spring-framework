package com.spring.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJTest {

	@Pointcut("execution(* *.test(..))")
	public void test() {
	}

	@Before("test()")
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint p) {
		System.out.println("around.....before");
		Object o = null;
		try {
			o = p.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("around.....after");
		return o;
	}

	@After("test()")
	public void afterTest() {
		System.out.println("afterTest");
	}
}
