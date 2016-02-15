
package com.louis.agricultural.utils;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.louis.agricultural.base.app.FYApplication;

public class ShowToast {

    public static void Short(@NonNull CharSequence sequence) {
        Toast.makeText(FYApplication.getContext(), sequence, Toast.LENGTH_SHORT).show();
    }

    public static void Long(@NonNull CharSequence sequence) {
        Toast.makeText(FYApplication.getContext(), sequence, Toast.LENGTH_SHORT).show();
    }

}
