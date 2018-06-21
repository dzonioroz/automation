package webApi.automation.handlers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

	public static Properties dataProperties;
	private static final String DATA_PROPERTIES_LOCATION = "src/test/resources/properties/data.properties";
	private static final String ENVIRONMENT_PROPERTIES_LOCATION = "src/test/resources/properties/environment.properties";
	public static Properties environmentProperties;
	public static Properties restProperties;
	private static final String REST_PROPERTIES_LOCATION = "src/test/resources/properties/rest.properties";

	public PropertiesLoader() {
		dataProperties = loadProperties(DATA_PROPERTIES_LOCATION);
		environmentProperties = loadProperties(ENVIRONMENT_PROPERTIES_LOCATION);
		restProperties = loadProperties(REST_PROPERTIES_LOCATION);
	}

	public Properties loadProperties(String pathResource) {
		try {
			Properties properties = new Properties();
			InputStream inputStream = new FileInputStream(pathResource);
			properties.load(inputStream);
			return properties;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getDataProperty(String key) {
		String value = null;
		if (System.getProperty(key) != null) {
			value = System.getProperty(key);
		} else if (dataProperties.containsKey(key))
			value = dataProperties.getProperty(key);
		return value;
	}

	public String getEnvProperty(String key) {
		String value = null;
		if (System.getProperty(key) != null) {
			value = System.getProperty(key);
		} else if (environmentProperties.containsKey(key))
			value = environmentProperties.getProperty(key);
		return value;
	}

	public String getRestProperty(String key) {
		String value = null;
		if (System.getProperty(key) != null) {
			value = System.getProperty(key);
		} else if (restProperties.containsKey(key))
			value = restProperties.getProperty(key);
		return value;
	}

}
