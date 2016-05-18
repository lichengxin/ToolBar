package com.android.toolbar.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.android.toolbar.R;
import com.android.toolbar.contants.Urlcontants;
import com.android.toolbar.http.HttpUtil;
import com.android.toolbar.utils.LogUtils;
import com.android.volley.VolleyError;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SwipRefreshLayout extends BaseActivity {

    @Bind(R.id.toolBar)
    Toolbar toolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swip_refresh_layout);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("官方刷新");

        initData();

    }

    private void initData() {
        HttpUtil.getInstance(getApplicationContext()).sendGetRequest(Urlcontants.NEWS, new HttpUtil.HttpListener() {
            @Override
            public void onResponse(String response) {
                LogUtils.logE(SwipRefreshLayout.class,"=="+response);
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
