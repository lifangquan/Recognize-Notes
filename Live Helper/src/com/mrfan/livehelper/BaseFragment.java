package com.mrfan.livehelper;

import com.mrfan.livehelper.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class BaseFragment extends Fragment {
	protected TextView titleTextView;
	protected TextView leftButton;
	protected ImageView rightButton,rightButton2;
	protected RelativeLayout contentView, titleBar;
	private boolean isShowLeftBtn = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	protected abstract View _onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

	final protected void setTitle(String titleStr) {
		titleTextView.setText(titleStr);
	}

	final protected void setTitleVisibility(boolean isShow) {
		titleTextView.setVisibility(isShow ? View.VISIBLE : View.GONE);
	}

	final protected void setLeftButtonVisibility(boolean isShow) {
		isShowLeftBtn = isShow;
	}

	final protected void setRightButtonVisibility(boolean isShow) {
		rightButton.setVisibility(isShow ? View.VISIBLE : View.GONE);
	}

	final protected void setLeftButtonOnClickListener(OnClickListener listener) {
		leftButton.setOnClickListener(listener);
	}

	final protected void setRightButtonOnClickListener(OnClickListener listener) {
		rightButton.setOnClickListener(listener);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View mView = inflater.inflate(R.layout.fragment_base, null);
		contentView = (RelativeLayout) mView.findViewById(R.id.base_fragment_content);
		titleBar = (RelativeLayout) mView.findViewById(R.id.base_fragment_title_bar);
		titleTextView = (TextView) mView.findViewById(R.id.base_fragment_title);
		leftButton = (TextView) mView.findViewById(R.id.base_fragment_title_left_btn);
		rightButton = (ImageView) mView.findViewById(R.id.base_fragment_title_right_btn);
		rightButton2 = (ImageView) mView.findViewById(R.id.base_fragment_title_right_btn2);

		leftButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getActivity().onBackPressed();
			}
		});

		contentView.addView(_onCreateView(inflater, container, savedInstanceState));

		return mView;
	}
//
//	@Override
//	public void onActivityCreated(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		if (isShowLeftBtn && 0 < getBaseActivity().getFragmentCount())
//			leftButton.setVisibility(View.VISIBLE);
//		else
//			leftButton.setVisibility(View.GONE);
//
//		super.onActivityCreated(savedInstanceState);
//	}

	public BaseActivity getBaseActivity() {
		return (BaseActivity) super.getActivity();
	}
}
