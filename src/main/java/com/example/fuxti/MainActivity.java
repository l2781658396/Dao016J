package com.example.fuxti;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTool;
    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> fragments;
    private FragmentManager manager;
    private FragmentAdapter adapter;
    private ShouFragment shouFragment;
    private WoFragment woFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.Tool);
        mTool.setTitle("");
        setSupportActionBar(mTool);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.Tab);
        shouFragment = new ShouFragment();
        woFragment = new WoFragment();
        fragments = new ArrayList<>();

        fragments.add(shouFragment);
        fragments.add(woFragment);
        manager = getSupportFragmentManager();
        adapter = new FragmentAdapter(manager, fragments);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("首页");
        mTab.getTabAt(1).setText("我的");

    }
}
