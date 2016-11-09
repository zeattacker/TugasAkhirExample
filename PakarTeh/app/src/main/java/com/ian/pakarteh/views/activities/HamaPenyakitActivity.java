package com.ian.pakarteh.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.ian.pakarteh.R;
import com.ian.pakarteh.helpers.SQLiteHelper;
import com.ian.pakarteh.views.adapters.PenyakitItemAdapter;

public class HamaPenyakitActivity extends AppCompatActivity {
    private ListView listView;
    private PenyakitItemAdapter pia;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hama_penyakit);
        listView = (ListView)findViewById(R.id.listHamaPenyakit);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Daftar Hama dan Penyakit");
        pia = new PenyakitItemAdapter(this, SQLiteHelper.getInstance(this).getAllPenyakit());
        listView.setAdapter(pia);
    }
}
