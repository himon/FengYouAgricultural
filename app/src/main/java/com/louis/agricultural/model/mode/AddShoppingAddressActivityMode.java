package com.louis.agricultural.model.mode;

import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.presenter.AddShoppingAddressPresenter;

/**
 * Created by lc on 16/3/8.
 */
public interface AddShoppingAddressActivityMode {
    void getAddAddress(String user_id, String sheng, String shi, String qu, String xiangxi, String code, String shr, String phone, String status, UserLoseMultiLoadedListener listener);

    void getAdressShow(String adress_id, UserLoseMultiLoadedListener listener);

    void updateAdress(String adress_id, String user_id, String sheng, String shi, String qu, String xiangxi, String code, String shr, String phone, String status, UserLoseMultiLoadedListener listener);

    void deleteAdress(String adress_id, UserLoseMultiLoadedListener listener);
}
