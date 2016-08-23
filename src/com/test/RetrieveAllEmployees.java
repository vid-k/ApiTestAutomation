package com.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.RestUtils;

//GET-/employees/designations
public class RetrieveAllEmployees extends BaseApiTest {

	RestUtils restUtil;

	@BeforeClass
	public void setup() {
		restUtil = new RestUtils();
	}

	@Test
	public void testStatusCode() {
		restUtil.getRequest("/api/v1/lookup/employee/designations/5");
		System.out.println(restUtil.getStatusCode());
		assertEquals(restUtil.getStatusCode(), 200);
	}

	@Test
	public void testHeader() {
		Header[] headers = restUtil.getHeaders();
		for (Header h : headers) {
			System.out.println(h.getName() + ":" + h.getValue());
			if (h.getName().equals("Content-Type"))
				assertTrue(h.getValue().equals("application/json; charset=UTF-8"));
		}
	}

}
