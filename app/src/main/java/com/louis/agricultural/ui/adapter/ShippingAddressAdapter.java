package com.louis.agricultural.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;
import com.louis.agricultural.model.event.ShoppingAddressEvent;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/4 9:55
 * @des
 */
public class ShippingAddressAdapter extends CommonAdapter<ShoppingAddressEntity.ResultEntity> {

    public ShippingAddressAdapter(Context context, List<ShoppingAddressEntity.ResultEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, final ShoppingAddressEntity.ResultEntity shippingAddressEntity) {

        holder.setText(R.id.tv_name, shippingAddressEntity.getShr()).setText(R.id.tv_mobile, shippingAddressEntity.getPhone()).setText(R.id.tv_address, shippingAddressEntity.getSheng() + shippingAddressEntity.getShi() + shippingAddressEntity.getQu() + shippingAddressEntity.getXiangxi());

        ImageView edit = holder.getView(R.id.iv_edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        CheckBox cb = holder.getView(R.id.cb_check);
        TextView status = holder.getView(R.id.tv_status);

        if(shippingAddressEntity.isCheck()){
            cb.setChecked(true);
        }else{
            cb.setChecked(false);
        }

        if ("1".equals(shippingAddressEntity.getStatus())) {
            status.setVisibility(View.VISIBLE);
        }else{
            status.setVisibility(View.GONE);
        }

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    for(ShoppingAddressEntity.ResultEntity item : mDatas){
                        item.setCheck(false);
                    }
                    shippingAddressEntity.setCheck(true);
                }else{
                    shippingAddressEntity.setCheck(false);
                }
                notifyDataSetChanged();
                EventBus.getDefault().post(new ShoppingAddressEvent("select"));
            }
        });
    }
}
