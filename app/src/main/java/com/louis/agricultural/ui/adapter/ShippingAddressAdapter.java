package com.louis.agricultural.ui.adapter;

import android.content.Context;

import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.entities.ShippingAddressEntity;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/4 9:55
 * @des
 */
public class ShippingAddressAdapter extends CommonAdapter<ShippingAddressEntity> {

    public ShippingAddressAdapter(Context context, List<ShippingAddressEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, ShippingAddressEntity shippingAddressEntity) {

    }
}
