package com.android.toolbar.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.android.toolbar.R;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GuideActivity extends BaseActivity {

    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.mGuide_viewPager)
    ViewPager mGuideViewPager;
    @Bind(R.id.mGuide_indicator)
    FixedIndicatorView mGuideIndicator;
    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        indicatorViewPager = new IndicatorViewPager(mGuideIndicator,mGuideViewPager);
        inflate =  LayoutInflater.from(getApplicationContext());
        indicatorViewPager.setAdapter(adapter);

    }
    private IndicatorViewPager.IndicatorViewPagerAdapter adapter = new IndicatorViewPager.IndicatorViewPagerAdapter() {

        private int[] imags = {R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3,R.mipmap.guide_4};
        private int[] imags2 = {R.mipmap.start1,R.mipmap.start2,R.mipmap.start3,R.mipmap.start4,R.mipmap.start5};
        @Override
        public int getCount() {
            return imags.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_guide,container,false);
            }

            return convertView;
        }

        @Override
        public View getViewForPage(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView  = new View(getApplicationContext());
                convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
            convertView.setBackgroundResource(imags2[position]);

            return convertView;
        }


    };

}
