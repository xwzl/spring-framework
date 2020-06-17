package com.spring.test.bean.init;

import org.springframework.beans.factory.InitializingBean;

/**
 * Spring 在完成实例化后，设置完所有属性，进行 “Aware 接口” 和 “BeanPostProcessor 前置处理”之后，会接着检
 * 测当前 bean 对象是否实现了 InitializingBean 接口。如果是，则会调用其 #afterPropertiesSet() 方法，进一
 * 步调整 bean 实例对象的状态。
 */
public class Initializing implements InitializingBean {

	private String name;

	/**
	 * 从 #invokeInitMethods(...) 方法中，我们知道 init-method 指定的方法会在 #afterPropertiesSet() 方法之
	 * 后执行，如果 #afterPropertiesSet() 方法的执行的过程中出现了异常，则 init-method 是不会执行的，而且由于
	 * init-method 采用的是反射执行的方式，所以 #afterPropertiesSet() 方法的执行效率一般会高些，但是并不能排除
	 * 我们要优先使用 init-method，主要是因为它消除了 bean 对 Spring 的依赖，Spring 没有侵入到我们业务代码，这
	 * 样会更加符合 Spring 的理念。诚然，init-method 是基于 xml 配置文件的，就目前而言，我们的工程几乎都摒弃了配
	 * 置，而采用注释的方式，那么 @PreDestory 可能适合你，当然这个注解我们后面分析。
	 * <p>
	 * 至此，InitializingBean 和 init-method 已经分析完毕了，对于DisposableBean 和 destroy-method ，他们和
	 * init 相似，这里就不做阐述了。
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBeanTest initializing...");
		this.name = "baby 2 号";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
