package com.mrfan.livehelper.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class DataStoreUtil {
	private static String TAG = "DataStoreUtil";
	private static SharedPreferences livehelper_db;
	private static DataStoreUtil ds;

	public static DataStoreUtil getInstance(Context context) {
		if (ds == null)
			ds = new DataStoreUtil();
		if (livehelper_db == null && context != null)
			livehelper_db = context.getSharedPreferences("livehelper_db", Activity.MODE_PRIVATE);

		return ds;
	}

	public void writeDataToDb(String key, String value) {
		if (livehelper_db == null || TextUtils.isEmpty(key))
			return;

		Editor editor = livehelper_db.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public void writeIntToDb(String key, int value) {
		if (livehelper_db == null || TextUtils.isEmpty(key))
			return;

		Editor editor = livehelper_db.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public void writeLongToDb(String key, long value) {
		if (livehelper_db == null || TextUtils.isEmpty(key))
			return;

		Editor editor = livehelper_db.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	public long getLongFromDb(String key, int defaultValue) {
		if (livehelper_db == null) {
			return defaultValue;
		}
		long data = livehelper_db.getLong(key, defaultValue);
		return data;
	}

	public void setDataInDb(String key, String value) {
		if (livehelper_db == null || TextUtils.isEmpty(key))
			return;

		Editor editor = livehelper_db.edit();
		editor.remove(key);
		editor.putString(key, value);
		editor.commit();
	}

	public void setDataBooleanDb(String key, boolean value) {

		if (livehelper_db == null || TextUtils.isEmpty(key))
			return;

		Editor editor = livehelper_db.edit();
		editor.remove(key);
		editor.putBoolean(key, value);
		editor.commit();
	}

	public boolean getBooleanFromDb(String key, boolean defaultValue) {
		if (livehelper_db == null || TextUtils.isEmpty(key)) {
			return true;
		}
		boolean data = livehelper_db.getBoolean(key, defaultValue);
		return data;
	}

	public void removeDataFromDb(String key) {

		if (livehelper_db == null || TextUtils.isEmpty(key))
			return;

		Editor editor = livehelper_db.edit();
		editor.remove(key);
		editor.commit();
	}

	public static void clearAllData() {
		if (livehelper_db == null)
			return;
		Editor editor = livehelper_db.edit();
		editor.clear();
		editor.commit();
	}

	public String getDataFromDb(String key, String defaultValue) {
		if (livehelper_db == null || TextUtils.isEmpty(key)) {
			return null;
		}
		String data = livehelper_db.getString(key, defaultValue);
		return data;
	}

	public int getIntFromDb(String key, int defaultValue) {
		if (livehelper_db == null || TextUtils.isEmpty(key)) {
			return -1;
		}
		int data = livehelper_db.getInt(key, defaultValue);
		return data;
	}
}
