package com.louis.agricultural.ui.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.louis.agricultural.R;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.entities.OrderEntity;
import com.louis.agricultural.ui.adapter.ConfirmOrderAdapter;
import com.louis.agricultural.view.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 确认订单
 */
public class ConfirmOrderActivity extends BaseActivity {

    @Bind(R.id.listview)
    MyListView mListView;
    @Bind(R.id.btn_buy)
    Button mBtnBuy;

    private ConfirmOrderAdapter mAdapter;
    private List<OrderEntity> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        initEvent();
    }

    private void initEvent() {
        mBtnBuy.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        getData();
    }

    private void getData() {
        for (int i = 0; i < 5; i++) {
            OrderEntity entity = new OrderEntity();
            entity.setOrderId("617885566");
            entity.setType(1);
            entity.setTitle("鲁西 高塔尿基 40kg 复合肥料 总养分 >45%");
            entity.setDesc("颜色分类：黑颗粒符合菌肥");
            entity.setPrice("￥188");
            entity.setCount(2);
            mList.add(entity);
        }
        setData();
    }

    private void setData() {
        mAdapter = new ConfirmOrderAdapter(this, mList, R.layout.adapter_confirm_order);
        mListView.setAdapter(mAdapter);
    }

    @Override
    protected void click(View view) {
        switch (view.getId()){
            case R.id.btn_buy:
                toPay();
            break;
        }
    }

    private void toPay() {
        Intent intent = new Intent(this, PayActivity.class);
        startActivity(intent);
    }
}
