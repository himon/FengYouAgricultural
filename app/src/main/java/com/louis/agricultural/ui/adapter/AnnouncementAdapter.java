package com.louis.agricultural.ui.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.entities.AnnouncementEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/15 10:55
 * @des
 */
public class AnnouncementAdapter extends CommonAdapter<AnnouncementEntity.ResultEntity> {

    public AnnouncementAdapter(Context context, List<AnnouncementEntity.ResultEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, AnnouncementEntity.ResultEntity announcementEntity) {

        TextView tvDate = holder.getView(R.id.tv_date);

        Date date = new Date(announcementEntity.getAdd_time());
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

        holder.setText(R.id.tv_content, announcementEntity.getTitle()).setText(R.id.tv_date, str);

    }
}
