package com.example.httpurlconnection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;



import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	private WebView webView;
	private ImageView imageView;
	private Handler handler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		webView = (WebView) findViewById(R.id.webview);
		imageView = (ImageView) findViewById(R.id.imageview);
		String URL = "https://www.baidu.com/";
		String imageURL= "https://www.baidu.com/img/bd_logo1.png";
		
		
		new HttpThread(imageView, handler, imageURL).start();
		
	}

	
}
class HttpThread extends Thread{
	private WebView webView;
	private ImageView imageView;
	private Handler handler;
	private String url;
	private FileOutputStream out;
	private File download = null;
	public HttpThread(WebView webView,Handler handler,String url){
		this.webView = webView;
		this.url = url;
		this.handler = handler;
	}
	public HttpThread(ImageView imageView,Handler handler,String url){
		this.imageView = imageView;
		this.url = url;
		this.handler = handler;
	}
	
	@Override
	public void run() {
		URL httpurl;
		try {
			httpurl = new URL(url);
//			HttpURLConnection conn = (HttpURLConnection) httpurl.openConnection();
			HttpsURLConnection conn = (HttpsURLConnection) httpurl.openConnection();
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			InputStream inputStream = conn.getInputStream();//获取文件的输出流
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {		//判断SD卡是否存在
				File file = Environment.getExternalStorageDirectory();		//获取内存卡的地址
				download = new File(file, String.valueOf(System.currentTimeMillis()));		//新建一个文件
				out = new FileOutputStream(download);		//创建一个文件输入流
			}
			byte[] tmp = new byte[2*1024];
			int len;
			if (out != null) {
				
				while ((len = inputStream.read(tmp))!= -1) {
					out.write(tmp, 0, len);
				}
			}
			final Bitmap bitmap = BitmapFactory.decodeFile(download.getAbsolutePath());
			
//			final StringBuffer buffer = new StringBuffer();
//			String str;
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			while ((str= bufferedReader.readLine())!= null) {
//				buffer.append(str);
//			}
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
//					webView.loadData(buffer.toString(), "text/html;charset=utf-8", null);
					imageView.setImageBitmap(bitmap);
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}