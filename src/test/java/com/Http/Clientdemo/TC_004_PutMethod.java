package com.Http.Clientdemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_004_PutMethod {
	
	private static String REQUEST_PAYLOAD
	= "{\"id\": 204,\"category\": {\"id\": 12,\"name\":\"ramu\"},\"name\": \"rathi\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 0,\"name\": \"tagName\"}],\"status\": \"available\"}";
@Test
	public void put() throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient  = HttpClients.createDefault();
    	HttpPut httpPut = new HttpPut("https://petstore.swagger.io/v2/pet");
    	httpPut.setEntity(new StringEntity(REQUEST_PAYLOAD));
    	httpPut.addHeader("Content-Type","application/json");
    	CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPut);
    	System.out.println("*****Update Put Method******");
    	
    	//Status Code
    	int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status Line
		StatusLine line = closeableHttpResponse.getStatusLine();
		System.out.println("StatusLine:" +line);
		
		//Validating Response body
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("ResponseJSON" +responseJson);
    	
	}
}
