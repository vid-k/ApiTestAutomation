package com.utils;

import java.io.IOException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import com.pojo.GitHubUser;

public class RestUtils {

	HttpUriRequest request;
	HttpResponse response;
	GitHubUser user;
	List<GitHubUser> users;
	String URI = Configuration.githubUrl;

	public void getRequestGitHubUser(String resourceUrl) {
		this.request = new HttpGet(URI+resourceUrl);
		this.request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		try {
			this.response = HttpClientBuilder.create().build().execute(request);
			setUser(ResourceUtils.retrieveResource(response, GitHubUser.class));
			
			if (null != response) {

			} else
				System.out.println("Something went wrong with GET, response is: " + response);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getRequestGitHubUsers(String resourceUrl) {
		this.request = new HttpGet(URI+resourceUrl);
		this.request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		try {
			this.response = HttpClientBuilder.create().build().execute(request);
			List<GitHubUser> users = ResourceUtils.retrieveResources(response, GitHubUser[].class);
			setUsers(users);
			
			if (null != response) {

			} else
				System.out.println("Something went wrong with GET, response is: " + response);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public GitHubUser getUser() {
		return this.user;
	}

	public GitHubUser getUser(int n) {
		return users.get(n);
	}
	
	public void setUser(GitHubUser user) {
		this.user = user;
	}

	public List<GitHubUser> getUsers() {
		return this.users;
	}
	
	public void setUsers(List<GitHubUser> users) {
		this.users = users;
	}
	
	public int getStatusCode() {
		return this.response.getStatusLine().getStatusCode();
	}

	public Header[] getHeaders() {
		return this.response.getAllHeaders();
	}
}
