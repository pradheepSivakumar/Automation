package com.saucelab.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.saucelab.constants.FrameworkConstants;
import com.saucelab.enums.ConfigProperties;

public final class PropertyUtils {

	private PropertyUtils() {

	}

	private static Properties property = new Properties();
	private static final HashMap<String, String> CONFIGMAP = new HashMap<>();

	static {

		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
			property.load(file);

			/*
			 * for(Object key:property.keySet()) {
			 * CONFIGMAP.put(String.valueOf(key),String.valueOf(property.get(key))); }
			 */

			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String get(ConfigProperties key) throws Exception {

		if (Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) || Objects.isNull(key)) {
			throw new Exception("Property name " + key + " not found. Please check config.properties file");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

	/*
	 * private static Properties property = new Properties();
	 *
	 * static {
	 *
	 * try { FileInputStream file = new FileInputStream(
	 * System.getProperty("user.dir") +
	 * "/src/test/resources/config/config.properties"); property.load(file); } catch
	 * (IOException e) { e.printStackTrace(); }
	 *
	 * }
	 *
	 * public static String getValue(String key) throws Exception {
	 *
	 * if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) { throw
	 * new Exception("Property name " + key +
	 * " not found.Please check config.properties"); } return
	 * property.getProperty(key);
	 *
	 *
	 * }
	 */
}
