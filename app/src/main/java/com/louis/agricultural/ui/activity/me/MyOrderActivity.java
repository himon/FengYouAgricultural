package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.event.LoginResultEvent;
import com.louis.agricultural.model.event.MyOrderEvent;
import com.louis.agricultural.presenter.MyOrderPresenter;
import com.louis.agricultural.ui.adapter.TabAdapter;
import com.louis.agricultural.ui.fragment.MyOrderFragment;
import com.louis.agricultural.ui.view.IMyOrderAView;
import com.louis.agricultural.utils.ShowToast;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 我的订单
 */
public class MyOrderActivity extends MVPBaseActivity<IMyOrderAView, MyOrderPresenter> implements IMyOrderAView {

    @Bind(R.id.indicator)
    UnderlinePageIndicator mIndicator;
    @Bind(R.id.id_viewpager)
    ViewPager mViewPager;
    @Bind(R.id.tv_all)
    TextView mTvAll;
    @Bind(R.id.tv_pay)
    TextView mTvPay;
    @Bind(R.id.tv_get)
    TextView mTvGet;
    @Bind(R.id.tv_comment)
    TextView mTvComment;
    @Bind(R.id.tv_finish)
    TextView mTvFinish;

    private TabAdapter mTabAdapter;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mPageTitle = new ArrayList<>();

    private MyOrderPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected MyOrderPresenter createPresenter() {
        return new MyOrderPresenter(this);
    }

    @Override
    protected void initView() {

        initTitle("我的订单");

        MyOrderFragment fragment1 = new MyOrderFragment();
        MyOrderFragment fragment2 = new MyOrderFragment();
        MyOrderFragment fragment3 = new MyOrderFragment();
        MyOrderFragment fragment4 = new MyOrderFragment();
        MyOrderFragment fragment5 = new MyOrderFragment();

        Bundle bundle1 = new Bundle();
        bundle1.putString(Constants.MESSAGE_EXTRA_KEY, "0");
        bundle1.putString(Constants.MESSAGE_EXTRA_KEY2, "1");
        bundle1.putString(Constants.MESSAGE_EXTRA_KEY3, "1");
        fragment1.setArguments(bundle1);

        Bundle bundle2 = new Bundle();
        bundle2.putString(Constants.MESSAGE_EXTRA_KEY, "2");
        bundle2.putString(Constants.MESSAGE_EXTRA_KEY2, "1");
        bundle2.putString(Constants.MESSAGE_EXTRA_KEY3, "1");
        fragment2.setArguments(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putString(Constants.MESSAGE_EXTRA_KEY, "2");
        bundle3.putString(Constants.MESSAGE_EXTRA_KEY2, "2");
        bundle3.putString(Constants.MESSAGE_EXTRA_KEY3, "2");
        fragment3.setArguments(bundle3);

        Bundle bundle4 = new Bundle();
        bundle4.putString(Constants.MESSAGE_EXTRA_KEY, "6");
        bundle4.putString(Constants.MESSAGE_EXTRA_KEY2, "2");
        bundle4.putString(Constants.MESSAGE_EXTRA_KEY3, "2");
        fragment4.setArguments(bundle4);

        Bundle bundle5 = new Bundle();
        bundle5.putString(Constants.MESSAGE_EXTRA_KEY, "3");
        bundle5.putString(Constants.MESSAGE_EXTRA_KEY2, "2");
        bundle5.putString(Constants.MESSAGE_EXTRA_KEY3, "2");
        fragment5.setArguments(bundle5);


        mFragments.add(fragment1);
        mFragments.add(fragment2);
        mFragments.add(fragment3);
        mFragments.add(fragment4);
        mFragments.add(fragment5);

        mPageTitle.add("全部");
        mPageTitle.add("待付款");
        mPageTitle.add("待收货");
        mPageTitle.add("待评价");
        mPageTitle.add("交易完成");

        mTabAdapter = new TabAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mTabAdapter);
        mViewPager.setOffscreenPageLimit(5);
        mIndicator.setViewPager(mViewPager);
        mIndicator.setFades(false);

        initEvent();
    }

    private void initEvent() {
        mTvAll.setOnClickListener(this);
        mTvPay.setOnClickListener(this);
        mTvGet.setOnClickListener(this);
        mTvComment.setOnClickListener(this);
        mTvFinish.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            int index = intent.getIntExtra(Constants.MESSAGE_EXTRA_KEY, 0);
            mViewPager.setCurrentItem(index);
        }
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.tv_all:
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.tv_pay:
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.tv_get:
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.tv_comment:
                mViewPager.setCurrentItem(3, false);
                break;
            case R.id.tv_finish:
                mViewPager.setCurrentItem(4, false);
                break;
        }
    }

    public void onEvent(MyOrderEvent event) {

        if ("pay".equals(event.getMsg())) {
            Intent intent = new Intent(this, PayActivity.class);
            intent.putExtra(Constants.MESSAGE_EXTRA_KEY, event.getStatus());
            intent.putExtra(Constants.MESSAGE_EXTRA_KEY2, event.getOrderId());
            startActivity(intent);
        } else if ("update".equals(event.getMsg())) {
            mPresenter.updateOrder(event.getOrderId(), "status", event.getStatus());
        } else if ("update_pay".equals(event.getMsg())) {
            mPresenter.updateOrder(event.getOrderId(), "payment_status", event.getStatus());
        } else if ("comment".equals(event.getMsg())) {
            Intent intent = new Intent(this, CommentActivity.class);
            intent.putExtra(Constants.MESSAGE_EXTRA_KEY, event.getOrderId());
            intent.putExtra(Constants.MESSAGE_EXTRA_KEY2, event.getOrderGoodsId());
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void setUpdateOrderSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
//        int currentItem = mViewPager.getCurrentItem();
//        MyOrderFragment fragment = (MyOrderFragment) mFragments.get(currentItem);
//        fragment.refresh();
        for (int i = 0; i < mFragments.size(); i++) {
            ((MyOrderFragment) mFragments.get(i)).refresh();
        }
    }
}
