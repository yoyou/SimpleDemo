package com.example.http_2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	private ListView listView;
	private TextView textView;
	private Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		listView = (ListView) findViewById(R.id.listview);
//		String url = "http://192.168.0.7:8888/JsonDemo/JsonServlet";
//		new JsonTHread(url, getApplicationContext(), listView, handler).start();
			String xmlurl = "http://192.168.0.7:8888/JsonDemo/Person.xml";
			textView = (TextView) findViewById(R.id.textview);
			new XmlThread(textView, xmlurl, handler).start();
			
	}

}
