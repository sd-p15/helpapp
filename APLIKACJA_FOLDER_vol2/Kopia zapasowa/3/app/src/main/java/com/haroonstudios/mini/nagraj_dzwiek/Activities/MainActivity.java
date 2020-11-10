package com.haroonstudios.mini.nagraj_dzwiek.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.haroonstudios.mini.nagraj_dzwiek.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
//przesuwany pasek zakładek
    @BindView(R.id.tabs) PagerSlidingTabStrip tabs;

    @BindView(R.id.pager) ViewPager viewPager;
//krpokowy pasek narzedzi
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //adapter
        viewPager.setAdapter(new MyTabAdapter(getSupportFragmentManager()));
        tabs.setViewPager(viewPager);

        setSupportActionBar(toolbar);

    }
}