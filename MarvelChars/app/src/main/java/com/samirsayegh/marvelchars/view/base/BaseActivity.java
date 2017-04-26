package com.samirsayegh.marvelchars.view.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public abstract class BaseActivity extends Activity implements BaseView {

    protected int layoutId;
    protected ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        ButterKnife.bind(this);
        init();
    }

    protected abstract void init();

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog = ProgressDialog.show(BaseActivity.this, "", "Loading. Please wait...", true);
            }
        });
    }

    @Override
    public void hideWaitingDialog() {
        if (dialog != null && dialog.isShowing())
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialog.cancel();
                    dialog.dismiss();
                }
            });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
