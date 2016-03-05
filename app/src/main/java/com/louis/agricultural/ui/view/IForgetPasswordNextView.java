package com.louis.agricultural.ui.view;

import com.louis.agricultural.model.entities.BaseEntity;

/**
 * Created by lc on 16/3/2.
 */
public interface IForgetPasswordNextView {

    void validatePwdResult(boolean b);

    void validateRePwdResult(boolean b);

    void validateOldPwdResult(boolean b);

    void updateSuccess(BaseEntity data);
}
