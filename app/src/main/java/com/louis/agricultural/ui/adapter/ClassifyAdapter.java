package com.louis.agricultural.ui.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.louis.agricultural.R;
import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.entities.ClassifyEntity;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/16 14:41
 * @des
 */
public class ClassifyAdapter extends CommonAdapter<ClassifyEntity.ResultEntity> {

    public ClassifyAdapter(Context context, List<ClassifyEntity.ResultEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, ClassifyEntity.ResultEntity resultEntity) {
        TextView classify = holder.getView(R.id.tv_classify);
        classify.setText(resultEntity.getTitle());
        View line = holder.getView(R.id.view_line);
        if (resultEntity.isChecked()) {
            line.setBackgroundColor(ContextCompat.getColor(mContext, R.color.home_tab_red_bg));
            classify.setTextColor(ContextCompat.getColor(mContext, R.color.home_tab_red_bg));
        } else {
            line.setBackgroundColor(ContextCompat.getColor(mContext, R.color.main_search_font_gray));
            classify.setTextColor(ContextCompat.getColor(mContext, R.color.main_search_font_gray));
        }
    }
}
