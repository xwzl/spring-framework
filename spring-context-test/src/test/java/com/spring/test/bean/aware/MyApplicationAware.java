package com.spring.test.bean.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 感知，其实是 Spring 容器在初始化主动检测当前 bean 是否实现了 Aware 接口，如果实现了则回调其
 * set 方法将相应的参数设置给该 bean ，这个时候该 bean 就从 Spring 容器中取得相应的资源。
 *
 * <ul>
 *     <li>LoadTimeWeaverAware：加载Spring Bean时织入第三方模块，如AspectJ</li>
 *     <li>BeanClassLoaderAware：加载Spring Bean的类加载器</li>
 *     <li>BootstrapContextAware：资源适配器BootstrapContext，如JCA,CCI</li>
 *     <li>ResourceLoaderAware：底层访问资源的加载器</li>
 *     <li>BeanFactoryAware：声明BeanFactory</li>
 *     <li>PortletConfigAware：PortletConfig</li>
 *     <li>PortletContextAware：PortletContext</li>
 *     <li>ServletConfigAware：ServletConfig</li>
 *     <li>ServletContextAware：ServletContext</li>
 *     <li>MessageSourceAware：国际化</li>
 *     <li>ApplicationEventPublisherAware：应用事件</li>
 *     <li>NotificationPublisherAware：JMX通知</li>
 *     <li>BeanNameAware：声明Spring Bean的名字</li>
 * </ul>
 */
public class MyApplicationAware implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, ApplicationContextAware {

    private String beanName;

    private BeanFactory beanFactory;

    private ClassLoader classLoader;

    private ApplicationContext applicationContext;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("调用了 BeanClassLoaderAware 的 setBeanClassLoader 方法");
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用了 BeanFactoryAware 的 setBeanFactory 方法");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("调用了 BeanNameAware 的 setBeanName 方法");
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用了 ApplicationContextAware 的 setApplicationContext 方法");
        this.applicationContext = applicationContext;
    }

    public void display(){
        System.out.println("beanName:" + beanName);
        System.out.println("是否为单例：" + beanFactory.isSingleton(beanName));
        System.out.println("系统环境为：" + applicationContext.getEnvironment());
    }
}
