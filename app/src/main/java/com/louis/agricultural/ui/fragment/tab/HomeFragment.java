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
import com.louis.agricultural.model.entities.ProductEntity;
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
    @Bind(R.id.tv_name2)
    TextView mTvName2;
    @Bind(R.id.tv_desc2)
    TextView mTvDesc2;
    @Bind(R.id.tv_price2)
    TextView mTvPrice2;
    @Bind(R.id.iv_img2)
    ImageView mIvImg2;
    @Bind(R.id.tv_name3)
    TextView mTvName3;
    @Bind(R.id.tv_desc3)
    TextView mTvDesc3;
    @Bind(R.id.tv_price3)
    TextView mTvPrice3;
    @Bind(R.id.iv_img3)
    ImageView mIvImg3;
    @Bind(R.id.tv_name4)
    TextView mTvName4;
    @Bind(R.id.tv_desc4)
    TextView mTvDesc4;
    @Bind(R.id.tv_price4)
    TextView mTvPrice4;
    @Bind(R.id.iv_img4)
    ImageView mIvImg4;
    @Bind(R.id.tv_name5)
    TextView mTvName5;
    @Bind(R.id.tv_desc5)
    TextView mTvDesc5;
    @Bind(R.id.tv_price5)
    TextView mTvPrice5;
    @Bind(R.id.iv_img5)
    ImageView mIvImg5;

    @Bind(R.id.iv_order_img1)
    ImageView mIvOrderImg1;
    @Bind(R.id.tv_order_name1)
    TextView mTvOrderName1;
    @Bind(R.id.tv_order_price1)
    TextView mTvOrderPrice1;
    @Bind(R.id.tv_order_old_price1)
    TextView mTvOrderOldPrice1;
    @Bind(R.id.iv_order_img2)
    ImageView mIvOrderImg2;
    @Bind(R.id.tv_order_name2)
    TextView mTvOrderName2;
    @Bind(R.id.tv_order_price2)
    TextView mTvOrderPrice2;
    @Bind(R.id.tv_order_old_price2)
    TextView mTvOrderOldPrice2;
    @Bind(R.id.iv_order_img3)
    ImageView mIvOrderImg3;
    @Bind(R.id.tv_order_name3)
    TextView mTvOrderName3;
    @Bind(R.id.tv_order_price3)
    TextView mTvOrderPrice3;
    @Bind(R.id.tv_order_old_price3)
    TextView mTvOrderOldPrice3;
    @Bind(R.id.iv_order_img4)
    ImageView mIvOrderImg4;
    @Bind(R.id.tv_order_name4)
    TextView mTvOrderName4;
    @Bind(R.id.tv_order_price4)
    TextView mTvOrderPrice4;
    @Bind(R.id.tv_order_old_price4)
    TextView mTvOrderOldPrice4;

    private HomePresenter mPresenter;
    private AdImageAdapter imageAdapter;
    private DisplayImageOptions mOptions;
    private List<ProductEntity.ResultEntity> jpList;
    private List<ProductEntity.ResultEntity> mJpList;


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
                String id = mJpList.get(0).getId();
                toGoodsDetail(id);
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

    private void toGoodsDetail(String article_id) {
        Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, article_id);
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
        if (data.getResult() != null) {
            mTvTitle.setText(data.getResult().get(0).getTitle());
        }
    }

    @Override
    public void setFytj(ProductEntity data) {

        mJpList = data.getResult();

        ProductEntity.ResultEntity entity1 = mJpList.get(0);
        mTvName1.setText(entity1.getTitle());
        mTvDesc1.setText(entity1.getBrand());
        mTvPrice1.setText("￥" + entity1.getSell_price());
        ImageLoadProxy.displayImage(entity1.getImg_url(), mIvImg1, mOptions);

        ProductEntity.ResultEntity entity2 = mJpList.get(1);
        mTvName2.setText(entity2.getTitle());
        mTvDesc2.setText(entity2.getBrand());
        mTvPrice2.setText("￥" + entity2.getSell_price());
        ImageLoadProxy.displayImage(entity2.getImg_url(), mIvImg2, mOptions);

        ProductEntity.ResultEntity entity3 = mJpList.get(1);
        mTvName3.setText(entity3.getTitle());
        mTvDesc3.setText(entity3.getBrand());
        mTvPrice3.setText("￥" + entity3.getSell_price());
        ImageLoadProxy.displayImage(entity3.getImg_url(), mIvImg3, mOptions);

        ProductEntity.ResultEntity entity4 = mJpList.get(1);
        mTvName4.setText(entity4.getTitle());
        mTvDesc4.setText(entity4.getBrand());
        mTvPrice4.setText("￥" + entity4.getSell_price());
        ImageLoadProxy.displayImage(entity4.getImg_url(), mIvImg4, mOptions);

        ProductEntity.ResultEntity entity5 = mJpList.get(1);
        mTvName5.setText(entity5.getTitle());
        mTvDesc5.setText(entity5.getBrand());
        mTvPrice5.setText("￥" + entity5.getSell_price());
        ImageLoadProxy.displayImage(entity5.getImg_url(), mIvImg5, mOptions);
    }

    @Override
    public void setRmtj(ProductEntity data) {

        List<ProductEntity.ResultEntity> result = data.getResult();

        ProductEntity.ResultEntity entity1 = result.get(0);
        mTvOrderName1.setText(entity1.getTitle());
        mTvOrderPrice1.setText("￥" + entity1.getSell_price());
        ImageLoadProxy.displayImage(entity1.getImg_url(), mIvOrderImg1, mOptions);

        ProductEntity.ResultEntity entity2 = result.get(0);
        mTvOrderName2.setText(entity2.getTitle());
        mTvOrderPrice2.setText("￥" + entity2.getSell_price());
        ImageLoadProxy.displayImage(entity2.getImg_url(), mIvOrderImg2, mOptions);

        ProductEntity.ResultEntity entity3 = result.get(0);
        mTvOrderName3.setText(entity3.getTitle());
        mTvOrderPrice3.setText("￥" + entity3.getSell_price());
        ImageLoadProxy.displayImage(entity3.getImg_url(), mIvOrderImg3, mOptions);

        ProductEntity.ResultEntity entity4 = result.get(0);
        mTvOrderName4.setText(entity4.getTitle());
        mTvOrderPrice4.setText("￥" + entity4.getSell_price());
        ImageLoadProxy.displayImage(entity4.getImg_url(), mIvOrderImg4, mOptions);
    }
}
