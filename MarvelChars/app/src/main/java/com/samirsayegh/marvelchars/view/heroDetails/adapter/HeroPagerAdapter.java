package com.samirsayegh.marvelchars.view.heroDetails.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.samirsayegh.marvelchars.domain.entities.BaseContent;
import com.samirsayegh.marvelchars.view.heroDetails.fragments.ComicEventsListener;
import com.samirsayegh.marvelchars.view.heroDetails.fragments.ComicsEventsFragment;

import java.util.List;

/**
 * Created by yormirsamir.sayegh on 28/04/2017.
 * Samir Dev
 */

public class HeroPagerAdapter extends FragmentStatePagerAdapter {

    private static final int TABS = 2;
    public static final int COMICS = 0;
    public static final int EVENTS = 1;

    private ComicEventsListener comicEventsListener;
    private ComicsEventsFragment comicsFragment;
    private ComicsEventsFragment eventsFragment;

    public HeroPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return TABS;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == COMICS) {
            if (comicsFragment == null) {
                comicsFragment = newFragment(position);
            }
            return comicsFragment;
        } else {
            if (eventsFragment == null) {
                eventsFragment = newFragment(position);
            }
            return eventsFragment;
        }
    }

    private ComicsEventsFragment newFragment(int position) {
        ComicsEventsFragment comicsFragment = new ComicsEventsFragment();
        if (comicEventsListener != null)
            comicsFragment.setComicEventsListener(comicEventsListener);
        comicsFragment.setFragmentType(position);
        return comicsFragment;
    }

    private ComicsEventsFragment getFragment(int position) {
        if(position == COMICS)
            return comicsFragment;
        return eventsFragment;
    }

    public boolean isLoadingMoreComics() {
        return isLoadingMore(COMICS);
    }

    public boolean isLoadingMoreEvents() {
        return isLoadingMore(EVENTS);
    }

    private boolean isLoadingMore(int type) {
        ComicsEventsFragment comicsEventsFragment = getFragment(type);
        return comicsEventsFragment != null && comicsEventsFragment.isLoadingMoreItems();
    }

    public void stopLoadingComics() {
        stopLoading(COMICS);
    }

    public void stopLoadingEvents() {
        stopLoading(EVENTS);
    }

    private void stopLoading(int type) {
        ComicsEventsFragment comicsEventsFragment = getFragment(type);
        if (comicsEventsFragment != null)
            comicsEventsFragment.stopLoading();
    }

    public void comicsLoaded(List<BaseContent> list) {
        listLoaded(list, COMICS);
    }

    public void eventsLoaded(List<BaseContent> list) {
        listLoaded(list, EVENTS);
    }

    private void listLoaded(List<BaseContent> list, int type) {
        ComicsEventsFragment comicsEventsFragment = getFragment(type);
        if (comicsEventsFragment != null) {
            comicsEventsFragment.listLoaded(list);
        }
    }

    public void comicsUpdated(List<BaseContent> list) {
        listUpdated(list, COMICS);
    }

    public void eventsUpdated(List<BaseContent> list) {
        listUpdated(list, EVENTS);
    }

    private void listUpdated(List<BaseContent> list, int type) {
        ComicsEventsFragment comicsEventsFragment = getFragment(type);
        if (comicsEventsFragment != null) {
            comicsEventsFragment.listUpdated(list);
        }
    }

    public void setListener(ComicEventsListener comicEventsListener) {
        this.comicEventsListener = comicEventsListener;
        setListenerToFragment(COMICS);
        setListenerToFragment(EVENTS);
    }

    private void setListenerToFragment(int type) {
        ComicsEventsFragment comicsEventsFragment = getFragment(type);
        if (comicsEventsFragment != null) {
            comicsEventsFragment.setComicEventsListener(comicEventsListener);
        }
    }
}
