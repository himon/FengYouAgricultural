package com.louis.agricultural.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BasicActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.LoginResultEvent;
import com.louis.agricultural.ui.activity.account.LoginActivity;
import com.louis.agricultural.ui.fragment.tab.ClassifyFragment;
import com.louis.agricultural.ui.fragment.tab.HomeFragment;
import com.louis.agricultural.ui.fragment.tab.MeFragment;
import com.louis.agricultural.ui.fragment.tab.ShoppingCartFragment;
import com.louis.agricultural.view.ChangeColorIconWithText;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class MainActivity extends BasicActivity {

    @Bind(R.id.indicator_home)
    ChangeColorIconWithText mIndicatorHome;
    @Bind(R.id.indicator_classify)
    ChangeColorIconWithText mIndicatorClassify;
    @Bind(R.id.indicator_shopping_cart)
    ChangeColorIconWithText mIndicatorShopping;
    @Bind(R.id.indicator_me)
    ChangeColorIconWithText mIndicatorMe;
    @Bind(R.id.vp_viewpager)
    ViewPager mViewPager;

    private ArrayList<ChangeColorIconWithText> mTabIndicators = new ArrayList<ChangeColorIconWithText>();
    private ArrayList<Fragment> mTabs = new ArrayList<>();
    private FragmentPagerAdapter mAdapter;
    private ArrayList<Bitmap> bitmaps;

    private HomeFragment mHomeFragment;
    private ClassifyFragment mClassifyFragment;
    private ShoppingCartFragment mShoppingCartFragment;
    private MeFragment mMeFragment;

    //选中Tab页图标的颜色
    private int mSelectedColor;
    private int mUnSelectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {

        mTabIndicators.add(mIndicatorHome);
        mTabIndicators.add(mIndicatorClassify);
        mTabIndicators.add(mIndicatorShopping);
        mTabIndicators.add(mIndicatorMe);

        mHomeFragment = new HomeFragment();
        mClassifyFragment = new ClassifyFragment();
        mShoppingCartFragment = new ShoppingCartFragment();
        mMeFragment = new MeFragment();

        mTabs.add(mHomeFragment);
        mTabs.add(mClassifyFragment);
        mTabs.add(mShoppingCartFragment);
        mTabs.add(mMeFragment);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mTabs.get(position);
            }

            @Override
            public int getCount() {
                return mTabs.size();
            }
        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setCurrentItem(0);

        initEvent();
    }

    @Override
    protected void initData() {

        mSelectedColor = getResources().getColor(R.color.button_red_bg);
        mUnSelectedColor = getResources().getColor(R.color.main_tab_font_gray);

        bitmaps = new ArrayList<>();
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_tab_home));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_tab_classify));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_tab_shopping_cart));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_tab_me));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_tab_home_selected));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_tab_classify_selected));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_tab_shopping_cart_selected));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_tab_me_selected));

    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            default:
                clickTab(view);
                break;
        }
    }

    private void clickTab(View view) {

        UserEntity userEntity;

        switch (view.getId()) {
            case R.id.indicator_home:
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.indicator_classify:
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.indicator_shopping_cart:
                userEntity = FYApplication.getContext().getUserEntity();
                if (userEntity != null) {
                    mViewPager.setCurrentItem(2
                            , false);
                } else {
                    toLogin(Constants.LOGIN_FROM_SHOPPINGCART);
                }
                break;
            case R.id.indicator_me:
                userEntity = FYApplication.getContext().getUserEntity();
                if (userEntity != null) {
                    mViewPager.setCurrentItem(3
                            , false);
                } else {
                    toLogin(Constants.LOGIN_FROM_ME);
                }
                break;
        }
    }

    private void toLogin(String from) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, from);
        startActivity(intent);
    }

    private void initEvent() {
        mIndicatorHome.setOnClickListener(this);
        mIndicatorClassify.setOnClickListener(this);
        mIndicatorShopping.setOnClickListener(this);
        mIndicatorMe.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                resetOtherTabs();
                mTabIndicators.get(position).setmIcon(bitmaps.get(position + 4), mSelectedColor);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 重置其他的TabIndicator的颜色
     */
    private void resetOtherTabs() {
        for (int i = 0; i < mTabIndicators.size(); i++) {
            ChangeColorIconWithText changeColorIconWithText = mTabIndicators.get(i);
            changeColorIconWithText.setmIcon(bitmaps.get(i), mUnSelectedColor);
        }
    }

    public void onEvent(LoginResultEvent event) {
        if (Constants.LOGIN_FROM_ME.equals(event.getMsg())) {
            mViewPager.setCurrentItem(3, false);
            mMeFragment.refresh();
            mShoppingCartFragment.refresh();
        } else if (Constants.LOGIN_FROM_SHOPPINGCART.equals(event.getMsg())) {
            mViewPager.setCurrentItem(2, false);
            mMeFragment.refresh();
            mShoppingCartFragment.refresh();
        } else if (Constants.LOGIN_REFRESH.equals(event.getMsg()) || Constants.LOGIN_REFRESH_BY_PRODUCT_DETAIL.equals(event.getMsg())) {
            mMeFragment.refresh();
            mShoppingCartFragment.refresh();
        } else if ("classify".equals(event.getMsg())) {
            mViewPager.setCurrentItem(1, false);
        } else if ("Shopping".equals(event.getMsg())) {
            mViewPager.setCurrentItem(2, false);
        }else if("refresh_head_icon".equals(event.getMsg())){
            mMeFragment.refresh();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
