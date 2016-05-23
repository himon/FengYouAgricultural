package com.louis.agricultural.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ProductDetailEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.ProductDetailEvent;
import com.louis.agricultural.presenter.ProductDetailsPresenter;
import com.louis.agricultural.ui.fragment.product.ProductFirstFragment;
import com.louis.agricultural.ui.view.IProductDetailsView;

import de.greenrobot.event.EventBus;

public class GoodsDetailActivity extends MVPBaseActivity<IProductDetailsView, ProductDetailsPresenter>
        implements IProductDetailsView {
    private FragmentManager mFragmentManager;

    @Bind(R.id.frame_layout)
    FrameLayout mFrameLayout;
    private String mId;
    private ProductDetailsPresenter mPreseter;
    private ProductDetailEntity.ResultBean mProductDetail;
    private ProductFirstFragment mProductFirstFragment;
    private UserEntity mUser;

    @Bind(R.id.webview)
    WebView mWebView;

    private void getData() {
        this.mUser = FYApplication.getContext().getUserEntity();
        if (this.mUser != null) {
            this.mPreseter.getGoodsShow(this.mUser.getResult().get_id(), this.mId);
            return;
        }
        this.mPreseter.getGoodsShow("0", this.mId);
    }

    public void addSuccess(BaseEntity paramBaseEntity) {
    }

    protected void click(View paramView) {
    }

    protected ProductDetailsPresenter createPresenter() {
        return new ProductDetailsPresenter(this);
    }

    protected void initData() {
        Intent localIntent = getIntent();
        if (localIntent != null) {
            this.mId = localIntent.getStringExtra("message_extra_key");
            initTitle(localIntent.getStringExtra("message_extra_key2"));
            getData();
        }
        this.mFragmentManager = getSupportFragmentManager();
    }

    protected void initView() {
        this.mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt) {
                super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
                if (paramAnonymousInt > 80) ;
            }
        });
        this.mWebView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {
                super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
            }

            public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2) {
                super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
            }

            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString) {
                if ("1".equals(paramAnonymousString.substring(-1 + paramAnonymousString.length(), paramAnonymousString.length())))
                    GoodsDetailActivity.this.mFrameLayout.setVisibility(View.VISIBLE);
                else {
                    mFrameLayout.setVisibility(View.GONE);
                }
                return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
            }
        });
        WebSettings localWebSettings = this.mWebView.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setCacheMode(-1);
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
        localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        localWebSettings.setAllowFileAccess(true);
        localWebSettings.setDefaultTextEncodingName("UTF-8");
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setUseWideViewPort(true);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.mPreseter = ((ProductDetailsPresenter) this.mMPresenter);
        initView();
        initData();
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(ProductDetailEvent paramProductDetailEvent) {
        if (paramProductDetailEvent.getMsg().equals("back"))
            back();
        while (!"refresh_shopping_cart".equals(paramProductDetailEvent.getMsg()))
            return;
        getData();
    }

    public void onPause() {
        super.onPause();
        if (this.mWebView != null)
            this.mWebView.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.mWebView != null)
            this.mWebView.onResume();
    }

    public void setDetail(ProductDetailEntity paramProductDetailEntity) {
        this.mWebView.loadUrl("http://115.28.134.18:8087/web/goods_show.aspx?id=" + this.mId + "&active=1");
        this.mProductDetail = paramProductDetailEntity.getResult();
        initTitle(mProductDetail.getTitle());
        FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
        if (this.mProductFirstFragment == null) {
            this.mProductFirstFragment = new ProductFirstFragment();
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("message_extra_key", this.mProductDetail);
            this.mProductFirstFragment.setArguments(localBundle);
            localFragmentTransaction.add(R.id.frame_layout, this.mProductFirstFragment);
        }
        localFragmentTransaction.show(this.mProductFirstFragment);
        localFragmentTransaction.commitAllowingStateLoss();
    }
}