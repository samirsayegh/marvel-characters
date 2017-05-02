package com.samirsayegh.marvelchars.presenter.heroDetailsPresenter;

import com.samirsayegh.marvelchars.domain.entities.BaseContent;
import com.samirsayegh.marvelchars.domain.entities.OffsetList;
import com.samirsayegh.marvelchars.model.services.detailsService.DetailsService;
import com.samirsayegh.marvelchars.model.services.detailsService.DetailsServiceResult;
import com.samirsayegh.marvelchars.presenter.base.BasePresenter;
import com.samirsayegh.marvelchars.view.heroDetails.HeroDetailsView;

/**
 * Created by Samir DK on 5/1/2017.
 * Samir Dev
 */

public class HeroDetailsPresenter extends BasePresenter implements DetailsServiceResult {

    private final HeroDetailsView view;
    private final DetailsService detailsService;

    private int currentOffsetComics;
    private int totalComics;
    private int currentOffsetEvents;
    private int totalEvents;
    private boolean isLoadingComics;
    private boolean isLoadingEvents;
    private int characterId;

    public HeroDetailsPresenter(HeroDetailsView baseView) {
        super(baseView);
        this.view = baseView;
        detailsService = new DetailsService(this);
        isLoadingComics = false;
        isLoadingEvents = false;
    }

    public void getLists(int characterId) {
        this.characterId = characterId;
        view.showWaitingDialog();
        getComics(characterId);
        getEvents(characterId);
    }

    public void loadMoreComics() {
        if (!view.isWaiting()) {
            if (currentOffsetComics + OFFSET_STEP < totalComics) {
                detailsService.getComicsOffset(characterId, currentOffsetComics + OFFSET_STEP);
            }
        }
    }

    public void loadMoreEvents() {
        if (!view.isWaiting()) {
            if (currentOffsetEvents + OFFSET_STEP < totalEvents) {
                detailsService.getEventsOffset(characterId, currentOffsetEvents + OFFSET_STEP);
            }
        }
    }

    private void getEvents(int characterId) {
        isLoadingEvents = true;
        detailsService.getEvents(characterId);
    }

    private void getComics(int characterId) {
        isLoadingComics = true;
        detailsService.getComics(characterId);
    }

    private void hideWaiting() {
        if (!isLoadingEvents && !isLoadingComics) {
            view.hideWaitingDialog();
        }
    }

    private void saveListPosition(OffsetList<BaseContent> list, boolean isComic) {
        if (isComic) {
            currentOffsetComics = list.getOffset();
            totalComics = list.getTotal();
        } else {
            currentOffsetEvents = list.getOffset();
            totalEvents = list.getTotal();
        }
    }

    @Override
    public void comicList(OffsetList<BaseContent> baseContentOffsetList, boolean isNew) {
        saveListPosition(baseContentOffsetList, true);
        isLoadingComics = false;
        if (isNew) {
            view.comicsLoaded(baseContentOffsetList.getList(), totalComics);
            hideWaiting();
        } else {
            view.comicsUpdated(baseContentOffsetList.getList());
        }
    }

    @Override
    public void eventList(OffsetList<BaseContent> baseContentOffsetList, boolean isNew) {
        saveListPosition(baseContentOffsetList, false);
        isLoadingEvents = false;
        if (isNew) {
            view.eventsLoaded(baseContentOffsetList.getList(), totalEvents);
            hideWaiting();
        } else {
            view.eventsUpdated(baseContentOffsetList.getList());
        }
    }

    @Override
    public void error(String message, boolean isComic) {
        if (isComic) {
            isLoadingComics = false;
            if (view.isLoadingMoreComics())
                view.stopLoadingComics();
        } else {
            isLoadingEvents = false;
            if (view.isLoadingMoreEvents())
                view.stopLoadingEvents();
        }
        if (!isLoadingEvents && !isLoadingComics)
            super.error(message);
    }
}
