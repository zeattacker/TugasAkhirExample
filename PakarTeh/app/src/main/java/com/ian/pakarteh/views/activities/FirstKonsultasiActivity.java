package com.ian.pakarteh.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ian.pakarteh.R;
import com.ian.pakarteh.helpers.SQLiteHelper;
import com.ian.pakarteh.models.Gejala;
import com.ian.pakarteh.views.adapters.GejalaItemAdapter;

import java.util.List;

public class FirstKonsultasiActivity extends AppCompatActivity {
    private GejalaItemAdapter gia;
    private ListView listKonsultasi;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_konsultasi);
        listKonsultasi = (ListView)findViewById(R.id.listKonsultasi);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sub Menu Gejala");
        setupData();
    }

    private void setupData(){
        final List<Gejala> gejalaSatu = SQLiteHelper.getInstance(this).getGejalaByIndex("index1",getIntent().getStringExtra("bagian"));
        gia = new GejalaItemAdapter(this, gejalaSatu);
        listKonsultasi.setAdapter(gia);
        listKonsultasi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(SQLiteHelper.getInstance(FirstKonsultasiActivity.this).getGejalaByLikeIndex("index2",gejalaSatu.get(position).getGid()).size() > 0){
                    Intent i = new Intent(FirstKonsultasiActivity.this, SecondKonsultasiActivity.class);
                    i.putExtra("gid", gejalaSatu.get(position).getGid());
                    i.putExtra("bagian",getIntent().getStringExtra("bagian"));
                    startActivity(i);
                } else {
                    Intent i = new Intent(FirstKonsultasiActivity.this, KonsultasiActivity.class);
                    i.putExtra("gid", gejalaSatu.get(position).getGid());
                    i.putExtra("bagian",getIntent().getStringExtra("bagian"));
                    startActivity(i);
                }
            }
        });
    }
}
