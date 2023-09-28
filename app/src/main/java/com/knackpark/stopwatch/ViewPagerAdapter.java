package com.knackpark.stopwatch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {


public ViewPagerAdapter(FragmentManager fm){
    super(fm);
}

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new defaultFragment();
        }else {
            return new customFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Stopwatch";
        }else {
            return "Timer";
        }
    }
}
