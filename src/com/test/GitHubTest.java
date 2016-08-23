package com.test;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.utils.RestUtils;

public class GitHubTest extends BaseApiTest {

	RestUtils restUtil;

	@BeforeClass
	public void beforeClass() {
		restUtil = new RestUtils();
		restUtil.getRequest("users/whiteboxhub");
	}

	@Test
	public void testStatusCode() {
		Assert.assertEquals(restUtil.getStatusCode(), HttpStatus.SC_OK);
	}

	@Test
	public void testLoginId() {
		Assert.assertEquals(restUtil.getUser().getId(), "4023110");
	}

	@Test
	public void testLoginName() {
		Assert.assertEquals(restUtil.getUser().getName(), "WBL-Training");
	}

}
