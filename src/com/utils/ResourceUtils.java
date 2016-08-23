package com.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.pojo.GitHubUser;

public class ResourceUtils {

	public static <X>X retrieveResource(HttpResponse response, Class<X> cl) {

		String json;

		try {
			json = EntityUtils.toString(response.getEntity());

			ObjectMapper mapper = new ObjectMapper();
			
			return mapper.readValue(json, cl);

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static <X>List<X> retrieveResources(HttpResponse response, Class<X[]> cl) {

		String json;

		try {
			json = EntityUtils.toString(response.getEntity());

			ObjectMapper mapper = new ObjectMapper();
			
			List<X> myUsers = (List<X>) Arrays.asList(mapper.readValue(json, cl));

			return myUsers;
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
