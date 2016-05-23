package com.louis.agricultural.ui.fragment.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

import com.facebook.stetho.common.ArrayListAccumulator;
import com.louis.agricultural.R;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.base.fragment.MVPBaseFragment;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ProductDetailEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.ConfirmOrderEvent;
import com.louis.agricultural.model.event.LoginResultEvent;
import com.louis.agricultural.model.event.ProductDetailEvent;
import com.louis.agricultural.model.event.ShoppingCartEvent;
import com.louis.agricultural.presenter.ProductFirstFragmentPresenter;
import com.louis.agricultural.ui.activity.SearchActivity;
import com.louis.agricultural.ui.activity.account.LoginActivity;
import com.louis.agricultural.ui.activity.me.ConfirmOrderActivity;
import com.louis.agricultural.ui.view.IProductFirstFragmentView;
import com.louis.agricultural.utils.ShowToast;
import com.louis.agricultural.utils.manager.ImageLoadProxy;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ProductFirstFragment extends MVPBaseFragment<IProductFirstFragmentView, ProductFirstFragmentPresenter>
        implements IProductFirstFragmentView, View.OnClickListener {

    @Bind(R.id.btn_add_shoppingcart)
    Button mBtnAddShoppingCart;
    @Bind(R.id.btn_buy)
    Button mBtnBuy;
    @Bind(R.id.et_num)
    EditText mEtNum;
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.iv_category)
    ImageView mIvCategory;
    @Bind(R.id.iv_product_imgs)
    ImageView mIvImg;
    @Bind(R.id.iv_share)
    ImageView mIvShare;
    @Bind(R.id.iv_shopping_cart)
    ImageView mIvShoppingCart;
    @Bind(R.id.tv_category_name)
    TextView mTvCategoryName;
    @Bind(R.id.tv_old_price)
    TextView mTvOldPrice;
    @Bind(R.id.tv_shopping_cart_sum)
    TextView mTvShoppingCartSum;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_price)
    TextView mTvPrice;
    @Bind(R.id.rl_search)
    RelativeLayout mRlSearch;
    @Bind(R.id.iv_minus)
    ImageView mIvMinus;
    @Bind(R.id.iv_add)
    ImageView mIvAdd;

    private DisplayImageOptions mOptions;
    private ProductFirstFragmentPresenter mPresenter;
    private ProductDetailEntity.ResultBean mProductDetail;
    private UserEntity mUser;
    private int count = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_first, container, false);
        ButterKnife.bind(this, view);
        mPresenter = mMPresenter;
        initView();
        initData();
        return view;
    }

    @Override
    protected void initView() {
        mOptions = ImageLoadProxy.getOption4ExactlyType();
        initEvent();
    }

    @Override
    protected void initData() {
        Bundle b = getArguments();
        if (b != null) {
            mProductDetail = b.getParcelable(Constants.MESSAGE_EXTRA_KEY);
            mTvTitle.setText(this.mProductDetail.getTitle());
            mTvPrice.setText("￥" + this.mProductDetail.getSell_price());
            mTvOldPrice.setText("");
            this.mTvCategoryName.setText(this.mProductDetail.getCategory_name());
            ImageLoadProxy.displayImage(this.mProductDetail.getCategory_imgurl(), this.mIvCategory, this.mOptions);
            ImageLoadProxy.displayImage(((ProductDetailEntity.ResultBean.AlbumBean) this.mProductDetail.getAlbum().get(0)).getOriginal_path(), this.mIvImg, this.mOptions);
            if (mProductDetail.getGwc_sum() == 0) {
                mTvShoppingCartSum.setVisibility(View.GONE);
            } else {
                mTvShoppingCartSum.setVisibility(View.VISIBLE);
                mTvShoppingCartSum.setText(mProductDetail.getGwc_sum() + "");
            }

        }

    }

    private void initEvent() {
        mIvBack.setOnClickListener(this);
        mBtnBuy.setOnClickListener(this);
        mBtnAddShoppingCart.setOnClickListener(this);
        mIvShoppingCart.setOnClickListener(this);
        mRlSearch.setOnClickListener(this);
        mIvMinus.setOnClickListener(this);
        mIvAdd.setOnClickListener(this);
    }

    private void toCreateOrder() {
        if (mProductDetail.getStock_quantity().equals("0")) {
            ShowToast.Short("该商品库存为0, 不能购买!");
            return;
        }

        String str = mEtNum.getText().toString().trim();
        if (Integer.valueOf(str) <= 0) {
            ShowToast.Short("请输入正确的商品数量");
            return;
        }
        ArrayList<ShoppingCartEntity.ResultEntity> list = new ArrayList();
        ShoppingCartEntity.ResultEntity entity = new ShoppingCartEntity.ResultEntity();
        entity.setSum(str);
        entity.setCheck(true);
        entity.setGoods_id(mProductDetail.getGoods_id());
        entity.setGoods_no("");
        entity.setImg_url(mProductDetail.getAlbum().get(0).getOriginal_path());
        entity.setId("");
        entity.setSell_price(new BigDecimal(mProductDetail.getSell_price()));
        entity.setTitle(mProductDetail.getTitle());
        entity.setUser_id(mUser.getResult().get_id());
        list.add(entity);
        Intent intent = new Intent(getActivity(), ConfirmOrderActivity.class);
        intent.putParcelableArrayListExtra(Constants.MESSAGE_EXTRA_KEY, list);
        BigDecimal total = new BigDecimal(mProductDetail.getSell_price()).multiply(new BigDecimal(str));
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY2, total.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        startActivity(intent);

    }


    private void toLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, "login_refresh_by_product_detail");
        startActivity(intent);
    }

    private void toShoppingCart() {
        EventBus.getDefault().post(new LoginResultEvent("Shopping"));
        EventBus.getDefault().post(new ProductDetailEvent("back"));
    }

    @Override
    public void addSuccess(BaseEntity paramBaseEntity) {
        ShowToast.Short(paramBaseEntity.getMessage());
        mProductDetail.setGwc_sum(mProductDetail.getGwc_sum() + 1);
        mTvShoppingCartSum.setText(mProductDetail.getGwc_sum() + "");
        EventBus.getDefault().post(new ShoppingCartEvent("refresh"));
    }

    @Override
    protected ProductFirstFragmentPresenter createPresenter() {
        return new ProductFirstFragmentPresenter(this);
    }

    @Override
    public void onClick(View v) {
        this.mUser = FYApplication.getContext().getUserEntity();
        switch (v.getId()) {
            case R.id.iv_back:
                EventBus.getDefault().post(new ProductDetailEvent("back"));
                break;
            case R.id.btn_add_shoppingcart:
                if (mUser != null) {
                    if (mProductDetail.getStock_quantity() == null || "0".equals(mProductDetail.getStock_quantity())) {
                        ShowToast.Short("该商品库存位0, 不能添加购物车!");
                        return;
                    }
                    String str = mEtNum.getText().toString().trim();
                    if (Integer.valueOf(str) <= 0) {
                        ShowToast.Short("请输入正确的商品数量!");
                        return;
                    }
                    mPresenter.getAddGoodscart(mUser.getResult().get_id(), mProductDetail.getGoods_id(), str);
                } else {
                    toLogin();
                }
                break;
            case R.id.iv_shopping_cart:
                if(mUser != null){
                    toShoppingCart();
                    return;
                }
                toLogin();
                break;
            case R.id.btn_buy:
                if(mUser != null){
                    toCreateOrder();
                    return;
                }
                toLogin();
                break;
            case R.id.rl_search:
                toSearch();
                break;
            case R.id.iv_minus:
                if(count <= 1){
                    return;
                }else{
                    count -= 1;
                    mEtNum.setText(count + "");
                }
                break;
            case R.id.iv_add:
                count += 1;
                mEtNum.setText(count + "");
                break;
        }
    }

    private void toSearch() {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, "");
        startActivity(intent);
    }
}