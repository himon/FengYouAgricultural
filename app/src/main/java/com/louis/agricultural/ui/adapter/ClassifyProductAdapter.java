package com.louis.agricultural.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.utils.manager.ImageLoadProxy;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.List;

/**
 * Created by lc on 16/3/6.
 */
public class ClassifyProductAdapter extends CommonAdapter<ProductEntity.ResultEntity> {

    private DisplayImageOptions mOptions;

    public ClassifyProductAdapter(Context context, List<ProductEntity.ResultEntity> datas, int layoutId) {
        super(context, datas, layoutId);
        mOptions = ImageLoadProxy.getOption4ExactlyType();
    }

    @Override
    public void convert(ViewHolder holder, ProductEntity.ResultEntity fytjEntity) {
        ImageView img = holder.getView(R.id.iv_img);
        ImageLoadProxy.displayImage(fytjEntity.getImg_url(), img, mOptions);
        TextView price = holder.getView(R.id.tv_price);

        if (TextUtils.isEmpty(fytjEntity.getSell_price()) || "0".equals(fytjEntity.getSell_price()) || "0.00".equals(fytjEntity.getSell_price())) {
            price.setVisibility(View.GONE);
        } else {
            price.setText("￥" + fytjEntity.getSell_price());
        }
        holder.setText(R.id.tv_desc, fytjEntity.getTitle()).setText(R.id.tv_no, fytjEntity.getGoods_no());
    }
}
