package com.samirsayegh.marvelchars.presenter.mainPresenter;

import com.samirsayegh.marvelchars.domain.entities.Hero;
import com.samirsayegh.marvelchars.domain.entities.OffsetList;
import com.samirsayegh.marvelchars.model.services.characterService.CharacterService;
import com.samirsayegh.marvelchars.model.services.characterService.CharacterServiceResult;
import com.samirsayegh.marvelchars.presenter.base.BasePresenter;
import com.samirsayegh.marvelchars.view.main.MainView;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class MainPresenter extends BasePresenter implements CharacterServiceResult {

    private static final int OFFSET_STEP = 20;

    private final MainView view;
    private final CharacterService characterService;
    private int currentOffset;
    private int total;

    public MainPresenter(MainView view) {
        super(view);
        this.view = view;
        characterService = new CharacterService(this);
    }

    public void retrieveCharacters() {
        view.showWaitingDialog();
        characterService.getCharacters();
    }

    private void saveListPosition(OffsetList<Hero> heroList) {
        currentOffset = heroList.getOffset();
        total = heroList.getTotal();
    }

    public void loadMoreElements() {
        if(!view.isWaiting()) {
            if(currentOffset + OFFSET_STEP < total) {
                characterService.getCharactersOffset(currentOffset + OFFSET_STEP);
            }
        }
    }

    @Override
    public void newHeroList(OffsetList<Hero> heroList) {
        saveListPosition(heroList);
        view.listLoaded(heroList.getList());
        view.hideWaitingDialog();
    }

    @Override
    public void offsetUpdated(OffsetList<Hero> heroList) {
        saveListPosition(heroList);
        view.listUpdated(heroList.getList());
    }

    @Override
    public void noNetwork(String message) {
        super.noNetwork(message);
        if(view.isLoadingMoreItems())
            view.stopLoading();
    }

    @Override
    public void error(String message) {
        super.error(message);
        if(view.isLoadingMoreItems())
            view.stopLoading();
    }
}
