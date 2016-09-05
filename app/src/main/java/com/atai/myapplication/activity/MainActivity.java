package com.atai.myapplication.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.atai.myapplication.R;
import com.atai.myapplication.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.rab_recommended)
    RadioButton rabRecommended;
    @BindView(R.id.rab_application)
    RadioButton rabApplication;
    @BindView(R.id.rab_game)
    RadioButton rabGame;
    @BindView(R.id.rab_search)
    RadioButton rabSearch;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.relative)
    RelativeLayout relative;
    @BindView(R.id.viewpager)
    ViewPager viewpager;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected String getTAG() {
        return "MainActivity";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }


    @Override
    protected void initResAndListener() {
        rabRecommended.setFocusable(true);

        viewpager.setOffscreenPageLimit(4);
        viewpager.setCurrentItem(1);



        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });
    }
}
