package com.example.httpclient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String name;
		name = "wangwu";
		String GetUrl = "";
		try {
			GetUrl = "http://192.168.0.7:8888/web/MyServlet?name="+URLEncoder.encode(name, "utf-8")+"&age=14";
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String PostUrl = "http://192.168.0.7:8888/web/MyServlet";
		new HttpClientThread(PostUrl).start();
	}

}
