package com.example.volley;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application {
	private static RequestQueue queue;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		queue = Volley.newRequestQueue(getApplicationContext());		//volley中的消息通道（全局）
	}
	
	public static RequestQueue getHttpRequestQueue(){  //类方法直接返回
		return queue;
	}
}
