package com.louis.agricultural.ui.adapter;

import android.content.Context;

import com.louis.agricultural.R;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.entities.OrderEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;

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
public class ConfirmOrderAdapter extends CommonAdapter<ShoppingCartEntity.ResultEntity> {

    public ConfirmOrderAdapter(Context context, List<ShoppingCartEntity.ResultEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, ShoppingCartEntity.ResultEntity orderEntity) {
        holder.setText(R.id.tv_title, orderEntity.getTitle()).setText(R.id.tv_price, "￥" + orderEntity.getSell_price()).setText(R.id.tv_num, "x" + orderEntity.getSum());
    }
}
