package com.example.volleyimagerequest;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application {
	private static RequestQueue queue;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		queue = Volley.newRequestQueue(getApplicationContext());
	}

	public static RequestQueue getHttpRequestQueue() {

		return queue;
	}
}
