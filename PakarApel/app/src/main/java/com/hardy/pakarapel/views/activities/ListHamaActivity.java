package com.hardy.pakarapel.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hardy.pakarapel.R;
import com.hardy.pakarapel.helpers.SQLiteHelper;
import com.hardy.pakarapel.views.adapters.HamaItemAdapter;

public class ListHamaActivity extends AppCompatActivity {
    private ListView listHama;
    private HamaItemAdapter hia;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hama);

        listHama = (ListView)findViewById(R.id.listHama);
        setupToolbar();
        setupData();
    }

    private void setupToolbar(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Daftar Hama dan Penyakit");
    }

    private void setupData(){
        hia = new HamaItemAdapter(SQLiteHelper.getInstance(this).getAllHama(), this);
        listHama.setAdapter(hia);
        listHama.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ListHamaActivity.this, BudiDayaActivity.class);
                i.putExtra("tipe","penyakit_"+(position+1));
                startActivity(i);
            }
        });
    }
}
