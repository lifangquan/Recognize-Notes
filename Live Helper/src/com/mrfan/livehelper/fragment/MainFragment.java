package com.mrfan.livehelper.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;

import com.mrfan.livehelper.R;
import com.mrfan.livehelper.BaseFragment;

public class MainFragment extends BaseFragment {

	private View contentView;
	private RelativeLayout talkView, myCommunityView, communityView, MyPageView;

	private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			switch (checkedId) {
			case R.id.main_menu_talk:
				talkView.setVisibility(View.VISIBLE);
				myCommunityView.setVisibility(View.INVISIBLE);
				communityView.setVisibility(View.INVISIBLE);
				MyPageView.setVisibility(View.INVISIBLE);
				break;
			case R.id.main_menu_mycommunity:
				talkView.setVisibility(View.INVISIBLE);
				myCommunityView.setVisibility(View.VISIBLE);
				communityView.setVisibility(View.INVISIBLE);
				MyPageView.setVisibility(View.INVISIBLE);
				break;
			case R.id.main_menu_community:
				talkView.setVisibility(View.INVISIBLE);
				myCommunityView.setVisibility(View.INVISIBLE);
				communityView.setVisibility(View.VISIBLE);
				MyPageView.setVisibility(View.INVISIBLE);
				break;
			case R.id.main_menu_me:
				talkView.setVisibility(View.INVISIBLE);
				myCommunityView.setVisibility(View.INVISIBLE);
				communityView.setVisibility(View.INVISIBLE);
				MyPageView.setVisibility(View.VISIBLE);
				break;
			}
		}
	};

	@Override
	public View _onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setTitle("MainFragment");
		leftButton.setVisibility(View.VISIBLE);
		leftButton.setText(R.string.app_name);
		leftButton.setClickable(false);
		rightButton.setVisibility(View.VISIBLE);
		rightButton2.setVisibility(View.VISIBLE);
		titleTextView.setVisibility(View.INVISIBLE);
		rightButton.setImageResource(R.drawable.ic_launcher);
		rightButton2.setImageResource(R.drawable.ic_launcher);
		contentView = inflater.inflate(R.layout.main_fragment, null);

		RadioGroup menuGroup = (RadioGroup) contentView.findViewById(R.id.main_menu_bar);
		menuGroup.setOnCheckedChangeListener(onCheckedChangeListener);

		talkView = (RelativeLayout) contentView.findViewById(R.id.talk_contentview);
		myCommunityView = (RelativeLayout) contentView.findViewById(R.id.mycommunity_contentview);
		communityView = (RelativeLayout) contentView.findViewById(R.id.community_contentview);
		MyPageView = (RelativeLayout) contentView.findViewById(R.id.me_contentview);

		return contentView;
	}

}
