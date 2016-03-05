package com.louis.agricultural.view.autoscrollviewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import com.louis.agricultural.model.entities.HomeAdImageEntity;
import com.louis.agricultural.utils.DensityUtils;
import com.louis.agricultural.utils.manager.ImageLoadProxy;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class AdImageAdapter extends BaseAdapter {
    public List<HomeAdImageEntity.ResultEntity> imageUrls; // 图片地址list
    private Context context;
    private DisplayImageOptions mOptions;
    public int size;
    private int height;

    public AdImageAdapter(List<HomeAdImageEntity.ResultEntity> imageUrls, Context context) {
        this.imageUrls = imageUrls;
        this.size = imageUrls.size();
        this.context = context;
        height = (int) (DensityUtils.getDensity(context) * 120);
        mOptions = ImageLoadProxy.getOption4ExactlyType();
    }

    public int getCount() {
        return Integer.MAX_VALUE;
    }

    public HomeAdImageEntity.ResultEntity getItem(int position) {
        return imageUrls.get(position % size);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        if (convertView == null) {
            holderView = new HolderView();
            // 实例化convertView
            convertView = holderView.ivPic = new ImageView(context);
            // 设置缩放比例：保持原样
            holderView.ivPic.setScaleType(ImageView.ScaleType.CENTER_CROP);
            holderView.ivPic.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.MATCH_PARENT, height));
            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }
//        ImageLoader.getInstance().displayImage(getItem(position).getImg_url(), holderView.ivPic, mOptions);
        ImageLoadProxy.displayImage(getItem(position).getImg_url(), holderView.ivPic, mOptions);
        return convertView;
    }

    class HolderView {
        private ImageView ivPic;
    }
}
