package com.love_li2.recognizenotes.view;

import com.love_li2.recognizenotes.R;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PainoKeyboard extends LinearLayout implements OnClickListener {
	String TAG = "PainoKeyboard";

	private int whiteKeyWidth = 0, blackeyWidth = 0, keyHeight = 0, keyNums = 16;
	Button[] whiteKeys = new Button[7];
	Button[] blackKeys = new Button[5];
	int beginIndex = 0, endIndex = 6;

	public PainoKeyboard(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public PainoKeyboard(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public PainoKeyboard(Context context) {
		super(context);
		init(context);
	}

	public void setBeginAndEnd(int b, int e) {
		beginIndex = b;
		endIndex = e;
		if (beginIndex == 5) {
			blackKeys[3].setVisibility(View.GONE);
		} else if (endIndex == 0) {
			blackKeys[0].setVisibility(View.GONE);
		}
	}

	private void init(Context context) {
		setOrientation(LinearLayout.HORIZONTAL);
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		Point outSize = new Point();
		wm.getDefaultDisplay().getSize(outSize);
		whiteKeyWidth = outSize.x / keyNums;
		blackeyWidth = whiteKeyWidth * 5 / 7;
		keyHeight = whiteKeyWidth * 5;

		for (int i = 0; i < 7; i++) {
			whiteKeys[i] = new Button(context);
			whiteKeys[i].setId(i);
			whiteKeys[i].setPadding(0, 0, 0, 0);
			whiteKeys[i].setOnClickListener(this);
			whiteKeys[i].setBackgroundResource(R.drawable.key_background);
			addView(whiteKeys[i]);
		}
		for (int i = 0; i < 5; i++) {
			blackKeys[i] = new Button(context);
			blackKeys[i].setId(i + 7);
			blackKeys[i].setPadding(0, 0, 0, 0);
			blackKeys[i].setOnClickListener(this);
			blackKeys[i].setBackgroundColor(Color.BLACK);
			addView(blackKeys[i]);
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		setMeasuredDimension(whiteKeyWidth * (endIndex - beginIndex + 1), keyHeight);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 7; i++) {
			whiteKeys[i].layout((i - beginIndex) * whiteKeyWidth, 0, (i - beginIndex + 1) * whiteKeyWidth, keyHeight);
		}
		blackKeys[0].layout((int) (whiteKeyWidth * (0.5 - beginIndex)), 0, (int) (whiteKeyWidth * (0.5 - beginIndex)) + blackeyWidth, keyHeight / 3 * 2);
		blackKeys[1].layout((int) (whiteKeyWidth * (1.7 - beginIndex)), 0, (int) (whiteKeyWidth * (1.7 - beginIndex)) + blackeyWidth, keyHeight / 3 * 2);
		blackKeys[2].layout((int) (whiteKeyWidth * (3.45 - beginIndex)), 0, (int) (whiteKeyWidth * (3.45 - beginIndex)) + blackeyWidth, keyHeight / 3 * 2);
		blackKeys[3].layout((int) (whiteKeyWidth * (4.65 - beginIndex)), 0, (int) (whiteKeyWidth * (4.65 - beginIndex)) + blackeyWidth, keyHeight / 3 * 2);
		blackKeys[4].layout((int) (whiteKeyWidth * (5.85 - beginIndex)), 0, (int) (whiteKeyWidth * (5.85 - beginIndex)) + blackeyWidth, keyHeight / 3 * 2);
	}

	@Override
	public void onClick(View v) {
	}
}
