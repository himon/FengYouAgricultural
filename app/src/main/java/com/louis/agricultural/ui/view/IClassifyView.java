package com.louis.agricultural.ui.view;

import com.louis.agricultural.model.entities.BankEntity;
import com.louis.agricultural.model.entities.ClassifyEntity;
import com.louis.agricultural.model.entities.ProductEntity;

/**
 * Created by lc on 16/3/6.
 */
public interface IClassifyView {
    void setClassify(ClassifyEntity data);

    void setProducts(ProductEntity data);

    void setSecondClassify(ClassifyEntity data);

    void setGoodsBank(BankEntity data);
}
