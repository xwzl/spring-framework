package com.spring.test.factory;


import com.spring.test.module.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * <h2>spring 中 BeanFactory 和 FactoryBean 的区别</h2>
 * BeanFactory 以Factory结尾，表示它是一个工厂类，用于管理Bean的一个工厂,在
 * Spring中，所有的Bean都是由BeanFactory(也就是IOC容器)来进行管理的。
 * <p>
 * 但对FactoryBean而言，这个Bean不是简单的Bean，而是一个能生产或者修饰对象生
 * 成的工厂Bean,它的实现与设计模式中的工厂模式和修饰器模式类似。
 *
 * <h3>BeanFactory</h3>
 * BeanFactory定义了IOC容器的最基本形式，并提供了IOC容器应遵守的的最基本的接
 * 口，也就是Spring IOC所遵守的最底层和最基本的编程规范。
 * <p>
 * 它的职责包括：实例化、定位、配置应用程序中的对象及建立这些对象间的依赖。
 * <p>
 * 在Spring代码中，BeanFactory只是个接口，并不是IOC容器的具体实现，但是 Spring
 * 容器给出了很多种实现，如 DefaultListableBeanFactory、XmlBeanFactory、
 * ApplicationContext等，都是附加了某种功能的实现。
 *
 * <h3>FactoryBean</h3>
 * 一般情况下，Spring通过反射机制利用<bean>的class属性指定实现类实例化Bean，在某些
 * 情况下，实例化Bean过程比较复杂.
 * <p>
 * 如果按照传统的方式，则需要在<bean>中提供大量的配置信息。配置方式的灵活性是受限的，
 * 这时采用编码的方式可能会得到一个简单的方案。
 * <p>
 * Spring为此提供了一个org.springframework.bean.factory.FactoryBean的工厂类接口，
 * 用户可以通过实现该接口定制实例化Bean的逻辑。
 * <p>
 * FactoryBean接口对于Spring框架来说占用重要的地位，Spring自身就提供了70多个FactoryBean
 * 的实现。
 * <p>
 * 它们隐藏了实例化一些复杂Bean的细节，给上层应用带来了便利。从Spring3.0开始，FactoryBean
 * 开始支持泛型，即接口声明改为FactoryBean<T>的形式
 *
 * @author xuweizhi
 * @since 2020/06/15 11:17
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    /**
     * 如果使用传统方式配置下面Car的<bean>时，Car的每个属性分别对应一个<property>元素标签.
     * <p>
     * 如果用FactoryBean的方式实现就灵活点，下例通过逗号分割符的方式一次性的为Car的所有属性指定配置值.
     * <p>
     * FactoryBean 相当于是生成并注入相应的属性
     *
     * @return 注入
     * @throws Exception 异常
     */
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setDescription(infos[1]);
        car.setPrice(Double.valueOf(infos[2]));
        return car;
    }

    public Class<Car> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public String getCarInfo() {
        return this.carInfo;
    }

    // 接受逗号分割符设置属性信息
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
