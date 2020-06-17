package com.spring.test.bean.properties;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;
import org.springframework.util.PropertyPlaceholderHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CustomPropertyConfig extends PropertySourcesPlaceholderConfigurer {

	private Resource[] locations;

	private PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();

	@Override
	public void setLocations(Resource[] locations) {
		this.locations = locations;
	}

	@Override
	public void setLocalOverride(boolean localOverride) {
		this.localOverride = localOverride;
	}

	/**
	 * 覆盖这个方法，根据启动参数，动态读取配置文件，ApplicationContext refresh 方法调用
	 * <p>
	 * {@link PropertySourcesPlaceholderConfigurer#postProcessBeanFactory}
	 * <p>
	 * {@link PropertyPlaceholderHelper#parseStringValue} 解析 ${student.name}
	 *
	 * 对 ${class.filed} 属性值的解析
	 */
	@Override
	protected void loadProperties(Properties props) throws IOException {
		if (locations != null) {
			// locations 里面就已经包含了那三个定义的文件
			for (Resource location : this.locations) {
				InputStream is = null;
				try {
					String filename = location.getFilename();
					String env = "application-" + System.getProperty("spring.profiles.active", "dev") + ".properties";

					// 找到我们需要的文件，加载
					if (filename.contains(env)) {
						logger.info("Loading properties file from " + location);
						is = location.getInputStream();
						this.propertiesPersister.load(props, is);

					}
				} catch (IOException ex) {
					logger.info("读取配置文件失败.....");
					throw ex;
				} finally {
					if (is != null) {
						is.close();
					}
				}
			}
		}
	}
}
