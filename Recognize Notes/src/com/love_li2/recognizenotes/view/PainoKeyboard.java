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
	
	private int keyWidth = 0,keyHeight = 0,keyNums = 16;
	Button[] whiteKeys = new Button[7];
	Button[] blackKeys = new Button[5];
	
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

	private void init(Context context) {
		setOrientation(LinearLayout.HORIZONTAL);
		WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
		Point outSize = new Point();
		wm.getDefaultDisplay().getSize(outSize );
		keyWidth = outSize.x / keyNums;
		keyHeight = keyWidth * 5;
		
		for(int i =0 ;i < 7 ; i++)
		{
			whiteKeys[i] = new Button(context);
			whiteKeys[i].setId(i);
			whiteKeys[i].setPadding(0, 0, 0, 0);
			whiteKeys[i].setOnClickListener(this);
			whiteKeys[i].setBackgroundResource(R.drawable.key_background);
			addView(whiteKeys[i]);
		}
		for(int i =0 ;i < 5 ; i++)
		{
			blackKeys[i] = new Button(context);
			blackKeys[i].setId(i+7);
			blackKeys[i].setPadding(0, 0, 0, 0);
			blackKeys[i].setOnClickListener(this);
			blackKeys[i].setBackgroundColor(Color.BLACK);
			addView(blackKeys[i]);
		}
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		setMeasuredDimension(keyWidth * 7, keyHeight);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		for(int i =0 ;i < 7 ; i++)
		{
			whiteKeys[i].layout(i*keyWidth, 0, (i+1) * keyWidth, keyHeight);
		}
		blackKeys[0].layout((int)(keyWidth * 0.5), 0, (int)(keyWidth * (0.5 + 5.0/7)), keyHeight/3*2);
		blackKeys[1].layout((int)(keyWidth * (1 + 5.0/7)), 0, (int)(keyWidth * (1 + 5.0/7 + 5.0/7)), keyHeight/3*2);
		blackKeys[2].layout((int)(keyWidth * 3.5), 0, (int)(keyWidth * 4.2), keyHeight/3*2);
		blackKeys[3].layout((int)(keyWidth * 4.5), 0, (int)(keyWidth * 5.2), keyHeight/3*2);
		blackKeys[4].layout((int)(keyWidth * 5.5), 0, (int)(keyWidth * 6.2), keyHeight/3*2);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(getContext(), ""+v.getId(), 0).show();
	}
	
}
