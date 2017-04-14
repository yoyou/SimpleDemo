package com.example.http_2;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.example.util.XmlPerson;

import android.os.Handler;
import android.util.Xml;
import android.widget.TextView;

public class XmlThread extends Thread {
	private TextView textView;
	private String url;
	private Handler handler;

	public XmlThread(TextView textView, String url, Handler handler) {

		this.textView = textView;
		this.url = url;
		this.handler = handler;
	}

	@Override
	public void run() {
		try {
			URL httpurl = new URL(url);
			URLConnection conn = httpurl.openConnection();
			InputStream in = conn.getInputStream();

			XmlPullParser parser = Xml.newPullParser();
			parser.setInput(in, "UTF-8");
			final List<XmlPerson> list = new ArrayList<XmlPerson>();
			XmlPerson xmlPerson = null;
			int eventype = parser.getEventType();

			while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
				String str = parser.getName();
				switch (eventype) {
				case XmlPullParser.START_DOCUMENT:

					break;
				case XmlPullParser.START_TAG:
					if ("Person".equals(str)) {
						xmlPerson = new XmlPerson();
					} else if ("name".equals(str)) {
						xmlPerson.setName(parser.nextText());
					} else if ("age".equals(str)) {
						xmlPerson.setAge(Integer.parseInt(parser.nextText()));
					} else if ("school".equals(str)) {
						xmlPerson.setSchool(parser.nextText());
					}
					break;
				case XmlPullParser.END_TAG:
					if ("Person".equals(str) && xmlPerson != null) {
						list.add(xmlPerson);
					}
					break;

				case XmlPullParser.END_DOCUMENT:

					break;

				default:
					break;
				}
				eventype = parser.next();
			}
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					textView.setText(list.toString());
				}
			});

		} catch (IOException | XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
