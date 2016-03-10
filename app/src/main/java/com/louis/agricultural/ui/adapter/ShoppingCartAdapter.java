package com.louis.agricultural.ui.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;
import com.louis.agricultural.model.event.ShoppingCartEvent;
import com.louis.agricultural.utils.manager.ImageLoadProxy;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/15 16:38
 * @des
 */
public class ShoppingCartAdapter extends CommonAdapter<ShoppingCartEntity.ResultEntity> {

    private DisplayImageOptions mOptions;

    public ShoppingCartAdapter(Context context, List<ShoppingCartEntity.ResultEntity> datas, int layoutId) {
        super(context, datas, layoutId);
        mOptions = ImageLoadProxy.getOption4ExactlyType();
    }

    @Override
    public void convert(ViewHolder holder, final ShoppingCartEntity.ResultEntity productEntity) {

        holder.setText(R.id.tv_title, productEntity.getTitle()).setText(R.id.tv_price, "￥" + productEntity.getSell_price());

        ImageView img = holder.getView(R.id.iv_img);
        ImageLoadProxy.displayImage(productEntity.getImg_url(), img, mOptions);

        final EditText etNum = holder.getView(R.id.et_num);
        ImageView ivMinus = holder.getView(R.id.iv_minus);
        ImageView ivAdd = holder.getView(R.id.iv_add);
        ivMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(etNum.getText().toString().trim());
                if(num <= 1){
                    num = 1;
                }else{
                    num--;
                }
                etNum.setText(num + "");
                productEntity.setSum(num + "");
            }
        });
        ivAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(etNum.getText().toString().trim());
                num++;
                etNum.setText(num + "");
                productEntity.setSum(num + "");
            }
        });

        CheckBox cb = holder.getView(R.id.cb_check);
        cb.setChecked(productEntity.isCheck());
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                productEntity.setCheck(isChecked);
                EventBus.getDefault().post(new ShoppingCartEvent("check"));
            }
        });
    }
}
