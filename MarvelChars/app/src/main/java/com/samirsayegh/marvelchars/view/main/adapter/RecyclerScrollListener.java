package com.samirsayegh.marvelchars.view.main.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by yormirsamir.sayegh on 28/04/2017.
 */

public class RecyclerScrollListener extends RecyclerView.OnScrollListener {

    private static final int THRESHOLD = 2;

    private final LinearLayoutManager linearLayoutManager;
    private final MainAdapterListener mainAdapterListener;

    private boolean loading;

    public RecyclerScrollListener(LinearLayoutManager linearLayoutManager,
                                  MainAdapterListener mainAdapterListener) {
        this.mainAdapterListener = mainAdapterListener;
        loading = false;
        this.linearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (!loading) {
            int totalItemCount = linearLayoutManager.getItemCount();
            int visibleItemCount = recyclerView.getChildCount();
            int firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
            if (totalItemCount - visibleItemCount <= firstVisibleItem + THRESHOLD) {
                if (mainAdapterListener != null) {
                    loading = true;
                    mainAdapterListener.loadMoreElements();
                }
            }
        }
    }

    public void loaded() {
        loading = false;
    }
}
