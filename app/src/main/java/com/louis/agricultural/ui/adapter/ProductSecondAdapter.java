package com.louis.agricultural.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.louis.agricultural.ui.fragment.WebViewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/17 15:13
 * @des
 */
public class ProductSecondAdapter extends FragmentPagerAdapter {

    private List<String> mUrls = new ArrayList<>();

    public ProductSecondAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setUrls(List<String> urls) {
        mUrls = urls;
    }

    @Override
    public Fragment getItem(int position) {
        return WebViewFragment.newInstance(mUrls.get(position));
    }

    @Override
    public int getCount() {
        return mUrls.size();
    }
}
