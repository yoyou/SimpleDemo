package com.example.http_2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

public class HttpThread extends Thread {
	private String url;
	private Context context;
	private Handler handler;
	private ImageView imageView;
	public HttpThread(String url, Context context,Handler handler,ImageView imageView) {
		this.url = url;
		this.context = context;
		this.handler = handler;
		this.imageView = imageView;
	}

	@Override
	public void run() {
		try {
			URL httpurl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) httpurl
					.openConnection();
			conn.setRequestMethod("GET");
			conn.setReadTimeout(5000);

			final Bitmap bitmap = BitmapFactory.decodeStream(conn.getInputStream());
			
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					imageView.setImageBitmap(bitmap);
				}
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
