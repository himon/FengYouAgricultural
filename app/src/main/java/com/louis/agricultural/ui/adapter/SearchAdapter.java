package com.louis.agricultural.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.entities.ProductEntity;
import com.louis.agricultural.utils.manager.ImageLoadProxy;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/16 15:25
 * @des
 */
public class SearchAdapter extends CommonAdapter<ProductEntity.ResultEntity> {

    private DisplayImageOptions mOptions;

    public SearchAdapter(Context context, List<ProductEntity.ResultEntity> datas, int layoutId) {
        super(context, datas, layoutId);
        mOptions = ImageLoadProxy.getOption4ExactlyType();
    }

    @Override
    public void convert(ViewHolder holder, ProductEntity.ResultEntity productEntity) {
        holder.setText(R.id.tv_title, productEntity.getTitle());

        ImageView image = holder.getView(R.id.iv_img);
        ImageLoadProxy.displayImage(productEntity.getImg_url(), image, mOptions);
    }
}
