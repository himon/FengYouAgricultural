package com.louis.agricultural.ui.view;

import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;

/**
 * Created by lc on 16/3/10.
 */
public interface IConfirmOrderView {
    void setCreateSuccess(BaseEntity data);

    void setDefaultAddress(ShoppingAddressEntity data);
}
