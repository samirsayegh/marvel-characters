package com.samirsayegh.marvelchars.view.main;

import com.samirsayegh.marvelchars.model.entities.Hero;
import com.samirsayegh.marvelchars.model.entities.OffsetList;
import com.samirsayegh.marvelchars.view.base.BaseView;

import java.util.List;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public interface MainView extends BaseView {

    void listLoaded(List<Hero> heroList);

    void listUpdated(List<Hero> heroList);

}
