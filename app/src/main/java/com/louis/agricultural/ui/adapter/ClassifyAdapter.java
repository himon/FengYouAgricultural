package com.louis.agricultural.ui.adapter;

import android.content.Context;

import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/16 14:41
 * @des
 */
public class ClassifyAdapter extends CommonAdapter<String> {

    public ClassifyAdapter(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, String s) {

    }
}
