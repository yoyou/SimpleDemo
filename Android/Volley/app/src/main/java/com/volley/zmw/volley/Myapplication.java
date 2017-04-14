package com.volley.zmw.volley;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by zmw on 16-11-13.
 */

public class Myapplication extends Application {
    public static RequestQueue queue;   //请求队列需要全局 所以需要在Aplication中实例化

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());

    }

    public static RequestQueue getHttpQueue(){
        return queue;
    }
}
