package com.louis.agricultural.ui.view;

import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.UserEntity;

/**
 * Created by lc on 16/3/1.
 */
public interface IRegisterView {

    /**
     * 账号验证结果
     *
     * @param data
     */
    void setExistsMobileResult(BaseEntity data);

    /**
     * 验证手机号
     *
     * @param b
     */
    void setValidateResult(boolean b);

    /**
     * 验证密码结果
     *
     * @param b
     */
    void setValidatePwdResult(boolean b);

    /**
     * 验证再次输入的密码结果
     *
     * @param b
     */
    void setValidateRePwdResult(boolean b);

    /**
     * 注册成功
     *
     * @param data
     */
    void registerSuccess(UserEntity data);
}
