package com.spring.test.file;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.net.URL;

/**
 * 绝对路径与相对路径测试
 *
 * @author xuweizhi
 * @since 2020/06/16 10:24
 */
public class PathTest {

	/**
	 * 获取当前类的绝对路径
	 */
	@Test
	public void classResource() {
		// 获取保路径
		URL packageClassPath = PathTest.class.getResource("");
		System.out.println("class 当前包路径：" + packageClassPath.getPath());
		// 获取类路径
		URL classPath = PathTest.class.getResource("PathTest.class");
		System.out.println("class 类路径:" + classPath.getPath());
		// class 文件根路径
		URL classRootPath = PathTest.class.getResource("/");
		System.out.println("class 根路径:" + classRootPath.getPath());

		// 与 PathTest.class.getResource("PathTest.class") 一致
		URL threadClassLoaderPath = Thread.currentThread().getContextClassLoader().getResource("");
		assert threadClassLoaderPath != null;
		// 我推荐使用Thread.currentThread（）.getContextClassLoader（）.getResource（""）来得到当前的
		// classpath的绝对路径的URI表示法
		System.out.println(threadClassLoaderPath.getPath());

		// 也是当前 ClassPath 的绝对 URI 路径
		URL systemResource = ClassLoader.getSystemResource("");
		System.out.println(systemResource.getPath());

	}
}
