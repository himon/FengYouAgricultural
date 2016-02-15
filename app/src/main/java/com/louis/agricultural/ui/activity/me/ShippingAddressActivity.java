package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.entities.ShippingAddressEntity;
import com.louis.agricultural.ui.adapter.ShippingAddressAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 收货地址
 */
public class ShippingAddressActivity extends BaseActivity {

    @Bind(R.id.listview)
    ListView mListView;
    @Bind(R.id.btn_add_address)
    Button mBtnAdd;

    private ShippingAddressAdapter mAdapter;
    private List<ShippingAddressEntity> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        mAdapter = new ShippingAddressAdapter(this, mList, R.layout.adapter_shipping_address);
        mListView.setAdapter(mAdapter);

        initEvent();
    }

    private void initEvent() {
        mBtnAdd.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        getData();
    }

    private void getData() {
        for (int i = 0; i < 6; i++) {
            ShippingAddressEntity entity = new ShippingAddressEntity();
            entity.setName("欧阳慧");
            entity.setMobile("15844738964");
            entity.setAddress("上海市浦东新区长青路579弄6号602室");
            mList.add(entity);
        }
        mAdapter.notifyDataSetChanged();
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
        Intent intent = new Intent(this, AddShippingAddressActivity.class);
        startActivity(intent);
    }
}
