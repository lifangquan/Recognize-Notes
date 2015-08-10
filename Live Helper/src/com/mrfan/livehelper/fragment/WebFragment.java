package com.mrfan.livehelper.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mrfan.livehelper.R;
import com.mrfan.livehelper.BaseFragment;

public class WebFragment extends BaseFragment {

	private View contentView;
	private WebView webView;

	private String webUrl;

	WebFragment(String webUrl) {
		this.webUrl = webUrl;
	}

	@Override
	public View _onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setTitle("WebFragment");
		contentView = inflater.inflate(R.layout.web_fragment, null);
		webView = (WebView) contentView.findViewById(R.id.webfragment_webview);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl(webUrl);
		return contentView;
	}

}
