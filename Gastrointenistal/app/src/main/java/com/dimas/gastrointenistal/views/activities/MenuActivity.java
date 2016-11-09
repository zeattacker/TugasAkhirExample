package com.dimas.gastrointenistal.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.dimas.gastrointenistal.R;

public class MenuActivity extends AppCompatActivity {
    private LinearLayout btnDiagnosa,btnHospital,btnPenyakit,btnArtikel,btnBantuan,btnFeedback;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnDiagnosa = (LinearLayout)findViewById(R.id.btnDiagnose);
        btnHospital = (LinearLayout)findViewById(R.id.btnHospital);
        btnPenyakit = (LinearLayout)findViewById(R.id.btnPenyakit);
        btnArtikel = (LinearLayout)findViewById(R.id.btnArtikel);
        btnBantuan = (LinearLayout)findViewById(R.id.btnBantuan);
        btnFeedback = (LinearLayout)findViewById(R.id.btnFeedback);
        setupToolbar();
        setupView();
    }

    private void setupToolbar(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menu Utama");
    }

    private void setupView(){
        btnDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, DiagnoseActivity.class);
                startActivity(i);
            }
        });

        btnHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, KategoriRumahSakit.class);
                startActivity(i);
            }
        });

        btnPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, MainDataActivity.class);
                i.putExtra("tipe", "penyakit");
                startActivity(i);
            }
        });

        btnArtikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, MainDataActivity.class);
                i.putExtra("tipe", "artikel");
                startActivity(i);
            }
        });

        btnBantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, TentangActivity.class);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        toolbar.inflateMenu(R.menu.main);
        toolbar.getMenu().findItem(R.id.menu_bantuan).setIcon(R.drawable.ic_help_white);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_bantuan){
            Intent i = new Intent(this, BantuanActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
