package com.straybirds.dating.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.straybirds.dating.Configure;
import com.straybirds.dating.activity.LoginActivity;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class NetUtils {

	private static final String TAG = "NetUtils";
	
		/**
		 * 登陆的post方法
		 * @param userName 用户名
		 * @param password 密码
		 * @return
		 */
	public static String loginOfPost(String userName, String password,final Context context ) {
		System.out.println(userName+" "+password);
		HttpClient client = null;
		try {
			client = new DefaultHttpClient();
			
			HttpPost post = new HttpPost(Configure.SERVER_URL);
			
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			parameters.add(new BasicNameValuePair("user", userName));
			parameters.add(new BasicNameValuePair("password", password));
			
			
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, "utf-8");
			
			post.setEntity(entity);
			
			HttpResponse response = client.execute(post);	
			
			final int statusCode = response.getStatusLine().getStatusCode();
			((Activity) context).runOnUiThread(new Runnable() {

				@Override
				public void run() {
					Toast.makeText(context, "statusCode"+statusCode, 1).show();
				}
				
			});
			
			
			if(statusCode == 200) {
				
				InputStream is = response.getEntity().getContent();
				String text = getStringFromInputStream(is);
				return text;
			} else {
				Log.i(TAG, "失败: " + statusCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(client != null) {
				client.getConnectionManager().shutdown();	
			}
		}
		return null;
	}

	/**
	 * get方法
	 */
//	public static String loginOfGet(String userName, String password) {
//		HttpClient client = null;
//		try {
//			client = new DefaultHttpClient();
//			
//			String data = "user=" + userName + "&password=" + password;
//			HttpGet get = new HttpGet("http://172.22.65.7:8002/Home/Index/login?" + data);
//			
//			HttpResponse response = client.execute(get);	
//			
//			int statusCode = response.getStatusLine().getStatusCode();
//			
//			if(statusCode == 200) {
//				InputStream is = response.getEntity().getContent();
//				String text = getStringFromInputStream(is);
//				return text;
//			} else {
//				Log.i(TAG, "失败" + statusCode);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(client != null) {
//				client.getConnectionManager().shutdown();	
//			}
//		}
//		return null;
//	}
	
	/**
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	private static String getStringFromInputStream(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		
		while((len = is.read(buffer)) != -1) {
			baos.write(buffer, 0, len);
		}
		is.close();
		
		String html = baos.toString();	
		
		baos.close();
		return html;
	}
}
