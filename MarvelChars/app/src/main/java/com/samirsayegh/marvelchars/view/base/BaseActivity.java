package com.samirsayegh.marvelchars.view.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 *
 */

public abstract class BaseActivity extends Activity {

    protected int layoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
    }


}
