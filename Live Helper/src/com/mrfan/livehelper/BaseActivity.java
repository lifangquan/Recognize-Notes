package com.mrfan.livehelper;

import com.mrfan.livehelper.R;
import com.mrfan.livehelper.fragment.LoginFragment;
import com.mrfan.livehelper.fragment.MainFragment;
import com.mrfan.livehelper.network.DataLoader;
import com.mrfan.livehelper.util.DataStoreUtil;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BaseActivity extends FragmentActivity {

	private FragmentManager fragmentManager;
	private TextView titleView;
	protected RelativeLayout titleBar;
	private Handler hander = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 200:
				postDelayed(new Runnable() {
					
					@Override
					public void run() {
						replace(new MainFragment(), false,false);
					}
				}, 1000);
				break;

			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_base);
		fragmentManager = getSupportFragmentManager();

		titleView = (TextView) findViewById(R.id.base_activity_title);
		titleBar = (RelativeLayout) findViewById(R.id.base_activity_title_bar);
		if (DataStoreUtil.getInstance(this).getBooleanFromDb("islogin", false))
			replace(new LoginFragment(), false);
		else
			DataLoader.post(this, "http://www.baidu.com", hander).execute();
	}

	public void setTitleVisibility(boolean isShow) {
		titleBar.setVisibility(isShow ? View.VISIBLE : View.GONE);
	}

	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		titleView.setText(title);
	}

	@Override
	public void setTitle(int titleId) {
		// TODO Auto-generated method stub
		titleView.setText(titleId);
	}

	public void replace(BaseFragment fragment) {
		replace(fragment, R.id.base_activity_content, true, R.anim.right_in, R.anim.right_out);
	}

	public void replace(BaseFragment fragment, boolean isAddToBackStack) {
		replace(fragment, R.id.base_activity_content, isAddToBackStack, R.anim.right_in, R.anim.right_out);
	}
	public void replace(BaseFragment fragment, boolean isAddToBackStack,boolean showAnim) {
		replace(fragment, R.id.base_activity_content, isAddToBackStack, showAnim?R.anim.right_in:R.anim.keep, showAnim?R.anim.right_out:R.anim.keep);
	}

	public void replace(BaseFragment fragment, int layoutID, boolean isAddToBackStack, int animIn, int animOut) {
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.setCustomAnimations(animIn, animOut).replace(layoutID, fragment);
		if (isAddToBackStack)
			fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}

	public void add(BaseFragment fragment) {
		add(fragment, R.id.base_activity_content, true, R.anim.right_in, R.anim.right_out);
	}

	public void add(BaseFragment fragment, boolean isAddToBackStack) {
		add(fragment, R.id.base_activity_content, isAddToBackStack, R.anim.right_in, R.anim.right_out);
	}

	public void add(BaseFragment fragment, int layoutID, boolean isAddToBackStack, int animIn, int animOut) {
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.setCustomAnimations(animIn, animOut).add(layoutID, fragment);
		if (isAddToBackStack)
			fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}

	final protected int getFragmentCount() {
		// TODO Auto-generated method stub
		return fragmentManager.getBackStackEntryCount();
	}
}
