package com.louis.agricultural.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.model.entities.OrderEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.utils.manager.ImageLoadProxy;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

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

    private DisplayImageOptions mOptions;

    public ConfirmOrderAdapter(Context context, List<ShoppingCartEntity.ResultEntity> datas, int layoutId) {
        super(context, datas, layoutId);
        mOptions = ImageLoadProxy.getOption4ExactlyType();
    }

    @Override
    public void convert(ViewHolder holder, ShoppingCartEntity.ResultEntity orderEntity) {
        holder.setText(R.id.tv_title, orderEntity.getTitle()).setText(R.id.tv_price, "￥" + orderEntity.getSell_price()).setText(R.id.tv_num, "x" + orderEntity.getSum());

        ImageView imageView = holder.getView(R.id.iv_pic);
        ImageLoadProxy.displayImage(orderEntity.getImg_url(), imageView, mOptions);
    }
}
