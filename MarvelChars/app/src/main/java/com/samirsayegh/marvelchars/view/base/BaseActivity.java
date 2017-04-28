package com.samirsayegh.marvelchars.view.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.samirsayegh.marvelchars.view.heroDetails.HeroDetailsActivity;

import java.io.Serializable;

import butterknife.ButterKnife;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected static final String EXTRA_HERO = "EXTRA_HERO";

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

    protected void navigateWithExtra(String extra, Serializable serializable) {
        Intent intent = new Intent(this, HeroDetailsActivity.class);
        intent.putExtra(extra, serializable);
        startActivity(intent);
    }

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

    @Override
    public boolean isWaiting() {
        return dialog != null && dialog.isShowing();
    }
}
