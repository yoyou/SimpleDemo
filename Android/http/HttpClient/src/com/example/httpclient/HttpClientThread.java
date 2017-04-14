package com.example.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientThread extends Thread{
	private String url;
	private String name;
	private String age;
	public HttpClientThread(String url,String name,String  age){
		this.age = age;
		this.name = name;
		this.url = url;
	}
	public HttpClientThread(String url){
		this.url = url;
	}
	private void doHttpClientGet(){
		HttpGet get = new HttpGet(url);
		HttpClient client = new DefaultHttpClient();
		try {
			HttpResponse response =client.execute(get);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//				System.out.println(response.getEntity().toString());
				System.out.println(EntityUtils.toString(response.getEntity()));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void doHttpClientPost(){
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		
		ArrayList<NameValuePair> list = new ArrayList<>();			//post请求参数的传递对象
		list.add(new BasicNameValuePair("name", "zhuang"));
		list.add(new BasicNameValuePair("age", "11"));
		try {
			post.setEntity(new UrlEncodedFormEntity(list));
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				System.out.println(response.getEntity().toString());
				System.out.println(EntityUtils.toString(response.getEntity()));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
//		doHttpClientGet();
		doHttpClientPost();
	}
	
	
	
}
