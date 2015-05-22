package com.love_li2.recognizenotes;

import com.love_li2.recognizenotes.view.PainoKeyboard;

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
		 for (int i = 0; i < 9; i++) {
			PainoKeyboard painoKeyboard = new PainoKeyboard(this);
			switch (i) {
			case 0:
				painoKeyboard.setBeginAndEnd(5, 6);
				break;
			case 8:
				painoKeyboard.setBeginAndEnd(0, 0);
				break;
			default:
				painoKeyboard.setBeginAndEnd(0, 6);
				break;
			}
			keyboard.addView(painoKeyboard);
		}
	}
}
