package com.uuch.android_zxinglibrary.LoginAndReg;


import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class WebUtil {
	public static String getJSONArrayByWeb(String methodName,
                                           JSONArray params) {


		String abc=params.toString();
        final StringBuffer responseResult = new StringBuffer();
		HttpURLConnection httpURLConnection = null;
		String result = null;
		try {
			httpURLConnection = (HttpURLConnection) new URL(Config.SERVER_IP + "/Biyesheji/servlet/"
					+ methodName).openConnection();
			httpURLConnection.setRequestMethod("POST");

			httpURLConnection.setRequestProperty("Content-type", "application/json");
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setRequestProperty("accept", "*/*");
			httpURLConnection.setConnectTimeout(30000);
			httpURLConnection.connect();


			DataOutputStream out = new DataOutputStream(httpURLConnection.getOutputStream());
;
				out.write(abc.getBytes("utf-8"));
				if (httpURLConnection.getResponseCode() == 200) {
					InputStream in = httpURLConnection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder s = new StringBuilder();
					String line;
					//读取服务器返回的数据
					while ((line = reader.readLine()) != null) {
						s.append(line);
					}
				result=s.toString();
					reader.close();
			}
			out.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}




}
