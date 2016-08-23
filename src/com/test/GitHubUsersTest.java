package com.test;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pojo.GitHubUser;
import com.utils.RestUtilsGitHubUser;

public class GitHubUsersTest {

	RestUtilsGitHubUser restUtil;
	
	@BeforeClass
	public void beforeClass() {
		restUtil = new RestUtilsGitHubUser();
		restUtil.getRequestGitHubUser("users", GitHubUser[].class);
	}

	@Test
	public void testStatusCode() {
		Assert.assertEquals(restUtil.getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test
	public void testIsLoginPresent() {
		Assert.assertTrue(restUtil.getGitHubUser(0).getLogin().equals("mojombo") && restUtil.getGitHubUser(0).getId().equals("1"));
	}
	
	@Test
	public void testIsTypeOrganization() {
		Assert.assertTrue(restUtil.getGitHubUser(27).getLogin().equals("errfree") && restUtil.getGitHubUser(27).getType().equals("Organization"));
	}
		
}
