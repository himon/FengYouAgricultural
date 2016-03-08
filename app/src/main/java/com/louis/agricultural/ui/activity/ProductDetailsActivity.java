package com.louis.agricultural.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ProductDetailEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.LoginResultEvent;
import com.louis.agricultural.model.event.ProductDetailEvent;
import com.louis.agricultural.model.event.ShoppingCartEvent;
import com.louis.agricultural.presenter.ProductDetailsPresenter;
import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.ui.activity.account.LoginActivity;
import com.louis.agricultural.ui.fragment.product.ProductFirstFragment;
import com.louis.agricultural.ui.fragment.product.ProductSecondFragment;
import com.louis.agricultural.ui.view.IProductDetailsView;
import com.louis.agricultural.utils.ShowToast;
import com.louis.agricultural.view.DragLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 商品详情
 */
public class ProductDetailsActivity extends MVPBaseActivity<IProductDetailsView, ProductDetailsPresenter> implements IProductDetailsView {

    @Bind(R.id.tools_bar)
    RelativeLayout mToolsBar;
    @Bind(R.id.btn_add_shoppingcart)
    Button mBtnAddShoppingCart;

    private ProductDetailsPresenter mPreseter;
    private ProductFirstFragment mFirstFragment;
    private ProductSecondFragment mSecondFragment;
    private ProductDetailEntity.ResultEntity mProductDetail;
    private UserEntity mUser;
    private String mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        mPreseter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected ProductDetailsPresenter createPresenter() {
        return new ProductDetailsPresenter(this);
    }

    @Override
    protected void initView() {
        mToolsBar.setVisibility(View.GONE);

        initEvent();
    }

    public void initEvent(){
        mBtnAddShoppingCart.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if(intent != null){
            mId = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY);
            mPreseter.getGoodsShow(mId);
        }
        mUser = FYApplication.getContext().getUserEntity();
    }

    @Override
    protected void click(View view) {
        switch (view.getId()){
            case R.id.btn_add_shoppingcart:
                mUser = FYApplication.getContext().getUserEntity();
                if(mUser != null) {
                    mPreseter.getAddGoodscart(mUser.getResult().get_id(), mId, 1);
                }else{
                    toLogin();
                }
                break;
        }
    }

    private void toLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void setDetail(ProductDetailEntity data) {
        mProductDetail = data.getResult();

        mFirstFragment = new ProductFirstFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.MESSAGE_EXTRA_KEY, mProductDetail);
        mFirstFragment.setArguments(bundle);
        mSecondFragment = new ProductSecondFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.rl_first, mFirstFragment).add(R.id.rl_second, mSecondFragment).commit();
        DragLayout.ShowNextPageNotifier next = new DragLayout.ShowNextPageNotifier() {
            @Override
            public void onDragNext() {

            }
        };
    }

    @Override
    public void addSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
        EventBus.getDefault().post(new ShoppingCartEvent("refresh"));
    }

    public void onEvent(ProductDetailEvent event) {
        if(event.getMsg().equals("back")){
            back();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
