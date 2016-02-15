package com.louis.agricultural.ui.adapter;

import android.content.Context;

import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.entities.AnnouncementEntity;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/15 10:55
 * @des
 */
public class AnnouncementAdapter extends CommonAdapter<AnnouncementEntity>{

    public AnnouncementAdapter(Context context, List<AnnouncementEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, AnnouncementEntity announcementEntity) {

    }
}
