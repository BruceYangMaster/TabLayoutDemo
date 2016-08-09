package com.bruce.tablayoutdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentArrayList;
    private ArrayList<String> stringArrayList;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> arrayList, ArrayList<String> stringArrayList) {
        super(fm);
        this.fragmentArrayList = arrayList;
        this.stringArrayList = stringArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {

        return stringArrayList.get(position % stringArrayList.size());
    }
}
