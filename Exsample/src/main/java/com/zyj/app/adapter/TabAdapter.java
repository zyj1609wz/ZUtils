package com.zyj.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${zyj} on 2016/6/28.
 */
public class TabAdapter extends FragmentPagerAdapter  {
    private List<Fragment> list = new ArrayList<>();

    public TabAdapter(FragmentManager fm , List<Fragment> list ) {
        super(fm);
        this.list = list ;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get( position );
    }

}
