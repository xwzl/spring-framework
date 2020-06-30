package com.spring.test.aspect.proxy;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author xuweizhi
 * @since 2019/03/16 15:05
 */
public abstract class Animal<T> implements Behavior<T>, Interest<T> {

    private Class<T> clazz;

    private String className;

    public Animal() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type actualArgument = parameterizedType.getActualTypeArguments()[0];
        clazz = (Class<T>) actualArgument.getClass();
        className = clazz.getSimpleName();
    }

}

class Cat extends Animal<Cat>{

    public Cat() {

    }

    @Override
    public void sing(String sing) {

    }

    @Override
    public void dance(String dance) {

    }

    @Override
    public void hobby(String hobby) {

    }
}
