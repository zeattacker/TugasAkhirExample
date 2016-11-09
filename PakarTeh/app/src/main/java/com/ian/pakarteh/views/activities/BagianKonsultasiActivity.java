package com.ian.pakarteh.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.ian.pakarteh.R;

public class BagianKonsultasiActivity extends AppCompatActivity {
    private Button btnAkar,btnBatang,btnDaun;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagian_konsultasi);
        btnAkar = (Button)findViewById(R.id.btnAkar);
        btnBatang = (Button)findViewById(R.id.btnBatang);
        btnDaun = (Button)findViewById(R.id.btnDaun);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pilih Bagian Gejala");
        setupView();
    }

    private void setupView(){
        btnAkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BagianKonsultasiActivity.this, FirstKonsultasiActivity.class);
                i.putExtra("bagian","akar");
                startActivity(i);
            }
        });

        btnBatang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BagianKonsultasiActivity.this, FirstKonsultasiActivity.class);
                i.putExtra("bagian","batang");
                startActivity(i);
            }
        });

        btnDaun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BagianKonsultasiActivity.this, FirstKonsultasiActivity.class);
                i.putExtra("bagian","daun");
                startActivity(i);
            }
        });
    }
}
