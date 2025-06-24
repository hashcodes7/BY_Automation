package com.plm.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	
	private static Properties properties = new Properties();

	public PropertyReader(String filePath) {
		try {
			File file = new File(filePath);
			FileInputStream fileInput = new FileInputStream(file);
			properties.load(fileInput);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private Properties loadEnvironmentProperties() {
		Properties properties = new Properties();
		try {
			String configFile = "PLM/propertyStore/PLMApplicationPOC.properties";
			properties.load(PropertyReader.class.getClassLoader().getResourceAsStream(configFile));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public String getProperty(String key) {
		if (properties !=null) {
			return properties.getProperty(key, "key " + key + " is not present").toString();
		}
		return " properties file is blank ";
	}
}
