package com.mrfan.livehelper.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.mrfan.livehelper.R;
import com.mrfan.livehelper.BaseFragment;

public class LoginFragment extends BaseFragment {
	
	private View contentView;
	private Button loginBtn,forgetBtn;
	
	@Override
	public View _onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setTitle("Login");
		contentView = inflater.inflate(R.layout.login_layout, null);
		loginBtn = (Button)contentView.findViewById(R.id.login_btn);
		loginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getBaseActivity().replace(new MainFragment(),false);
			}
		});
		forgetBtn = (Button)contentView.findViewById(R.id.login_forgetpassword);
		forgetBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getBaseActivity().add(new WebFragment("http://www.baidu.com"));
			}
		});
		return contentView;
	}
}
