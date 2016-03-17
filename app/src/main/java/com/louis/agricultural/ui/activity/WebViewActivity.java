package com.louis.agricultural.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.app.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebViewActivity extends BaseActivity {

    @Bind(R.id.tools_bar)
    RelativeLayout mToolsBar;
    @Bind(R.id.webview)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {

        initTitle("");

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress > 80) {

                }
            }
        });

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        WebSettings setting = mWebView.getSettings();
        setting.setJavaScriptEnabled(true);
        // 设置 缓存模式
        setting.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 开启 DOM storage API 功能
        setting.setDomStorageEnabled(true);
        setting.setPluginState(WebSettings.PluginState.ON);
        setting.setJavaScriptCanOpenWindowsAutomatically(true);
        setting.setAllowFileAccess(true);
        setting.setDefaultTextEncodingName("UTF-8");
        setting.setLoadWithOverviewMode(true);
        setting.setUseWideViewPort(true);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if(intent != null){
            String id = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY);
            mWebView.loadUrl(Constants.MESSAGE_URL + id);
        }
    }

    @Override
    protected void click(View view) {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.onPause();
        }
    }
}
