package com.louis.agricultural.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/2/3 17:11
 * @des
 */
public class TabAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public TabAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.list = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
