package com.love_li2.recognizenotes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private LinearLayout keyboard = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		 keyboard = (LinearLayout)findViewById(R.id.main_keyborad);
		 
	}
}
