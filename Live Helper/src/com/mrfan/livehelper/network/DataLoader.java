package com.mrfan.livehelper.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

public class DataLoader extends AsyncTask<String, Integer, String> {

	private Context mContext;
	private String mType = "GET";
	private String mUrl;
	private Handler mHandler;

	static public DataLoader get(Context context, String url, Handler hander) {
		return new DataLoader(context, "GET", url, hander);
	}

	static public DataLoader post(Context context, String url, Handler hander) {
		return new DataLoader(context, "POST", url, hander);
	}

	public DataLoader(Context context, String type, String url, Handler hander) {
		super();
		mContext = context;
		mType = type;
		mUrl = url;
		mHandler = hander;
	}

	@Override
	protected String doInBackground(String... params) {
		String result = "", readLine = null;
		try {
			if (mType.equals("GET")) {
				mUrl = mUrl + "?" + params;
			}
			URL url = new URL(mUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(300);
			connection.setRequestMethod(mType);
			InputStreamReader isReader = new InputStreamReader(connection.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(isReader);
			while ((readLine = bufferedReader.readLine()) != null) {
				result += readLine;
			}
			isReader.close();
			connection.disconnect();
			
			if (mHandler != null) {
				Message msg = new Message();
				msg.what = connection.getResponseCode();
				msg.obj = result;
				mHandler.sendMessage(msg);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
