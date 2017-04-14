package com.example.volley;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import android.content.Context;
/***
 * 
 * @author zmw
 *   这是一个将errorlistener和successlistener封装的类
 *   采用接口回调
 */
public abstract class SelfVolley {
	public Listener<String> listener;
	public ErrorListener errorListener;
	private Context context;
	public SelfVolley(Context context) {
		this.context = context;
	}
	
	
	public abstract void onSuccess(String str);		//两个抽象类；
	public abstract void onFailed(String str);
	
	public Listener<String> getListener(){
		listener = new Listener<String>() {

			@Override
			public void onResponse(String arg0) {
				// TODO Auto-generated method stub
				onSuccess(arg0);
			}
		};
		return listener;
	}
	public ErrorListener getErrorListener(){
		errorListener = new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				onFailed(arg0.toString());
			}
		};
		return errorListener;
	}
}
