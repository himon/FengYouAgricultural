package com.louis.agricultural.ui.fragment.product;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.fragment.BaseFragment;
import com.louis.agricultural.model.entities.ProductDetailEntity;
import com.louis.agricultural.model.event.ProductDetailEvent;
import com.louis.agricultural.utils.manager.ImageLoadProxy;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;


/**
 * 商品详情的第一个Fragment
 */
public class ProductFirstFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.iv_product_imgs)
    ImageView mIvImg;
    @Bind(R.id.iv_share)
    ImageView mIvShare;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_price)
    TextView mTvPrice;

    private ProductDetailEntity.ResultEntity mProductDetail;
    private DisplayImageOptions mOptions;

    public ProductFirstFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_first, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }


    @Override
    protected void initView() {
        mOptions = ImageLoadProxy.getOption4ExactlyType();
        initEvent();
    }

    private void initEvent() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        mProductDetail = bundle.getParcelable(Constants.MESSAGE_EXTRA_KEY);
        mTvTitle.setText(mProductDetail.getTitle());
        mTvPrice.setText("￥" + mProductDetail.getSell_price());
        ImageLoadProxy.displayImage(mProductDetail.getAlbum().get(0).getThumb_path(), mIvImg, mOptions);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                EventBus.getDefault().post(new ProductDetailEvent("back"));
                break;
        }
    }
}
