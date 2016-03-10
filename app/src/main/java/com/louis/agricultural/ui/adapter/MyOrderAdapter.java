package com.louis.agricultural.ui.adapter;

import android.content.Context;

import com.louis.agricultural.R;
import com.louis.agricultural.model.entities.OrderEntity;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/3 17:35
 * @des
 */
public class MyOrderAdapter extends CommonAdapter<OrderEntity.ResultEntity> {

    public MyOrderAdapter(Context context, List<OrderEntity.ResultEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, OrderEntity.ResultEntity orderEntity) {
        holder.setText(R.id.tv_order_no, "交易单" + orderEntity.getOrder_no()).setText(R.id.tv_desc, "共 " + orderEntity.getRow_number() + " 件商品  合计:￥" + orderEntity.getOrder_amount() + "(含运费￥" + orderEntity.getPayment_fee() + ")");
    }
}
