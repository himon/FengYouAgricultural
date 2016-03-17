package com.louis.agricultural.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ProductDetailEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.LoginResultEvent;
import com.louis.agricultural.model.event.ProductDetailEvent;
import com.louis.agricultural.model.event.ShoppingCartEvent;
import com.louis.agricultural.presenter.ProductDetailsPresenter;
import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.ui.activity.account.LoginActivity;
import com.louis.agricultural.ui.activity.me.ConfirmOrderActivity;
import com.louis.agricultural.ui.fragment.product.ProductFirstFragment;
import com.louis.agricultural.ui.fragment.product.ProductSecondFragment;
import com.louis.agricultural.ui.view.IProductDetailsView;
import com.louis.agricultural.utils.ShowToast;
import com.louis.agricultural.view.DragLayout;

import java.math.BigDecimal;
import java.util.ArrayList;

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
    @Bind(R.id.btn_buy)
    Button mBtnBuy;
    @Bind(R.id.tv_shopping_cart_sum)
    TextView mTvShoppingCartSum;
    @Bind(R.id.iv_shopping_cart)
    ImageView mIvShoppingCart;

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

    public void initEvent() {
        mBtnBuy.setOnClickListener(this);
        mBtnAddShoppingCart.setOnClickListener(this);
        mIvShoppingCart.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mId = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY);
            getData();
        }

    }

    private void getData() {
        mUser = FYApplication.getContext().getUserEntity();
        if (mUser != null) {
            mPreseter.getGoodsShow(mUser.getResult().get_id(), mId);
        } else {
            mPreseter.getGoodsShow("0", mId);
        }
    }

    @Override
    protected void click(View view) {
        mUser = FYApplication.getContext().getUserEntity();
        switch (view.getId()) {
            case R.id.btn_add_shoppingcart:
                if (mUser != null) {
                    mPreseter.getAddGoodscart(mUser.getResult().get_id(), mId, 1);
                } else {
                    toLogin();
                }
                break;
            case R.id.iv_shopping_cart:
                if (mUser != null) {
                    toShoppingCart();
                } else {
                    toLogin();
                }
                break;
            case R.id.btn_buy:
                if (mUser != null) {
                    toCreatOrder();
                } else {
                    toLogin();
                }
                break;
        }
    }

    private void toCreatOrder() {
        ArrayList<ShoppingCartEntity.ResultEntity> list = new ArrayList<>();
        ShoppingCartEntity.ResultEntity item = new ShoppingCartEntity.ResultEntity();
        item.setSum("1");
        item.setCheck(true);
        item.setGoods_id(mId);
        item.setGoods_no("");
        item.setGoods_no("");
        item.setImg_url(mProductDetail.getAlbum().get(0).getThumb_path());
        item.setId("");
        item.setSell_price(new BigDecimal(mProductDetail.getSell_price()));
        item.setTitle(mProductDetail.getTitle());
        item.setUser_id(mUser.getResult().get_id());
        list.add(item);

        Intent intent = new Intent(this, ConfirmOrderActivity.class);
        intent.putParcelableArrayListExtra(Constants.MESSAGE_EXTRA_KEY, list);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY2, mProductDetail.getSell_price());
        startActivity(intent);
    }

    private void toShoppingCart() {
        EventBus.getDefault().post(new LoginResultEvent("Shopping"));
        back();
    }

    private void toLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, Constants.LOGIN_REFRESH_BY_PRODUCT_DETAIL);
        startActivity(intent);
    }

    @Override
    public void setDetail(ProductDetailEntity data) {
        mProductDetail = data.getResult();

        if (mProductDetail.getGwc_sum() == 0) {
            mTvShoppingCartSum.setVisibility(View.GONE);
        } else {
            mTvShoppingCartSum.setVisibility(View.VISIBLE);
            mTvShoppingCartSum.setText(mProductDetail.getGwc_sum() + "");
        }

        mFirstFragment = new ProductFirstFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.MESSAGE_EXTRA_KEY, mProductDetail);
        mFirstFragment.setArguments(bundle);

        mSecondFragment = new ProductSecondFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString(Constants.MESSAGE_EXTRA_KEY, mId);
        mSecondFragment.setArguments(bundle);

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
        mProductDetail.setGwc_sum(mProductDetail.getGwc_sum() + 1);
        mTvShoppingCartSum.setText(mProductDetail.getGwc_sum() + "");
        EventBus.getDefault().post(new ShoppingCartEvent("refresh"));
    }

    public void onEvent(ProductDetailEvent event) {
        if (event.getMsg().equals("back")) {
            back();
        } else if ("refresh_shopping_cart".equals(event.getMsg())) {
            getData();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
