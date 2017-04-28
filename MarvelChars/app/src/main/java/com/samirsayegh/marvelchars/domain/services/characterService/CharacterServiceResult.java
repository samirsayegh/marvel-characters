package com.samirsayegh.marvelchars.domain.services.characterService;

import com.samirsayegh.marvelchars.domain.services.base.BaseServiceResult;
import com.samirsayegh.marvelchars.model.entities.Hero;
import com.samirsayegh.marvelchars.model.entities.OffsetList;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public interface CharacterServiceResult extends BaseServiceResult {

    void newHeroList(OffsetList<Hero> heroList);

    void offsetUpdated(OffsetList<Hero> heroList);

}
