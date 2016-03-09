package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.activity.MVPBaseActivity;
import com.louis.agricultural.base.app.FYApplication;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;
import com.louis.agricultural.model.entities.UserEntity;
import com.louis.agricultural.model.event.ConfirmOrderEvent;
import com.louis.agricultural.model.event.LoginResultEvent;
import com.louis.agricultural.model.event.ShoppingAddressEvent;
import com.louis.agricultural.presenter.ShoppingAddressActivityPresenter;
import com.louis.agricultural.ui.adapter.ShippingAddressAdapter;
import com.louis.agricultural.ui.view.IShoppingAddressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 收货地址
 */
public class ShoppingAddressActivity extends MVPBaseActivity<IShoppingAddressView, ShoppingAddressActivityPresenter> implements IShoppingAddressView {

    @Bind(R.id.listview)
    ListView mListView;
    @Bind(R.id.btn_add_address)
    Button mBtnAdd;

    private ShoppingAddressActivityPresenter mPresenter;
    private ShippingAddressAdapter mAdapter;

    private UserEntity.ResultEntity mUser;
    private List<ShoppingAddressEntity.ResultEntity> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        mPresenter = mMPresenter;
        initView();
        initData();
    }

    @Override
    protected ShoppingAddressActivityPresenter createPresenter() {
        return new ShoppingAddressActivityPresenter(this);
    }

    @Override
    protected void initView() {

        initTitle("收货地址");

        mAdapter = new ShippingAddressAdapter(this, mList, R.layout.adapter_shipping_address);
        mListView.setAdapter(mAdapter);

        initEvent();
    }

    private void initEvent() {
        mBtnAdd.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mUser = FYApplication.getContext().getUserEntity().getResult();
        getData();
    }

    private void getData() {
        mPresenter.getAdress(mUser.get_id());
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_add_address:
                toAdd();
                break;
        }
    }

    private void toAdd() {
        Intent intent = new Intent(this, AddShoppingAddressActivity.class);
        startActivity(intent);
    }

    @Override
    public void setShoppingAddressData(ShoppingAddressEntity data) {
        mList = data.getResult();
        for (ShoppingAddressEntity.ResultEntity item : mList) {
            if ("1".equals(item.getStatus())) {
                item.setCheck(true);
            }
        }
        mAdapter.setmDatas(mList);
        mAdapter.notifyDataSetChanged();
    }

    public void onEvent(ShoppingAddressEvent event) {
        if ("refresh".equals(event.getMsg())) {
            getData();
        }else if("select".equals(event.getMsg())){
            for (ShoppingAddressEntity.ResultEntity item : mList) {
                if (item.isCheck()) {
                    ConfirmOrderEvent selected = new ConfirmOrderEvent("selected");
                    selected.setAddressId(item.getId());
                    selected.setAddress(item.getSheng() + item.getShi() + item.getQu() + item.getXiangxi());
                    selected.setStatus(item.getStatus());
                    EventBus.getDefault().post(selected);
                    back();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
