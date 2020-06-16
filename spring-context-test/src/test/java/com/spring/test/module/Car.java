package com.spring.test.module;


/**
 * Factory 测试
 * <p>
 * 如果使用传统方式配置下面 Car 的 <bean> 时，Car的每个属性分别对应一个 <property> 元素标签。
 *
 * @author xuweizhi
 * @since 2020/06/15 11:15
 */
public class Car {
	private String brand;

	private Double price;

	private String description;

	public Car() {
	}

	public Car(String brand, Double price, String description) {
		this.brand = brand;
		this.price = price;
		this.description = description;
	}

	public Car(String brand) {

	}

	public void init() {
		System.out.println("初始化方法");
	}

	public void cleanUp() {
		System.out.println("销毁方法");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
