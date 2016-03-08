package com.louis.agricultural.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.presenter.SearchActivityPresenter;
import com.louis.agricultural.ui.adapter.SearchAdapter;
import com.louis.agricultural.ui.view.ISearchView;
import com.louis.agricultural.view.GetMoreListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class SearchActivity extends MVPBaseActivity<ISearchView, SearchActivityPresenter> implements ISearchView {

    @Bind(R.id.tools_bar)
    RelativeLayout mToolsBar;
    @Bind(R.id.iv_classify_left)
    ImageView mIvBack;
    @Bind(R.id.ll_sum)
    LinearLayout mLLSum;
    @Bind(R.id.ll_price)
    LinearLayout mLLPrice;
    @Bind(R.id.cb_hot)
    CheckBox mCbHot;
    @Bind(R.id.ptr_main)
    PtrClassicFrameLayout mPtr;
    @Bind(R.id.gmlv_main)
    GetMoreListView mListView;
    @Bind(R.id.et_search)
    EditText mEtSearch;

    //排序
    private String mOrder = "id";
    private SearchActivityPresenter mPresenter;

    //是否是下拉刷新
    private boolean isRefresh;
    private List<ProductEntity.ResultEntity> mProductList = new ArrayList<>();
    private SearchAdapter mAdapter;
    private String mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected SearchActivityPresenter createPresenter() {
        return new SearchActivityPresenter(this);
    }

    @Override
    protected void initView() {
        mToolsBar.setVisibility(View.GONE);

        mListView.setOnGetMoreListener(new GetMoreListView.OnGetMoreListener() {
            @Override
            public void onGetMore() {
                isRefresh = false;
                getData();
            }
        });

        mAdapter = new SearchAdapter(this, mProductList, R.layout.adapter_search);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        mPtr.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                isRefresh = true;
                getData();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtr.autoRefresh();
            }
        }, 100);

        initEvent();
    }

    private void getData() {
        mPresenter.getSearchGoods("0", "生物", mOrder);
    }

    private void initEvent() {

        mIvBack.setOnClickListener(this);
        mLLSum.setOnClickListener(this);
        mLLPrice.setOnClickListener(this);

        mEtSearch.setOnKeyListener(new View.OnKeyListener() {//输入完后按键盘上的搜索键【回车键改为了搜索键】

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    //修改回车键功能
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    SearchActivity.this
                                            .getCurrentFocus()
                                            .getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    //跳转到搜索结果界面
                }
                return false;
            }
        });

        mCbHot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mOrder = "is_hot";
                    mPresenter.getSearchGoods("0", "生物", mOrder);
                }else{
                    mOrder = "id";
                    mPresenter.getSearchGoods("0", "生物", mOrder);
                }
            }
        });
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mSearch = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY);
        }
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.iv_classify_left:
                back();
                break;
            case R.id.ll_sum:
                mOrder = "sum";
                mPresenter.getSearchGoods("0", "生物", mOrder);
                break;
            case R.id.ll_price:
                mOrder = "sell_price";
                mPresenter.getSearchGoods("0", "生物", mOrder);
                break;
        }
    }

    @Override
    public void setProducts(ProductEntity data) {
        mProductList = data.getResult();
        mAdapter.setmDatas(mProductList);
        mListView.setNoMore();
        mAdapter.notifyDataSetChanged();
        mListView.getMoreComplete();
        mPtr.refreshComplete();
    }
}
