package com.louis.agricultural.ui.adapter;

import android.content.Context;

import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.entities.ProductEntity;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/16 15:25
 * @des
 */
public class SearchAdapter extends CommonAdapter<ProductEntity> {

    public SearchAdapter(Context context, List<ProductEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, ProductEntity productEntity) {

    }
}
