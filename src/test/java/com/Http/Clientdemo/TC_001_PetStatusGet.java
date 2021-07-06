package com.Http.Clientdemo;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_001_PetStatusGet {
	@Test
	public void get() throws ClientProtocolException, IOException
	{
		System.out.println("*****PetByStatus*******");
		CloseableHttpClient httpClient  = HttpClients.createDefault();
	    HttpGet httpGet = new HttpGet("https://petstore.swagger.io/v2/pet/findByStatus?status=available&status=pending&status=sold");
	   // HttpGet httpGet = new HttpGet("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
	    CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
		
		//Validating Response body
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONArray jsonArray = new JSONArray(responseString);
		System.out.println("Response JSON " +jsonArray.toString(1));
		
		//Status Code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status Line
		StatusLine line = closeableHttpResponse.getStatusLine();
		System.out.println("StatusLine:" +line);
		
		//All Headers
		Header[] headerArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for(Header header : headerArray) {
		allHeaders.put(header.getName(), header.getValue());
				}
		System.out.println("Headers Array----->" +allHeaders);
		
		System.out.println("Total Pets :" + jsonArray.length());
		
		
		
	}
	

}
