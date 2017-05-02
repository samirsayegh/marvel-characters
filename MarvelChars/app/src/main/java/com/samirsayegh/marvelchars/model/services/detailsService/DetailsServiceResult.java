package com.samirsayegh.marvelchars.model.services.detailsService;

import com.samirsayegh.marvelchars.domain.entities.BaseContent;
import com.samirsayegh.marvelchars.domain.entities.OffsetList;
import com.samirsayegh.marvelchars.model.services.base.BaseServiceResult;

/**
 * Created by Samir DK on 5/1/2017.
 * Samir Dev
 */

public interface DetailsServiceResult extends BaseServiceResult {

    void comicList(OffsetList<BaseContent> baseContentOffsetList, boolean isNew);

    void eventList(OffsetList<BaseContent> baseContentOffsetList, boolean isNew);

    void error(String message, boolean isComic);
}
