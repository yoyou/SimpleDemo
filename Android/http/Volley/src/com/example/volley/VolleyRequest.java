package com.example.volley;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.Request.Method;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
/**
 * 
 * @author zmw
 *		将VollyRequest的封装起来
 *
 */
public class VolleyRequest {
	private StringRequest request;

	public void StringRequest_GET(String TAG, String URL,SelfVolley selfVolley) {
		MyApplication.getHttpRequestQueue().cancelAll(TAG);
		request = new StringRequest(Method.GET, URL, selfVolley.getListener(),
				selfVolley.getErrorListener());
		request.addMarker(TAG);
		MyApplication.getHttpRequestQueue().add(request);
		MyApplication.getHttpRequestQueue().start();
	}

	public void StringRequest_POST(String TAG, String URL,SelfVolley selfVolley,final HashMap<String, String>map) {
		MyApplication.getHttpRequestQueue().cancelAll(TAG);
		request = new StringRequest(Method.POST, URL, selfVolley.getListener(),
				selfVolley.getErrorListener()) {
					
			protected Map<String, String> getPostParams()
					throws AuthFailureError {
				return map;
			}
		};
		request.addMarker(TAG);
		MyApplication.getHttpRequestQueue().add(request);
		MyApplication.getHttpRequestQueue().start();
	}
}
