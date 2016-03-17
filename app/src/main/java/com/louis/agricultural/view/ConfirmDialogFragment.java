package com.louis.agricultural.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by lc on 16/3/15.
 * 用来创建确认对话框
 */
public class ConfirmDialogFragment extends DialogFragment {

    private ConfirmDialogListener mListener;

    //对外开放的接口
    public static interface ConfirmDialogListener extends DialogInterface.OnClickListener {
    }

    /**
     * @param title
     * @param message
     * @param cancelable
     * @return
     */
    public static ConfirmDialogFragment newInstance(String title, String message, boolean cancelable) {
        ConfirmDialogFragment instance = new ConfirmDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);
        args.putBoolean("cancelable", cancelable);
        instance.setArguments(args);
        return instance;
    }
}
