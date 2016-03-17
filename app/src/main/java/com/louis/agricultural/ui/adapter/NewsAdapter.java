package com.louis.agricultural.ui.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.entities.AnnouncementEntity;
import com.louis.agricultural.model.entities.NewsEntity;
import com.louis.agricultural.utils.manager.ImageLoadProxy;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/15 11:40
 * @des
 */
public class NewsAdapter extends CommonAdapter<AnnouncementEntity.ResultEntity> {

    private DisplayImageOptions mOptions;

    public NewsAdapter(Context context, List<AnnouncementEntity.ResultEntity> datas, int layoutId) {
        super(context, datas, layoutId);
        mOptions = ImageLoadProxy.getOption4ExactlyType();
    }

    @Override
    public void convert(ViewHolder holder, AnnouncementEntity.ResultEntity newsEntity) {
        ImageView img = holder.getView(R.id.iv_img);

        ImageLoadProxy.displayImage(newsEntity.getImg_url(), img, mOptions);

        TextView tvDate = holder.getView(R.id.tv_date);
        Date date = new Date(newsEntity.getAdd_time());
        Date now = new Date();
        long time = now.getTime() - date.getTime();
        long day = time / (24 * 60 * 60 * 1000);
        String str = "";
        if (day < 1) {
            str = "今天";
            tvDate.setBackgroundColor(ContextCompat.getColor(mContext, R.color.button_yellow_bg));
        } else {
            str = day + "天前";
            tvDate.setBackgroundColor(ContextCompat.getColor(mContext, R.color.radio_group_gray_bg));
        }
        tvDate.setText(str);

        holder.setText(R.id.tv_title, newsEntity.getTitle()).setText(R.id.tv_content, newsEntity.getZhaiyao());
    }
}
