package com.android.toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.toolbar.activity.BaseActivity;
import com.android.toolbar.activity.PullRefreshActivity;
import com.android.toolbar.activity.SwipRefreshLayout;
import com.android.toolbar.activity.TabActivity;
import com.android.toolbar.activity.ViewPagerActivity;
import com.android.toolbar.activity.ViewPagerIndicatorActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.drawer)
    DrawerLayout drawer;
    @Bind(R.id.btn1)
    Button btn1;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolBar();
        initListener();


    }

    private void initListener() {

    }


    @OnClick({R.id.btn1, R.id.swipRefresh, R.id.tab, R.id.viewPagerIndicator})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(getApplicationContext(), PullRefreshActivity.class));
                break;
            case R.id.swipRefresh:
                startActivity(new Intent(getApplicationContext(), SwipRefreshLayout.class));
                break;
            case R.id.tab:
                startActivity(new Intent(getApplicationContext(), TabActivity.class));
                break;
            case R.id.viewPagerIndicator:
                startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
                break;
        }
    }

    private void initToolBar() {
        setSupportActionBar(toolBar);
//        toolBar.setTitleTextColor(getResources().getColor(R.color.white));//设置title颜色
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);//返回键可用
//        getSupportActionBar().setDisplayShowTitleEnabled(false); //清空默认title
        getSupportActionBar().setTitle("知乎");//添加标题

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolBar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        actionBarDrawerToggle.syncState();
        drawer.setDrawerListener(actionBarDrawerToggle);
    }
}
