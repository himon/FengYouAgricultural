package com.louis.agricultural.net;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.louis.agricultural.base.app.FYApplication;

/**
 * Created by Administrator on 2015/7/23.
 */
public class RequestManager {

    public static RequestQueue mRequestQueue = Volley.newRequestQueue(FYApplication.getContext());

    private RequestManager() {
    }

    public static void addRequest(Request<?> request, Object tag) {
        if (tag != null) {
            request.setTag(tag);
        }
        mRequestQueue.add(request);

//		Logger.d("addRequest = " + request.getUrl());

    }

    public static void cancelAll(Object tag) {
        mRequestQueue.cancelAll(tag);
    }
}
