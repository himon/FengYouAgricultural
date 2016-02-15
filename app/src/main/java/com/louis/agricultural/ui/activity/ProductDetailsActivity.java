package com.louis.agricultural.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.louis.agricultural.presenter.ProductDetailsPresenter;
import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.ui.fragment.product.ProductFirstFragment;
import com.louis.agricultural.ui.fragment.product.ProductSecondFragment;
import com.louis.agricultural.ui.view.IProductDetailsView;
import com.louis.agricultural.view.DragLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 商品详情
 */
public class ProductDetailsActivity extends MVPBaseActivity<IProductDetailsView, ProductDetailsPresenter> implements IProductDetailsView {

    @Bind(R.id.tools_bar)
    RelativeLayout mToolsBar;

    private ProductDetailsPresenter mPreseter;
    private ProductFirstFragment mFirstFragment;
    private ProductSecondFragment mSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected ProductDetailsPresenter createPresenter() {
        return new ProductDetailsPresenter();
    }

    @Override
    protected void initView() {
        mToolsBar.setVisibility(View.GONE);
        mFirstFragment = new ProductFirstFragment();
        mSecondFragment = new ProductSecondFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.rl_first, mFirstFragment).add(R.id.rl_second, mSecondFragment).commit();
        DragLayout.ShowNextPageNotifier next = new DragLayout.ShowNextPageNotifier() {
            @Override
            public void onDragNext() {

            }
        };
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void click(View view) {

    }
}
