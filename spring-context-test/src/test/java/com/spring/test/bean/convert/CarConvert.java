package com.spring.test.bean.convert;

import com.spring.test.module.Car;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * Car Convert
 *
 * @author xuweizhi
 * @since 2020/06/17 22:57
 */
public class CarConvert implements Converter<String, Car> {


	@Override
	public Car convert(String source) {
		if (StringUtils.hasLength(source)) {
			String[] split = source.split("#");
			Car car = new Car();
			car.setBrand(split[0]);
			car.setPrice(Double.parseDouble(split[1]));
			car.setDescription(split[2]);
			return car;
		}
		return null;
	}
}
