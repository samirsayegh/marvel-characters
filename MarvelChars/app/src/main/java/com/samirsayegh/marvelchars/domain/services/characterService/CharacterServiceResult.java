package com.samirsayegh.marvelchars.domain.services.characterService;

import com.samirsayegh.marvelchars.domain.services.base.BaseServiceResult;
import com.samirsayegh.marvelchars.model.entities.Hero;

import java.util.List;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public interface CharacterServiceResult extends BaseServiceResult {

    void heroLoaded(List<Hero> heroList);

}
