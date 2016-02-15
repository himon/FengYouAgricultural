package com.louis.agricultural.ui.adapter;

import android.content.Context;

import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.entities.NewsEntity;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/15 11:40
 * @des
 */
public class NewsAdapter extends CommonAdapter<NewsEntity> {

    public NewsAdapter(Context context, List<NewsEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, NewsEntity newsEntity) {

    }
}
