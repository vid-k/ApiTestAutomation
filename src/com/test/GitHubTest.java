package com.test;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pojo.GitHubUser;
import com.utils.RestUtilsGitHubUser;

public class GitHubTest extends BaseApiTest {

	RestUtilsGitHubUser restUtil;

	@BeforeClass
	public void beforeClass() {
		restUtil = new RestUtilsGitHubUser();
		restUtil.getRequestGitHubUser("users/whiteboxhub", GitHubUser.class);
	}

	@Test
	public void testStatusCode() {
		Assert.assertEquals(restUtil.getStatusCode(), HttpStatus.SC_OK);
	}

	@Test
	public void testLoginId() {
		Assert.assertEquals(restUtil.getGitHubUser().getId(), "4023110");
	}

	@Test
	public void testLoginName() {
		Assert.assertEquals(restUtil.getGitHubUser().getName(), "WBL-Training");
	}

}
