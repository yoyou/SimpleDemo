package com.volley.zmw.volley;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volley_Get();
    }

    private void volley_Get() {
        String URL = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15850781443";
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        request.setTag("String_VolleyGet");
        Myapplication.getHttpQueue().add(request);
    }
}
