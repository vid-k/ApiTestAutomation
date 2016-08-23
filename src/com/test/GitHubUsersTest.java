package com.test;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.RestUtils;

public class GitHubUsersTest {

	RestUtils restUtil;
	
	@BeforeClass
	public void beforeClass() {
		restUtil = new RestUtils();
		restUtil.getRequestGitHubUsers("users");
	}

	@Test
	public void testStatusCode() {
		Assert.assertEquals(restUtil.getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test
	public void testIsLoginPresent() {
		Assert.assertTrue(restUtil.getUser(0).getLogin().equals("mojombo") && restUtil.getUser(0).getId().equals("1"));
	}
	
	@Test
	public void testIsTypeOrganization() {
		Assert.assertTrue(restUtil.getUser(27).getLogin().equals("errfree") && restUtil.getUser(27).getType().equals("Organization"));
	}
		
}
