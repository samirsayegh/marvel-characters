package com.samirsayegh.marvelchars.presenter.mainPresenter;

import com.samirsayegh.marvelchars.domain.entities.Hero;
import com.samirsayegh.marvelchars.domain.entities.OffsetList;
import com.samirsayegh.marvelchars.model.services.characterService.CharacterService;
import com.samirsayegh.marvelchars.model.services.characterService.CharacterServiceResult;
import com.samirsayegh.marvelchars.presenter.base.BasePresenter;
import com.samirsayegh.marvelchars.view.main.MainView;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 * Samir Dev
 */

public class MainPresenter extends BasePresenter implements CharacterServiceResult {

    private final MainView view;
    private final CharacterService characterService;

    private int currentOffset;
    private int total;
    private String startingWith;

    public MainPresenter(MainView view) {
        super(view);
        this.view = view;
        characterService = new CharacterService(this);
        startingWith = "";
    }

    public void retrieveCharacters() {
        view.showWaitingDialog();
        characterService.getCharacters();
    }

    public void retrieveCharactersStartingWith(String startingWith) {
        this.startingWith = startingWith.trim();
        if (this.startingWith.isEmpty())
            characterService.getCharacters();
        else
            characterService.getCharactersStartingWith(startingWith);
    }

    private void saveListPosition(OffsetList<Hero> heroList) {
        currentOffset = heroList.getOffset();
        total = heroList.getTotal();
    }

    public void loadMoreElements() {
        if (!view.isWaiting()) {
            if (currentOffset + OFFSET_STEP < total) {
                if (startingWith.isEmpty())
                    characterService.getCharactersOffset(currentOffset + OFFSET_STEP);
                else
                    characterService.getCharactersStartingWith(startingWith, currentOffset + OFFSET_STEP);
            }
        }
    }

    @Override
    public void heroList(OffsetList<Hero> heroList, boolean isNew) {
        saveListPosition(heroList);
        if (isNew) {
            view.listLoaded(heroList.getList());
            view.hideWaitingDialog();
        } else {
            view.listUpdated(heroList.getList());
        }
    }

    @Override
    public void heroListStartingWith(OffsetList<Hero> heroList, boolean isNew) {
        saveListPosition(heroList);
        if (isNew) {
            view.listLoaded(heroList.getList());
            view.hideWaitingDialog();
        } else {
            view.listUpdated(heroList.getList());
        }
    }

    @Override
    public void noNetwork(String message) {
        super.noNetwork(message);
        if (view.isLoadingMoreItems())
            view.stopLoading();
    }

    @Override
    public void error(String message) {
        super.error(message);
        if (view.isLoadingMoreItems())
            view.stopLoading();
    }
}
