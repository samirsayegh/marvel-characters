package com.samirsayegh.marvelchars.view.heroDetails;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.samirsayegh.marvelchars.R;
import com.samirsayegh.marvelchars.domain.entities.Hero;
import com.samirsayegh.marvelchars.domain.entities.Thumbnail;
import com.samirsayegh.marvelchars.view.base.BaseActivity;
import com.samirsayegh.marvelchars.view.heroDetails.adapter.HeroPagerAdapter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by yormirsamir.sayegh on 28/04/2017.
 */

public class HeroDetailsActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

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
    }

    @Override
    protected void init() {
        initTabLayout();
        initHero();
        getLists();
    }

    private void getLists() {

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
}
