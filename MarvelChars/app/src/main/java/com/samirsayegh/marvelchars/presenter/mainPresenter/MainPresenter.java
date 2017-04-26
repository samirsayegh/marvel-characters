package com.samirsayegh.marvelchars.presenter.mainPresenter;

import com.samirsayegh.marvelchars.domain.services.characterService.CharacterService;
import com.samirsayegh.marvelchars.domain.services.characterService.CharacterServiceResult;
import com.samirsayegh.marvelchars.model.entities.Hero;
import com.samirsayegh.marvelchars.presenter.base.BasePresenter;
import com.samirsayegh.marvelchars.view.main.MainView;

import java.util.List;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class MainPresenter extends BasePresenter implements CharacterServiceResult {

    private final MainView view;
    private final CharacterService characterService;

    public MainPresenter(MainView view) {
        super(view);
        this.view = view;
        characterService = new CharacterService(this);
    }

    public void updateCharacters() {
        view.showWaitingDialog();
        characterService.getCharacters();
    }

    @Override
    public void heroLoaded(List<Hero> heroList) {
        view.listLoaded(heroList);
        view.hideWaitingDialog();
    }
}
