package com.example.advantal.chatscreenui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by advantal on 2/15/2016.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new TopRatedFragment();
            case 1: return new GamesFragment();
            case 2: return new MoviesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
