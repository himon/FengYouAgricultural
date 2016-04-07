package com.louis.agricultural.ui.view;

import com.louis.agricultural.model.entities.BaseEntity;

/**
 * Created by lc on 16/3/2.
 */
public interface IUserInfoView {
    void updateSuccess(BaseEntity data, String date);

    void setUserImg(BaseEntity data);
}
