package com.spring.test.module;

/**
 * @author xuweizhi
 * @since 2020/06/17 23:03
 */
public class CarFactory {

	Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "CarFactory{" +
				"car=" + car +
				'}';
	}
}
