package com.jrivera.bikecontrolandroid.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jrivera.bikecontrolandroid.fragments.DispositivosFragment;
import com.jrivera.bikecontrolandroid.fragments.FirstMapFragment;
import com.jrivera.bikecontrolandroid.fragments.SecondHistoryFragment;
import com.jrivera.bikecontrolandroid.fragments.ThirdCameraFragment;

/**
 * Created by Andres on 16/10/2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT =5;
    private String[] titles;

    public ViewPagerAdapter(FragmentManager fm, String[] titles2) {
        super(fm);
        titles=titles2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            // Open FragmentTab1.java
            case 0:
                return new FirstMapFragment();
            case 1:
                return new SecondHistoryFragment();
            case 2:
                return new ThirdCameraFragment();
            case 3:
                return new DispositivosFragment();
            case 4:
                return new DispositivosFragment();

        }
        return null;
    }

    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}