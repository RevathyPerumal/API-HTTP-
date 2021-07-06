package com.Http.Clientdemo;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_003_FindGetMethod {
	@Test
	public void get() throws ClientProtocolException, IOException {

    	CloseableHttpClient httpClient  = HttpClients.createDefault();
    	HttpGet httpGet = new HttpGet("https://petstore.swagger.io/v2/pet/204");
    	CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
    	System.out.println("*****ADD Get Method******");
    	
    	//Status Code
    	int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status Line
		StatusLine line = closeableHttpResponse.getStatusLine();
		System.out.println("StatusLine:" +line);
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject jsonobj = new JSONObject(responseString);
		System.out.println("Total Pets :" + jsonobj.length());
		
    	
	}

}
