package com.android.toolbar.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.toolbar.R;
import com.android.toolbar.fragment.TabFragment1;
import com.android.toolbar.fragment.TabFragment2;
import com.android.toolbar.fragment.TabFragment3;
import com.android.toolbar.fragment.TabFragment4;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.viewpager.SViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewPagerIndicatorActivity extends BaseActivity {


    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.mViewPager)
    SViewPager mViewPager;
    @Bind(R.id.mIndicator)
    FixedIndicatorView mIndicator;
    private IndicatorViewPager indicatorViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_indicator);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ViewPagerIndicator");

        indicatorViewPager = new IndicatorViewPager(mIndicator, mViewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mViewPager.setCanScroll(false);
        mViewPager.setOffscreenPageLimit(4);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

        private final LayoutInflater inflater;
        private String tabNames[] = new String[]{"精选", "理财", "借款", "我的"};
        private int[] tabIcons = {R.drawable.maintab_1_selector, R.drawable.maintab_2_selector, R.drawable.maintab_3_selector,
                R.drawable.maintab_4_selector};
        Fragment[] fragments = {new TabFragment1(), new TabFragment2(), new TabFragment3(), new TabFragment4()};

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            inflater = LayoutInflater.from(getApplicationContext());
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = (TextView) inflater.inflate(R.layout.tab_main, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(tabNames[position]);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
            return textView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            return fragments[position];
        }
    }

}
