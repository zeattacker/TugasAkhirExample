package com.ian.pakarteh.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.ian.pakarteh.R;
import com.ian.pakarteh.views.adapters.BantuanItemAdapter;

public class BantuanActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private BantuanItemAdapter bia;
    private String[] texts = {"Ini content konsultasi","Ini content hama dan penyakit","Ini budidaya teh","Ini tentang teh","Ini bantuan","Ini Profile"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        listView = (ListView)findViewById(R.id.listBantuan);
        bia = new BantuanItemAdapter(this, texts);
        listView.setAdapter(bia);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Daftar Bantuan");
    }
}
