package com.android.toolbar.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.toolbar.R;
import com.android.toolbar.fragment.TabFragment1;
import com.android.toolbar.fragment.TabFragment2;
import com.android.toolbar.fragment.TabFragment3;
import com.android.toolbar.fragment.TabFragment4;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TabActivity extends BaseActivity {

    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.mVpager)
    ViewPager mVpager;
    @Bind(R.id.mTabLayout)
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        SampleFragmentPagerAdapter pagerAdapter =
                new SampleFragmentPagerAdapter(getSupportFragmentManager(), this);

        mVpager.setAdapter(pagerAdapter);

        mTabLayout.setupWithViewPager(mVpager);

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(pagerAdapter.getTabView(i));
            }
        }

        mVpager.setCurrentItem(1);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

        final int PAGE_COUNT = 4;
        private String tabTitles[] = new String[]{"精选", "理财", "借款", "我的"};
        private int imageResId[] = {R.mipmap.chosen_normal, R.mipmap.borrow_normal, R.mipmap.financial_normal, R.mipmap.my_normal};
        Fragment[] fragments = {new TabFragment1(), new TabFragment2(), new TabFragment3(), new TabFragment4()};
        private Context context;

        public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        public View getTabView(int position) {
            View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView) v.findViewById(R.id.mTitle);
            tv.setText(tabTitles[position]);
            ImageView img = (ImageView) v.findViewById(R.id.mIcon);
            img.setImageResource(imageResId[position]);
            return v;
        }

    }


}
