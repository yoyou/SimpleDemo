package com.example.volley;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Request.Method;
import com.android.volley.Response.Listener;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

/***
 * 
 * @author zmw
 *		volley
 */

public class MainActivity extends ActionBarActivity {
	private StringRequest  request;
	private JsonObjectRequest ObjectRequest;
	private String url =  "http://api.juheapi.com/japi/toh?key=7bc8ff86168092de65576a6166bfc47b&v=1.0&month=11&day=1";
	private String URL_POST = "http://api.juheapi.com/japi/toh?";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		HashMap< String , String> map = new HashMap<String,String>();
		map.put("key", "7bc8ff86168092de65576a6166bfc47b");
		map.put("v", "1.0");
		map.put("month", "11");
		map.put("day", "1");
	//	StringRequest_GET();
//		JosonObjectRequest_GET();
//		StringRequest_POST();
//		JosonObjectRequest_POST();
		SelfVolley selfVolley = new SelfVolley(this) {		//获取errorlistener和successlistener对象
			
			@Override
			public void onSuccess(String str) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
			}
					
			@Override
			public void onFailed(String str) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
			}
		};
		VolleyRequest request = new  VolleyRequest();
//		request.StringRequest_GET("Stirng_request", url,selfVolley);
		request.StringRequest_POST("String_POST",URL_POST , selfVolley, map);
	}
	private void JosonObjectRequest_POST() {
		String  POST = "http://api.juheapi.com/japi/toh?";
		HashMap< String , String> map = new HashMap<String,String>();
		map.put("key", "7bc8ff86168092de65576a6166bfc47b");
		map.put("v", "1.0");
		map.put("month", "11");
		map.put("day", "1");
		JSONObject object = new JSONObject(map);
		ObjectRequest = new JsonObjectRequest(Method.POST, POST, object, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, arg0.toString(), Toast.LENGTH_LONG).show();
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				Log.e("LOGIN-ERROR", arg0.getMessage(), arg0);
				byte[] htmlBodyBytes = arg0.networkResponse.data;
				Log.e("LOGIN-ERROR", new String(htmlBodyBytes), arg0);
//				Toast.makeText(MainActivity.this, arg0.toString(), Toast.LENGTH_LONG).show();
			}
		});
		ObjectRequest.addMarker("ObjectRequest_POST");
		MyApplication.getHttpRequestQueue().add(ObjectRequest);
	}

	private void StringRequest_POST() {
		// TODO Auto-generated method stub
		String  POST = "http://api.juheapi.com/japi/toh?";
		request = new StringRequest(Method.POST, POST, new Listener<String>() {

			@Override
			public void onResponse(String arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, arg0, Toast.LENGTH_LONG).show();
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, arg0.toString(), Toast.LENGTH_LONG).show();
			}
		}){@Override
		protected Map<String, String> getParams() throws AuthFailureError {
			HashMap< String , String> map = new HashMap<String,String>();
			map.put("key", "7bc8ff86168092de65576a6166bfc47b");
			map.put("v", "1.0");
			map.put("month", "11");
			map.put("day", "1");
			return map;
		}};
		request.addMarker("StringRequest_GET");
		MyApplication.getHttpRequestQueue().add(request);
	}
	
	public void StringRequest_GET(){
	   
		request = new StringRequest(Method.GET, url, new Listener<String>() {
			 
			@Override
			public void onResponse(String arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, arg0, Toast.LENGTH_SHORT).show();
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, arg0.toString(), Toast.LENGTH_SHORT).show();
			}
		});
		request.addMarker("StringRequest_GET");
		MyApplication.getHttpRequestQueue().add(request);
	}
	public void JosonObjectRequest_GET(){
		ObjectRequest = new JsonObjectRequest(Method.GET, url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, arg0.toString(), Toast.LENGTH_SHORT).show();
			}
		}, new ErrorListener() {
			
			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, arg0.toString(), Toast.LENGTH_SHORT).show();
			}
		});
		ObjectRequest.addMarker("JosonObjectRequest_GET");
		MyApplication.getHttpRequestQueue().add(ObjectRequest);
	}
}
