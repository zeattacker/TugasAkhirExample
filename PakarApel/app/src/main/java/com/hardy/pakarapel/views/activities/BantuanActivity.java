package com.hardy.pakarapel.views.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hardy.pakarapel.R;
import com.hardy.pakarapel.views.adapters.BantuanItemAdapter;

import me.relex.circleindicator.CircleIndicator;

public class BantuanActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator indicator;
    private BantuanItemAdapter bia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        indicator = (CircleIndicator)findViewById(R.id.indicator);
        bia = new BantuanItemAdapter(getSupportFragmentManager());
        viewPager.setAdapter(bia);
        indicator.setViewPager(viewPager);
    }
}
