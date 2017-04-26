package com.samirsayegh.marvelchars.view.base;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init();
    }
}
