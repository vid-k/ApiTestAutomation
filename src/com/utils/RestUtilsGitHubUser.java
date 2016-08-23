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

public class RestUtilsGitHubUser {

	HttpUriRequest request;
	HttpResponse response;
	GitHubUser user;
	List<GitHubUser> users;
	String URI = Configuration.githubUrl;


	public <X> void getRequestGitHubUser(String resourceUrl, Class<X> cl) {
		this.request = new HttpGet(URI+resourceUrl);
		this.request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		try {
			this.response = HttpClientBuilder.create().build().execute(request);
		
			if (null != response) {
				if (cl.equals(GitHubUser.class))
					setUser(ResourceUtils.retrieveResource(response, cl));
				else if (cl.equals(GitHubUser[].class)) {
					List<GitHubUser> users = ResourceUtils.retrieveResources(response, GitHubUser[].class);
					setGitHubUsers(users);				
				}
			} else
				System.out.println("Something went wrong with GET, response is: " + response);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public GitHubUser getGitHubUser() {
		return this.user;
	}

	public GitHubUser getGitHubUser(int n) {
		return users.get(n);
	}
	
	public <X> void setUser(X user) {
		this.user = (GitHubUser) user;
	}

	public List<GitHubUser> getGitHubUsers() {
		return this.users;
	}
	
	public <X> void setGitHubUsers(List<X> users) {
		this.users = (List<GitHubUser>) users;
	}
	
	public int getStatusCode() {
		return this.response.getStatusLine().getStatusCode();
	}

	public Header[] getHeaders() {
		return this.response.getAllHeaders();
	}
}
