package com.spring.test.aspect.proxy;

/**
 * 代理类的生成工具
 *
 * @since 2019-4-2
 */
public class ProxyGeneratorUtils {

	/**
	 * 把代理类的字节码写到硬盘上
	 *
	 * @param path 保存路径
	 */
	public static void writeProxyClassToHardDisk(String path) {
		// 第一种方法
		 System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);

		// 第二种方法

		// 获取代理类的字节码
		//byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy11", JdkProxy.class.getInterfaces());
		//
		//FileOutputStream out = null;
		//
		//try {
		//	out = new FileOutputStream(path);
		//	out.write(classFile);
		//	out.flush();
		//} catch (Exception e) {
		//	e.printStackTrace();
		//} finally {
		//	try {
		//		out.close();
		//	} catch (IOException e) {
		//		e.printStackTrace();
		//	}
		//}
	}

	public static void main(String[] args) {
		ProxyGeneratorUtils.writeProxyClassToHardDisk("C://x/$Proxy11.class");
	}

}
