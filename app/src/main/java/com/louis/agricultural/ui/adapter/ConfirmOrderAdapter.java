package com.louis.agricultural.ui.adapter;

import android.content.Context;

import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.entities.OrderEntity;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/4 17:41
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class ConfirmOrderAdapter extends CommonAdapter<OrderEntity> {

    public ConfirmOrderAdapter(Context context, List<OrderEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, OrderEntity orderEntity) {

    }
}
