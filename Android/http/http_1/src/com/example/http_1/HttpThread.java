package com.example.http_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.http.client.utils.URLEncodedUtils;

public class HttpThread extends Thread {
	private String name;
	private String age;
	
	public HttpThread(String name,String age){
		this.age = age;
		this.name = name;
	}
	@Override
	public void run() {
		super.run();
		
		doHttpGet(name,age);
	//	doHttpPost();
	}
	
	private void doHttpPost(){
		
		String PostUrl =  "http://192.168.0.7:8888/web/MyServlet";
		String str = "name=zhuang&age=24";
		String tmp;
		try {
			URL url = new URL(PostUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setReadTimeout(1000);
			OutputStream out = conn.getOutputStream();
			out.write(str.getBytes());
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer buffer = new StringBuffer();
			while ((tmp =  reader.readLine())!=null) {
				buffer.append(tmp);
			}
			System.out.println(buffer.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void doHttpGet(String name,String age) {
		name = "李四";
		String GetUrl = "";
		try {
			GetUrl = "http://192.168.0.7:8888/web/MyServlet?name="+URLEncoder.encode(name, "utf-8")+"&age=14";
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuffer buffer = new StringBuffer();
		String str;
		URL url;
		try {
			url = new URL(GetUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setReadTimeout(5000);
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while((str = reader.readLine()) != null)
			{
				buffer.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(buffer.toString());
	}
}
