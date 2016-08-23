package com.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public static String endPointUrl;
	
	public void loadProperties() throws IOException {
		Properties props = new Properties();
		FileReader reader = new FileReader(new File(String.format("%s/config.properties",System.getProperty("user.dir"))));
		props.load(reader);
		endPointUrl = props.getProperty("endPointUrl");
	}

	public String getEndPointUrl() {
		return endPointUrl;
	}
}
