package com.samirsayegh.marvelchars.view.heroDetails.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.samirsayegh.marvelchars.R;
import com.samirsayegh.marvelchars.domain.entities.BaseContent;
import com.samirsayegh.marvelchars.view.components.RecyclerScrollListener;
import com.samirsayegh.marvelchars.view.heroDetails.fragments.adapter.ComicsEventsAdapter;
import com.samirsayegh.marvelchars.view.main.adapter.MainAdapterListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yormirsamir.sayegh on 28/04/2017.
 */

public class ComicsEventsFragment extends Fragment implements MainAdapterListener {

    private final ComicsEventsAdapter comicsEventsAdapter;
    private RecyclerScrollListener recyclerScrollListener;
    private ComicEventsListener comicEventsListener;
    private int type;

    @BindView(R.id.recyclerViewComicEvents)
    RecyclerView recyclerView;

    public ComicsEventsFragment() {
        comicsEventsAdapter = new ComicsEventsAdapter();
        comicsEventsAdapter.setMainAdapterListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comics_events_fragment, container, false);
        ButterKnife.bind(this, view);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerScrollListener = new RecyclerScrollListener(linearLayoutManager, this);
        recyclerView.setAdapter(comicsEventsAdapter);
        recyclerView.addOnScrollListener(recyclerScrollListener);
    }

    public void setFragmentType(int type) {
        this.type = type;
    }

    public void setComicEventsListener(ComicEventsListener comicEventsListener) {
        this.comicEventsListener = comicEventsListener;
    }

    public void listLoaded(List<BaseContent> baseContents) {
        try {
            comicsEventsAdapter.setNewList(baseContents);
            comicsEventsAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            Logger.d("Adapter not visible yet");
        }
    }

    public void listUpdated(final List<BaseContent> baseContents) {
        try {
            comicsEventsAdapter.setAddToList(baseContents);
            recyclerScrollListener.loaded();
            comicsEventsAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            Logger.d("Adapter not visible yet");
        }
    }

    public void stopLoading() {
        if (recyclerScrollListener != null)
            recyclerScrollListener.loaded();
    }

    public boolean isLoadingMoreItems() {
        return recyclerScrollListener != null && recyclerScrollListener.isLoading();
    }

    @Override
    public void loadMoreElements() {
        comicEventsListener.loadMoreElements(type);
    }

    @Override
    public void onClick(View v) {

    }
}
