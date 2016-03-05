package com.louis.agricultural.ui.view;

import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.FytjEntity;
import com.louis.agricultural.model.entities.FyttEntity;
import com.louis.agricultural.model.entities.HomeAdImageEntity;

/**
 * Created by lc on 16/2/29.
 */
public interface IHomeView {

    /**
     * 设置首页滚动广告
     * @param data
     */
    void setViewPagerAd(HomeAdImageEntity data);

    /**
     * 丰友头条
     * @param data
     */
    void setFytt(FyttEntity data);

    /**
     * 首页推荐
     * @param data
     */
    void setFytj(FytjEntity data);

    /**
     * 首页热销排行
     * @param data
     */
    void setRmtj(FytjEntity data);
}
