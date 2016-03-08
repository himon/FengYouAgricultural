package com.louis.agricultural.ui.view;

import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ProductDetailEntity;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/1/23 15:10
 * @des
 */
public interface IProductDetailsView {
    void setDetail(ProductDetailEntity data);

    void addSuccess(BaseEntity data);
}
