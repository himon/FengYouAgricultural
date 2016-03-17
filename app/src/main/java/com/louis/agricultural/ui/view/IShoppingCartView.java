package com.louis.agricultural.ui.view;

import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ShoppingCartEntity;

/**
 * Created by lc on 16/3/7.
 */
public interface IShoppingCartView {

    void setShoppingCart(ShoppingCartEntity data);

    void setDeleteSuccess(BaseEntity data);
}
