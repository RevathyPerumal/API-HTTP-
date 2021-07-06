package com.Http.Clientdemo;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_005_DeleteMethod {
@Test
	public void delete() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient  = HttpClients.createDefault();
    	HttpDelete httpDelete = new HttpDelete("https://petstore.swagger.io/v2/pet/204");
    	CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpDelete);
    	EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
    	
    	System.out.println("*****Delete Method*****");
    	
    	//Status code
    	int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status line
		StatusLine line = closeableHttpResponse.getStatusLine();
		System.out.println("StatusLine:" +line);
	}
}
