package com.samirsayegh.marvelchars.view.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.samirsayegh.marvelchars.R;
import com.samirsayegh.marvelchars.model.entities.Hero;
import com.samirsayegh.marvelchars.presenter.mainPresenter.MainPresenter;
import com.samirsayegh.marvelchars.view.base.BaseActivity;
import com.samirsayegh.marvelchars.view.main.adapter.MainAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */
public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;

    @BindView(R.id.editTextMainFind)
    EditText editText;
    @BindView(R.id.recyclerViewMain)
    RecyclerView recyclerView;

    public MainActivity() {
        layoutId = R.layout.activity_main;
        mainPresenter = new MainPresenter(this);
        mainAdapter = new MainAdapter();
    }

    @Override
    protected void init() {
        mainPresenter.updateCharacters();
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void listLoaded(final List<Hero> heroList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainAdapter.setNewList(heroList);
                mainAdapter.notifyDataSetChanged();
            }
        });
    }
}
