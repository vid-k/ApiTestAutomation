package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public static String githubUrl;
	public static String endPointUrl;

	public Configuration() {
		loadProperties();
	}

	public void loadProperties() {
		Properties props = new Properties();
		try {
			FileReader reader = new FileReader(
					new File(String.format("%s/src/com/resources/config.properties", System.getProperty("user.dir"))));
			props.load(reader);
			endPointUrl = props.getProperty("endPointUrl");
			githubUrl = props.getProperty("url");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
