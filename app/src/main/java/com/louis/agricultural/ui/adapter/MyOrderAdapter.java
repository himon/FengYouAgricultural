package com.louis.agricultural.ui.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.model.entities.OrderEntity;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.event.MyOrderEvent;
import com.louis.agricultural.ui.activity.me.MyOrderActivity;

import java.util.List;

import de.greenrobot.event.EventBus;

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
    public void convert(ViewHolder holder, final OrderEntity.ResultEntity orderEntity) {

        TextView type = holder.getView(R.id.tv_type);
        Button right = holder.getView(R.id.btn_cancel_order);
        Button left = holder.getView(R.id.btn_pay);

        if ("2".equals(orderEntity.getStatus()) && "1".equals(orderEntity.getPayment_status())) {
            type.setText("待付款");
            type.setBackgroundColor(ContextCompat.getColor(mContext, R.color.button_yellow_bg));
            right.setText("取消订单");
            left.setText("前去付款");
            left.setVisibility(View.VISIBLE);
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyOrderEvent event = new MyOrderEvent("update");
                    event.setOrderId(orderEntity.getId());
                    event.setStatus("4");
                    EventBus.getDefault().post(event);
                }
            });
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //EventBus.getDefault().post(new MyOrderEvent("pay"));
                    MyOrderEvent event = new MyOrderEvent("update_pay");
                    event.setOrderId(orderEntity.getId());
                    event.setStatus("2");
                    EventBus.getDefault().post(event);
                }
            });
        } else if ("2".equals(orderEntity.getStatus()) && "2".equals(orderEntity.getPayment_status())) {
            type.setText("已发货");
            type.setBackgroundColor(ContextCompat.getColor(mContext, R.color.login_btn_bg));
            right.setText("确认收货");
            left.setVisibility(View.GONE);
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    MyOrderEvent event = new MyOrderEvent("update");
//                    event.setOrderId(orderEntity.getId());
//                    event.setStatus("3");
//                    EventBus.getDefault().post(event);
                    MyOrderEvent event = new MyOrderEvent("comment");
                    event.setOrderId(orderEntity.getId());

                    EventBus.getDefault().post(event);
                }
            });
        } else if ("3".equals(orderEntity.getStatus())) {
            type.setText("交易成功");
            type.setBackgroundColor(ContextCompat.getColor(mContext, R.color.login_btn_bg));
            right.setText("评价");
            left.setText("删除订单");
            left.setVisibility(View.VISIBLE);
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyOrderEvent event = new MyOrderEvent("comment");
                    event.setOrderId(orderEntity.getId());
                    EventBus.getDefault().post(event);
                }
            });
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyOrderEvent event = new MyOrderEvent("update");
                    event.setOrderId(orderEntity.getId());
                    event.setStatus("5");
                    EventBus.getDefault().post(event);
                }
            });
        }
        holder.setText(R.id.tv_order_no, "交易单" + orderEntity.getOrder_no()).setText(R.id.tv_desc, "共 " + orderEntity.getRow_number() + " 件商品  合计:￥" + orderEntity.getOrder_amount() + "(含运费￥" + orderEntity.getPayment_fee() + ")");
    }
}
