package com.samirsayegh.marvelchars.view.heroDetails.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.samirsayegh.marvelchars.view.heroDetails.fragments.ComicsEventsFragment;

/**
 * Created by yormirsamir.sayegh on 28/04/2017.
 */

public class HeroPagerAdapter extends FragmentStatePagerAdapter {

    private static final int tabs = 2;
    public static final int COMICS = 0;
    public static final int EVENTS = 1;

    public HeroPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return tabs;
    }

    @Override
    public Fragment getItem(int position) {
        ComicsEventsFragment comicsEventsFragment = new ComicsEventsFragment();
        switch (position) {
            case COMICS:
                comicsEventsFragment.setFragmentType(COMICS);
                return comicsEventsFragment;
            case EVENTS:
                comicsEventsFragment.setFragmentType(COMICS);
                return comicsEventsFragment;
            default:
                return null;
        }
    }
}
