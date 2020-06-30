package com.spring.test.aspect.proxy;


import java.lang.reflect.*;
import java.util.stream.Stream;

/**
 * @author xuweizhi
 * @since 2019/03/16 14:24
 */
public class ProxyGenericHandler<T, R> implements InvocationHandler {


    private final Method[] methods;

    private R r;

    private T t;

    public ProxyGenericHandler(T t, R r) {
        this.methods = r.getClass().getMethods();
        this.r = r;
        this.t = t;
        Type[] genericInterfaces = t.getClass().getGenericInterfaces();

        for (Type type : genericInterfaces) {
            ParameterizedType param = (ParameterizedType) type;
            Type value = param.getActualTypeArguments()[0];
            System.out.println("实现接口的泛型参数类型 : " + value);
        }

    }

    public static void main(String[] args) {
        //ProxyGenericHandler proxyHandler = new ProxyGenericHandler(new Humans());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Stream.of(methods).forEach(method1 -> {
            if (method1.getName().equals(method.getName())) {
                try {
                    method1.setAccessible(true);
                    method.setAccessible(true);
                    method1.invoke(r, args);
                    method.invoke(t, args);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
			}
        });
        return null;
    }
}
