package com.samirsayegh.marvelchars.model.services.characterService;


import com.samirsayegh.marvelchars.domain.entities.Hero;
import com.samirsayegh.marvelchars.domain.entities.OffsetList;
import com.samirsayegh.marvelchars.model.services.base.BaseServiceResult;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public interface CharacterServiceResult extends BaseServiceResult {

    void newHeroList(OffsetList<Hero> heroList);

    void offsetUpdated(OffsetList<Hero> heroList);

}
