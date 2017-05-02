package com.samirsayegh.marvelchars.view.heroDetails;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.samirsayegh.marvelchars.R;
import com.samirsayegh.marvelchars.domain.entities.BaseContent;
import com.samirsayegh.marvelchars.domain.entities.Hero;
import com.samirsayegh.marvelchars.domain.entities.Thumbnail;
import com.samirsayegh.marvelchars.presenter.heroDetailsPresenter.HeroDetailsPresenter;
import com.samirsayegh.marvelchars.view.base.BaseActivity;
import com.samirsayegh.marvelchars.view.heroDetails.adapter.HeroPagerAdapter;
import com.samirsayegh.marvelchars.view.heroDetails.fragments.ComicEventsListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;

import static com.samirsayegh.marvelchars.view.heroDetails.adapter.HeroPagerAdapter.COMICS;
import static com.samirsayegh.marvelchars.view.heroDetails.adapter.HeroPagerAdapter.EVENTS;

/**
 * Created by yormirsamir.sayegh on 28/04/2017.
 * Samir Dev
 */

public class HeroDetailsActivity extends BaseActivity implements TabLayout.OnTabSelectedListener, HeroDetailsView, ComicEventsListener {

    private final HeroDetailsPresenter presenter;

    private HeroPagerAdapter heroPagerAdapter;
    private Hero hero;

    @BindView(R.id.textViewDetailsName)
    TextView textViewName;
    @BindView(R.id.textViewDetailsDetail)
    TextView textViewDetails;
    @BindView(R.id.imageViewDetailsHero)
    ImageView imageView;
    @BindView(R.id.tabLayoutDetails)
    TabLayout tabLayout;
    @BindView(R.id.viewPagerDetails)
    ViewPager viewPager;

    public HeroDetailsActivity() {
        layoutId = R.layout.activity_details;
        presenter = new HeroDetailsPresenter(this);
    }

    @Override
    protected void init() {
        initTabLayout();
        initHero();
        getLists();
    }

    private void getLists() {
        presenter.getLists(hero.getId());
    }

    private void initHero() {
        if (getIntent().hasExtra(EXTRA_HERO)) {
            hero = (Hero) getIntent().getSerializableExtra(EXTRA_HERO);
            setTitle(hero.getName());
            textViewDetails.setText(hero.getDescription());
            textViewName.setText(hero.getName());
            Picasso.with(this)
                    .load(hero.getThumbnail(Thumbnail.PORTRAIT_LARGE))
                    .into(imageView);
        }
    }

    private void initTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.comics));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.events));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        heroPagerAdapter = new HeroPagerAdapter(getSupportFragmentManager());
        heroPagerAdapter.setListener(this);
        viewPager.setAdapter(heroPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void comicsLoaded(final List<BaseContent> list, final int totalComics) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tabLayout.getTabAt(COMICS).setText(getResources().getString(R.string.comics_number, totalComics));
                heroPagerAdapter.comicsLoaded(list);
            }
        });
    }

    @Override
    public void comicsUpdated(final List<BaseContent> list) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                heroPagerAdapter.comicsUpdated(list);
            }
        });
    }

    @Override
    public void eventsLoaded(final List<BaseContent> list, final int totalEvents) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                heroPagerAdapter.eventsLoaded(list);
                tabLayout.getTabAt(EVENTS).setText(getResources().getString(R.string.events_number, totalEvents));
            }
        });
    }

    @Override
    public void eventsUpdated(final List<BaseContent> list) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                heroPagerAdapter.eventsUpdated(list);
            }
        });
    }

    @Override
    public boolean isLoadingMoreComics() {
        return heroPagerAdapter.isLoadingMoreComics();
    }

    @Override
    public void stopLoadingComics() {
        heroPagerAdapter.stopLoadingComics();
    }

    @Override
    public boolean isLoadingMoreEvents() {
        return heroPagerAdapter.isLoadingMoreEvents();
    }

    @Override
    public void stopLoadingEvents() {
        heroPagerAdapter.stopLoadingEvents();
    }

    @Override
    public void loadMoreElements(int type) {
        if (type == COMICS)
            presenter.loadMoreComics();
        else
            presenter.loadMoreEvents();
    }
}
