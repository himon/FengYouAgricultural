package com.louis.agricultural.ui.fragment.tab;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.fragment.MVPBaseFragment;
import com.louis.agricultural.model.entities.FytjEntity;
import com.louis.agricultural.model.entities.FyttEntity;
import com.louis.agricultural.model.entities.HomeAdImageEntity;
import com.louis.agricultural.presenter.HomePresenter;
import com.louis.agricultural.ui.activity.MessageActivity;
import com.louis.agricultural.ui.activity.ProductDetailsActivity;
import com.louis.agricultural.ui.activity.account.LoginActivity;
import com.louis.agricultural.ui.view.IHomeView;
import com.louis.agricultural.utils.manager.ImageLoadProxy;
import com.louis.agricultural.view.GuideGallery;
import com.louis.agricultural.view.autoscrollviewpager.AdImageAdapter;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends MVPBaseFragment<IHomeView, HomePresenter> implements IHomeView, View.OnClickListener {

    @Bind(R.id.viewpager)
    GuideGallery mViewPager;
    @Bind(R.id.rl_recommend1)
    RelativeLayout mRlRecommend1;
    @Bind(R.id.ll_brand)
    LinearLayout mLLBrand;
    @Bind(R.id.ll_announcement)
    LinearLayout mLLAnnouncement;
    @Bind(R.id.ll_news)
    LinearLayout mLLNews;
    @Bind(R.id.ll_distribution)
    LinearLayout mLLDistribution;
    @Bind(R.id.tv_tt_title)
    TextView mTvTitle;
    @Bind(R.id.tv_name1)
    TextView mTvName1;
    @Bind(R.id.tv_desc1)
    TextView mTvDesc1;
    @Bind(R.id.tv_price1)
    TextView mTvPrice1;
    @Bind(R.id.iv_img1)
    ImageView mIvImg1;

    @Bind(R.id.iv_order_img1)
    ImageView mIvOrderImg1;
    @Bind(R.id.tv_order_name1)
    TextView mTvOrderName1;
    @Bind(R.id.tv_order_price1)
    TextView mTvOrderPrice1;
    @Bind(R.id.tv_order_old_price1)
    TextView mTvOrderOldPrice1;

    private HomePresenter mPresenter;
    private AdImageAdapter imageAdapter;
    private DisplayImageOptions mOptions;


    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        mPresenter = mMPresenter;
        initView();
        initData();

        return view;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected void initView() {
        initEvent();
    }

    private void initEvent() {
        mRlRecommend1.setOnClickListener(this);
        mLLBrand.setOnClickListener(this);
        mLLAnnouncement.setOnClickListener(this);
        mLLNews.setOnClickListener(this);
        mLLDistribution.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        mOptions = ImageLoadProxy.getOption4ExactlyType();

        mPresenter.getIndexImage(3);
        mPresenter.getIndexFytt(3);
        mPresenter.getIndexFytj(5);
        mPresenter.getIndexFyrm(4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_recommend1:
                toGoodsDetail();
                break;
            case R.id.ll_brand:
                toLogin();
                break;
            case R.id.ll_announcement:
                toMessage(0);
                break;
            case R.id.ll_news:
                toMessage(1);
                break;
            case R.id.ll_distribution:
                toMessage(2);
                break;
        }
    }

    private void toMessage(int index) {
        Intent intent = new Intent(getActivity(), MessageActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, index);
        startActivity(intent);
    }

    private void toLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    private void toGoodsDetail() {
        Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
        startActivity(intent);
    }


    @Override
    public void setViewPagerAd(HomeAdImageEntity data) {

        List<HomeAdImageEntity.ResultEntity> result = data.getResult();
        imageAdapter = new AdImageAdapter(result, getActivity());
        mViewPager.setSize(result.size());
        mViewPager.setAdapter(imageAdapter);
        mViewPager.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        //解决滑动切换时有声音
        mViewPager.setSoundEffectsEnabled(false);
        mViewPager.startAutoScroll();
    }

    @Override
    public void setFytt(FyttEntity data) {
        mTvTitle.setText(data.getResult().get(0).getTitle());
    }

    @Override
    public void setFytj(FytjEntity data) {

        List<FytjEntity.ResultEntity> result = data.getResult();

        FytjEntity.ResultEntity entity1 = result.get(0);

        mTvName1.setText(entity1.getTitle());
        mTvDesc1.setText(entity1.getBrand());
        mTvPrice1.setText("$" + entity1.getSell_price());
        ImageLoadProxy.displayImage(entity1.getImg_url(), mIvImg1, mOptions);
    }

    @Override
    public void setRmtj(FytjEntity data) {

        List<FytjEntity.ResultEntity> result = data.getResult();

        FytjEntity.ResultEntity entity1 = result.get(0);

        mTvOrderName1.setText(entity1.getTitle());
        mTvOrderPrice1.setText("$" + entity1.getSell_price());
        ImageLoadProxy.displayImage(entity1.getImg_url(), mIvOrderImg1, mOptions);

    }
}
