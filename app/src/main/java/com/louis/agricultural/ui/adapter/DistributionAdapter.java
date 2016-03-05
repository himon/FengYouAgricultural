package com.louis.agricultural.ui.adapter;

import android.content.Context;

import com.louis.agricultural.base.adapter.CommonAdapter;
import com.louis.agricultural.base.adapter.ViewHolder;
import com.louis.agricultural.model.entities.DistributionEntity;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/15 11:56
 * @des
 */
public class DistributionAdapter extends CommonAdapter<DistributionEntity>{

    public DistributionAdapter(Context context, List<DistributionEntity> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, DistributionEntity distributionEntity) {

    }
}
