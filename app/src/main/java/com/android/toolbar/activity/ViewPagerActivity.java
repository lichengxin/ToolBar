package com.android.toolbar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.toolbar.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewPagerActivity extends BaseActivity {

    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.tv2)
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ViewPager");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick({R.id.tv1, R.id.tv2})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                startActivity(new Intent(getApplicationContext(), ViewPagerIndicatorActivity.class));
                break;
            case R.id.tv2:
                startActivity(new Intent(getApplicationContext(), GuideActivity.class));
                break;
        }
    }

}
