package com.louis.agricultural.ui.view;

import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.OrderDetailEntity;

/**
 * Created by Administrator on 2016/4/11.
 */
public interface IOrderDetailView {
    void setData(OrderDetailEntity data);

    void setUpdateOrderSuccess(BaseEntity data);
}
