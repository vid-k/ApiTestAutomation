package com.utils;

import java.io.IOException;

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
	String URI = Configuration.githubUrl;

	public void getRequest(String resourceUrl) {
		this.request = new HttpGet(URI+resourceUrl);
		this.request = new HttpGet("https://api.github.com/users/whiteboxhub");
		this.request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		try {
			this.response = HttpClientBuilder.create().build().execute(request);
			setUser(ResourceUtils.retrieveResource(response, GitHubUser.class));
			if (null != response) {

			} else
				System.out.println("Something went wrong with GET, response is: " + response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public GitHubUser getUser() {
		return this.user;
	}

	public void setUser(GitHubUser user) {
		this.user = user;
	}

	public int getStatusCode() {
		return this.response.getStatusLine().getStatusCode();
	}

	public Header[] getHeaders() {
		return this.response.getAllHeaders();
	}
}
