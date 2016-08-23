package com.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.utils.Configuration;

public abstract class BaseApiTest {
	Configuration _config;
	
	@BeforeSuite
	public void beforeSuite() {
		_config = new Configuration();
	}

	@AfterSuite
	public void afterSuite() {
		_config = null;
	}

}
