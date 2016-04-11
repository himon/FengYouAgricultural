package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.OrderEntity;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.ConfirmOrderEvent;
import com.louis.agricultural.model.event.ShoppingAddressEvent;
import com.louis.agricultural.presenter.ConfirmOrderActivityPresenter;
import com.louis.agricultural.ui.activity.ProductDetailsActivity;
import com.louis.agricultural.ui.adapter.ConfirmOrderAdapter;
import com.louis.agricultural.ui.view.IConfirmOrderView;
import com.louis.agricultural.utils.ShowToast;
import com.louis.agricultural.view.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 确认订单
 */
public class ConfirmOrderActivity extends MVPBaseActivity<IConfirmOrderView, ConfirmOrderActivityPresenter> implements IConfirmOrderView {

    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.tv_mobile)
    TextView mTvMobile;
    @Bind(R.id.rl_address)
    RelativeLayout mRlAddress;
    @Bind(R.id.tv_type)
    TextView mTvType;
    @Bind(R.id.tv_address)
    TextView mTvAddress;
    @Bind(R.id.listview)
    MyListView mListView;
    @Bind(R.id.tv_total_price)
    TextView mTvTotal;
    @Bind(R.id.btn_buy)
    Button mBtnBuy;
    @Bind(R.id.rg_pay_type)
    RadioGroup mRgPay;
    @Bind(R.id.rb_line_pay)
    RadioButton mRbLinePay;
    @Bind(R.id.rb_arrive_pay)
    RadioButton mRbArrivePay;

    private ConfirmOrderActivityPresenter mPresenter;

    private ConfirmOrderAdapter mAdapter;
    private UserEntity.ResultEntity mUser;
    private ArrayList<ShoppingCartEntity.ResultEntity> mList;
    /**
     * 地址id
     */
    private String mAddressId;
    /**
     * 地址详情
     */
    private String mAddress;
    /**
     * 是否是默认地址
     */
    private String mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected ConfirmOrderActivityPresenter createPresenter() {
        return new ConfirmOrderActivityPresenter(this);
    }

    @Override
    protected void initView() {
        initTitle("确认订单");
        initEvent();
    }

    private void initEvent() {
        mRlAddress.setOnClickListener(this);
        mBtnBuy.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mUser = FYApplication.getContext().getUserEntity().getResult();

        mPresenter.getDefaultAdress(mUser.get_id());

        mTvName.setText(mUser.get_user_name());
        mTvMobile.setText(mUser.get_mobile());
        Intent intent = getIntent();
        if (intent != null) {
            mList = intent.getParcelableArrayListExtra(Constants.MESSAGE_EXTRA_KEY);
            String total = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY2);
            mTvTotal.setText("还需支付：￥" + total.substring(total.indexOf("￥") + 1, total.length()));
            mAdapter = new ConfirmOrderAdapter(this, mList, R.layout.adapter_confirm_order);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ShoppingCartEntity.ResultEntity entity = (ShoppingCartEntity.ResultEntity) parent.getAdapter().getItem(position);
                    toProductDetail(entity.getGoods_id());
                }
            });
            mListView.setAdapter(mAdapter);
        }
        mRgPay.check(R.id.rb_line_pay);
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_buy:
                createOrder();
                break;
            case R.id.rl_address:
                toSelectAddress();
                break;
        }
    }

    /**
     * 生成订单
     */
    private void createOrder() {

        if (TextUtils.isEmpty(mAddressId)) {
            ShowToast.Short("请选择收货地址!");
            return;
        }

        if (!mRbLinePay.isChecked() && !mRbArrivePay.isChecked()) {
            ShowToast.Short("请选择付款方式!");
        } else if (mRbLinePay.isChecked()) {
            mPresenter.addOrder(mUser.get_id(), mAddressId, "", mUser.get_user_name(), mList);
        } else if (mRbArrivePay.isChecked()) {
            toOrderList();
        }
    }

    private void toOrderList() {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

    private void toSelectAddress() {
        Intent intent = new Intent(this, ShoppingAddressActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, "order");
        startActivity(intent);
    }

    private void toPay() {
        Intent intent = new Intent(this, PayActivity.class);
        startActivity(intent);
    }

    private void toProductDetail(String goods_id) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra(Constants.MESSAGE_EXTRA_KEY, goods_id);
        startActivity(intent);
    }

    public void onEvent(ConfirmOrderEvent event) {
        if ("selected".equals(event.getMsg())) {
            mAddress = event.getAddress();
            mAddressId = event.getAddressId();
            mStatus = event.getStatus();
            if ("1".equals(mStatus)) {
                mTvType.setVisibility(View.VISIBLE);
            } else {
                mTvType.setVisibility(View.GONE);
            }
            mTvAddress.setText(mAddress);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void setCreateSuccess(BaseEntity data) {
        ShowToast.Short(data.getMessage());
        toPay();
    }

    @Override
    public void setDefaultAddress(ShoppingAddressEntity data) {
        ShoppingAddressEntity.ResultEntity entity = data.getResult().get(0);
        mAddressId = entity.getId();
        mAddress = entity.getSheng() + entity.getShi() + entity.getQu() + entity.getXiangxi();
        mTvAddress.setText(mAddress);
    }
}
