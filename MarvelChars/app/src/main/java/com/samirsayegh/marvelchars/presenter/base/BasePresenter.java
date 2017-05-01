package com.samirsayegh.marvelchars.presenter.base;

import com.samirsayegh.marvelchars.model.services.base.BaseServiceResult;
import com.samirsayegh.marvelchars.view.base.BaseView;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class BasePresenter implements BaseServiceResult {

    private BaseView baseView;

    public BasePresenter(BaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    public void noNetwork(String message) {
        baseView.hideWaitingDialog();
        baseView.showMessage(message);
    }

    @Override
    public void error(String message) {
        baseView.hideWaitingDialog();
        baseView.showMessage(message);
    }
}
