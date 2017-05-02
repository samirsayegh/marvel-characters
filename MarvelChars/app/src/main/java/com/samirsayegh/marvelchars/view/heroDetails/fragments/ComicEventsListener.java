package com.samirsayegh.marvelchars.view.heroDetails.fragments;

/**
 * Created by Samir DK on 5/1/2017.
 * Samir Dev
 */

public interface ComicEventsListener {

    /**
     * Load more elements for the fragment. It is given a type with the value of the current
     * fragment.
     * @param type HeroPagerAdapter fragment type.
     */
    void loadMoreElements(int type);
}
