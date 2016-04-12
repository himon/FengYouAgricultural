package com.louis.agricultural.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.base.presenter.UserLosePresenter;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.entities.BaseEntity;
import com.louis.agricultural.model.mode.CommentActivityMode;
import com.louis.agricultural.model.mode.impl.CommentActivityModeImpl;
import com.louis.agricultural.ui.activity.me.CommentActivity;
import com.louis.agricultural.ui.view.ICommentView;
import com.louis.agricultural.utils.ShowToast;
import com.louis.agricultural.utils.TextUtil;

/**
 * Created by Administrator on 2016/4/11.
 */
public class CommentActivityPresenter extends UserLosePresenter<ICommentView> implements UserLoseMultiLoadedListener<BaseEntity> {

    private ICommentView mICommentView;
    private CommentActivityMode mCommentActivityMode;

    public CommentActivityPresenter(ICommentView iCommentView) {
        this.mICommentView = iCommentView;
        this.mCommentActivityMode = new CommentActivityModeImpl((Activity) iCommentView);
    }

    @Override
    public void onSuccess(int event_tag, BaseEntity data) {
        switch (event_tag){
            case Constants.ADD_GOODS_COMMENT_LISTENER:
                mICommentView.setCommnetSuccess(data);
                break;
        }
    }


    public void comment(String goods_id, String user_id, String user_name, String conment, String order_goods_id) {
        if(TextUtils.isEmpty(conment)){
            ShowToast.Short("请输入评论内容！");
            return;
        }
        mCommentActivityMode.addGoodsComment(goods_id, user_id, user_name, conment, order_goods_id, this);
    }

}