package com.louis.agricultural.presenter;

import android.app.Activity;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.entities.ShoppingAddressEntity;
import com.louis.agricultural.model.mode.AddShoppingAddressActivityMode;
import com.louis.agricultural.model.mode.impl.AddShoppingAddressActivityModeImpl;
import com.louis.agricultural.ui.activity.me.AddShoppingAddressActivity;
import com.louis.agricultural.ui.view.IAddShoppingAddressView;
import com.louis.agricultural.ui.view.IShoppingCartView;

/**
 * Created by lc on 16/3/8.
 */
public class AddShoppingAddressPresenter extends UserLosePresenter<IAddShoppingAddressView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private IAddShoppingAddressView mIAddShoppingAddressView;
    private AddShoppingAddressActivityMode mAddShoppingAddressActivityMode;


    public AddShoppingAddressPresenter(IAddShoppingAddressView view) {
        mIAddShoppingAddressView = view;
        mAddShoppingAddressActivityMode = new AddShoppingAddressActivityModeImpl((Activity) view);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag) {
            case Constants.GET_ADD_ADRESS_LISTENER:
                mIAddShoppingAddressView.addSuccess(data);
                break;
            case Constants.GET_ADRESS_SHOW_LISTENER:
                mIAddShoppingAddressView.showAddress((ShoppingAddressEntity) data);
                break;
            case Constants.UPDATE_ADRESS_LISTENER:
                mIAddShoppingAddressView.updateSuccess(data);
                break;
        }
    }


    /**
     * 添加收货地址
     *
     * @param user_id
     * @param sheng
     * @param shi
     * @param qu
     * @param xiangxi
     * @param code
     * @param shr
     * @param phone
     */
    public void getAddAddress(String user_id, String sheng, String shi, String qu, String xiangxi, String code, String shr, String phone, String status) {
        mAddShoppingAddressActivityMode.getAddAddress(user_id, sheng, shi, qu, xiangxi, code, shr, phone, status, this);
    }

    /**
     * 查看收货地址详情
     *
     * @param adress_id
     */
    public void getAdressShow(String adress_id) {
        mAddShoppingAddressActivityMode.getAdressShow(adress_id, this);
    }

    /**
     * 修改收货地址
     *
     * @param adress_id
     * @param user_id
     * @param sheng
     * @param shi
     * @param qu
     * @param xiangxi
     * @param code
     * @param shr
     * @param phone
     * @param status
     */
    public void updateAdress(String adress_id, String user_id, String sheng, String shi, String qu, String xiangxi, String code, String shr, String phone, String status) {
        mAddShoppingAddressActivityMode.updateAdress(adress_id, user_id, sheng, shi, qu, xiangxi, code, shr, phone, status, this);
    }
}
