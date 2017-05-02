package com.samirsayegh.marvelchars.view.heroDetails;

import com.samirsayegh.marvelchars.domain.entities.BaseContent;
import com.samirsayegh.marvelchars.view.base.BaseView;

import java.util.List;

/**
 * Created by yormirsamir.sayegh on 28/04/2017.
 * Samir Dev
 */

public interface HeroDetailsView extends BaseView {

    void comicsLoaded(List<BaseContent> list, int totalComics);

    void comicsUpdated(List<BaseContent> list);

    void eventsLoaded(List<BaseContent> list, int totalEvents);

    void eventsUpdated(List<BaseContent> list);

    boolean isLoadingMoreComics();

    void stopLoadingComics();

    boolean isLoadingMoreEvents();

    void stopLoadingEvents();

}
