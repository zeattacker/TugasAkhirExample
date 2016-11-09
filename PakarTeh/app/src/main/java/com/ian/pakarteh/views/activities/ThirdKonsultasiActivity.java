package com.ian.pakarteh.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ian.pakarteh.R;
import com.ian.pakarteh.helpers.SQLiteHelper;
import com.ian.pakarteh.models.Gejala;
import com.ian.pakarteh.views.adapters.GejalaItemAdapter;

import java.util.List;

public class ThirdKonsultasiActivity extends AppCompatActivity {
    private ListView listView;
    private GejalaItemAdapter gia;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_konsultasi);
        listView = (ListView)findViewById(R.id.listGejala);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sub Menu Gejala");
        setupData();
    }

    private void setupData(){
        final List<Gejala> gejalas = SQLiteHelper.getInstance(this).getGejalaByLikeIndex("index3",getIntent().getStringExtra("gid"));
        gia = new GejalaItemAdapter(this, gejalas);
        listView.setAdapter(gia);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(SQLiteHelper.getInstance(ThirdKonsultasiActivity.this).getGejalaByLikeIndex("index4",gejalas.get(position).getGid()).size() > 0){
                    Intent i = new Intent(ThirdKonsultasiActivity.this, FourthKonsultasiActivity.class);
                    i.putExtra("gid", gejalas.get(position).getGid());
                    i.putExtra("bagian",getIntent().getStringExtra("bagian"));
                    startActivity(i);
                } else {
                    Intent i = new Intent(ThirdKonsultasiActivity.this, KonsultasiActivity.class);
                    i.putExtra("gid", gejalas.get(position).getGid());
                    i.putExtra("bagian",getIntent().getStringExtra("bagian"));
                    startActivity(i);
                }
            }
        });
    }
}
