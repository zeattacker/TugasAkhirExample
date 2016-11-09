package com.hardy.pakarapel.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hardy.pakarapel.R;

public class MenuActivity extends AppCompatActivity {
    private LinearLayout btnKonsultasi,btnHamaPenyakit,btnBerita,btnTentang,btnFeedback,btnBantuan;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnKonsultasi = (LinearLayout) findViewById(R.id.btnKonsultasi);
        btnHamaPenyakit = (LinearLayout) findViewById(R.id.btnHamaPenyakit);
        btnBerita = (LinearLayout) findViewById(R.id.btnBerita);
        btnTentang = (LinearLayout) findViewById(R.id.btnTentang);
        btnFeedback = (LinearLayout) findViewById(R.id.btnFeedback);
        btnBantuan = (LinearLayout) findViewById(R.id.btnBantuan);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setupView();
        setupToolbar();
    }

    private void setupToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sistem Pakar Apel");
    }

    private void setupView(){
        btnKonsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, KonsultasiActivity.class);
                startActivity(i);
            }
        });
        btnHamaPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ListHamaActivity.class);
                startActivity(i);
            }
        });
        btnBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, BudiDayaActivity.class);
                i.putExtra("tipe","budidaya");
                startActivity(i);
            }
        });
        btnBantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, BantuanActivity.class);
                startActivity(i);
            }
        });
        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, FeedbackActivity.class);
                startActivity(i);
            }
        });
        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, TentangActivity.class);
                startActivity(i);
            }
        });
    }
}
