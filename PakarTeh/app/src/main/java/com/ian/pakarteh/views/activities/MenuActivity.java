package com.ian.pakarteh.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.ian.pakarteh.R;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout btnKonsultasi,btnHamaPenyakit,btnBudidaya,btnTentang,btnProfile,btnBantuan;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnKonsultasi = (LinearLayout) findViewById(R.id.btnKonsultasi);
        btnHamaPenyakit = (LinearLayout) findViewById(R.id.btnHamaPenyakit);
        btnBudidaya = (LinearLayout) findViewById(R.id.btnBudidaya);
        btnTentang = (LinearLayout) findViewById(R.id.btnTentang);
        btnProfile = (LinearLayout) findViewById(R.id.btnProfile);
        btnBantuan = (LinearLayout) findViewById(R.id.btnBantuan);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menu Utama");
        setupView();
    }

    private void setupView(){
        btnKonsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, BagianKonsultasiActivity.class);
                startActivity(i);
            }
        });
        btnHamaPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, HamaPenyakitActivity.class);
                startActivity(i);
            }
        });
        btnBudidaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, BudidayaActivity.class);
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
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });
        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, WebViewActivity.class);
                i.putExtra("tipe","tentang");
                startActivity(i);
            }
        });
    }
}
