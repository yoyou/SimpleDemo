package com.example.volleyimagerequest;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	private ImageView view;
	private NetworkImageView imageView;
	private String URL= "http://pic20.nipic.com/20120409/9188247_091601398179_2.jpg";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view = (ImageView) findViewById(R.id.imageView);
		imageView = (NetworkImageView) findViewById(R.id.nivTestView);
		NetworkImage();
//			Image_Loader();
//		Image_request();
	}
	
	
	
	private void NetworkImage() {
		ImageLoader loader = new ImageLoader(MyApplication.getHttpRequestQueue(), new MyImageCache());
		imageView.setDefaultImageResId(R.drawable.ic_launcher);
		imageView.setErrorImageResId(R.drawable.ic_launcher);
		imageView.setImageUrl(URL, loader);
	}



	private void Image_Loader() {
		ImageLoader loader = new ImageLoader(MyApplication.getHttpRequestQueue(), new MyImageCache());
		ImageListener listener = ImageLoader.getImageListener(view, R.drawable.ic_launcher, R.drawable.abc_textfield_searchview_right_holo_light);
		loader.get(URL, listener);
		
	}
	private void Image_request() {
		@SuppressWarnings("deprecation")
		ImageRequest request = new ImageRequest(URL, new Listener<Bitmap>() {

			@Override
			public void onResponse(Bitmap arg0) {
				view.setImageBitmap(arg0);
			}
		}, 100, 100, Config.RGB_565, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				view.setBackgroundResource(R.drawable.ic_launcher);
			}
		});
		request.addMarker("imageRequest");
		MyApplication.getHttpRequestQueue().add(request);
	}
	
}
