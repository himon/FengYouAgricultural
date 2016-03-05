package com.louis.agricultural.ui.adapter;

import android.content.Context;

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
public class MyOrderAdapter extends CommonAdapter<OrderEntity>{

    public MyOrderAdapter(Context context, List<OrderEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, OrderEntity orderEntity) {

    }
}
