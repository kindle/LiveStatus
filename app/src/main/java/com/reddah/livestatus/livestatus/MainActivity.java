package com.reddah.livestatus.livestatus;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import layout.core_service;
import layout.overall_status;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager viewPager;
    private List<String> mTitle = new ArrayList<String>();
    private List<Fragment> mFragment = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), mTitle, mFragment);
        viewPager.setAdapter(adapter);
        //为TabLayout设置ViewPager
        tabs.setupWithViewPager(viewPager);
        //使用ViewPager的适配器
        tabs.setTabsFromPagerAdapter(adapter);


    }


    //初始化V
    private void initView() {

        tabs = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        mTitle.add("Status");
        mTitle.add("Services");
        mTitle.add("Xbox360");
        mTitle.add("XboxOne");

        mFragment.add(new overall_status());
        mFragment.add(new core_service());
        //mFragment.add(new overall_status());
        //mFragment.add(new overall_status());

    }
}
