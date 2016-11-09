package com.hardy.pakarapel.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.hardy.pakarapel.R;

public class BudiDayaActivity extends AppCompatActivity {
    private WebView webView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budi_daya);
        webView = (WebView)findViewById(R.id.webView);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String tipe = getIntent().getStringExtra("tipe");
        String url = "";

        if(tipe.equalsIgnoreCase("budidaya")){
            getSupportActionBar().setTitle("Sekilas Tentang Budidaya Apel");
            url = "file:///android_asset/budidaya.html";
        } else {
            getSupportActionBar().setTitle("Detail Penyakit");
            url = "file:///android_asset/" + tipe + ".html";
        }
        webView.loadUrl(url);
    }
}
