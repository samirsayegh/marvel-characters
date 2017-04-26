package com.samirsayegh.marvelchars.view.main;

import com.orhanobut.logger.Logger;
import com.samirsayegh.marvelchars.R;
import com.samirsayegh.marvelchars.model.entities.Hero;
import com.samirsayegh.marvelchars.presenter.mainPresenter.MainPresenter;
import com.samirsayegh.marvelchars.view.base.BaseActivity;

import java.util.List;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */
public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter mainPresenter;

    public MainActivity() {
        layoutId = R.layout.activity_main;
        mainPresenter = new MainPresenter(this);
    }

    @Override
    protected void init() {
        mainPresenter.updateCharacters();
    }

    @Override
    public void listLoaded(List<Hero> heroList) {
        for (Hero hero : heroList) {
            Logger.d(hero.toString());
        }
    }
}
