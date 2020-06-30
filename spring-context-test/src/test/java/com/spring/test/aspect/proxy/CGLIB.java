package com.spring.test.aspect.proxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib则是基于asm框架，实现了无反射机制进行代理，利用空间来换取了时间，代理效率高于jdk
 * <p>
 * 使用JDK创建动态代理有一个限制, 即它只能为接口创建代理实例. 对于没有定义接口的业务方法的类,使用CGlib 进行动态代理.
 * <p>
 * CGLib是一个强大的, 高性能的代码生成库. 被广泛应用于 AOP 框架. 用以提供方法拦截操作.
 * <p>
 * CGLib采用底层的字节码技术, 可以为一个类创建子类,  在子类中采用方法拦截的技术拦截所有父类方法的调用, 并织入横切逻辑.
 * @author xuweizhi
 * @since 2019/03/16 18:37
 */
public class CGLIB {

}

/**
 * CGLIB(Code Generation Library)是一个开源项目！是一个强大的，高性能，高质量的Code生成类库，
 * <p>
 * 它可以在运行期扩展Java类与实现Java接口。Hibernate用它来实现PO(Persistent Object 持久化对象)字节码的动态生成。
 * <p>
 * CGLIB是一个强大的高性能的代码生成包。它广泛的被许多AOP的框架使用，例如Spring AOP为他们提供
 * <p>
 * 方法的interception（拦截）。CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。
 * <p>
 * 除了CGLIB包，脚本语言例如Groovy和BeanShell，也是使用ASM来生成java的字节码。当然不鼓励直接使用ASM，
 * <p>
 * 因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。
 * <p>
 * 实现一个业务类，注意，这个业务类并没有实现任何接口：
 */
class HelloService {

    public HelloService() {
        System.out.println("HelloService构造");
    }

    /**
     * 该方法不能被子类覆盖,Cglib是无法代理final修饰的方法的
     */
    final public String sayOthers(String name) {
        System.out.println("HelloService:sayOthers>>" + name);
        return null;
    }

    void sayHello() {
        System.out.println("HelloService:sayHello");
    }
}


/**
 * 自定义MethodInterceptor
 *
 * 这个接口只有一个intercept()方法，这个方法有4个参数：
 *
 * 1）obj表示增强的对象，即实现这个接口类的一个对象；
 *
 * 2）method表示要被拦截的方法；
 *
 * 3）args表示要被拦截方法的参数；
 *
 * 4）proxy表示要触发父类的方法对象；
 */
class MyMethodInterceptor implements MethodInterceptor {

    /**
     * @param sub         cglib生成的代理对象
     * @param method      被代理对象方法
     * @param objects     方法入参
     * @param methodProxy 代理方法
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======插入前置通知======");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("======插入后者通知======");
        return object;
    }
}

/**
 * 生成CGLIB代理对象调用目标方法：
 */
class Client {

    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建代理对象
        HelloService proxy = (HelloService) enhancer.create();
        // 通过代理对象调用目标方法
        proxy.sayHello();
    }

}

/**
 * 实现 MethodInterceptor 接口生成方法拦截
 */
class CglibProxy implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("横切逻辑开始执行");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("横切逻辑执行结束");
        return obj;
    }
}

/**
 * CGLib 定义的 intercept() 接口方法, 拦截所有目标类方法的调用.  其中 o 代表目标类的实例,
 * method 为目标类方法的反射;  args为方法的动态入参,  proxy为代理类实例.
 */
class CglibProxyTest {

    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        //enhancer.setSuperclass();
        enhancer.setCallback(new CglibProxy());
    }
}
