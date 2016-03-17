package com.louis.agricultural.ui.view;

import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;

/**
 * Created by lc on 16/3/8.
 */
public interface IAddShoppingAddressView {
    void addSuccess(BaseEntity data);

    void showAddress(ShoppingAddressEntity data);

    void updateSuccess(BaseEntity data);

    void delSuccess(BaseEntity data);
}
