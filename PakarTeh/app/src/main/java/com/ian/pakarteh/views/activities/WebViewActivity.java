package com.ian.pakarteh.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.ian.pakarteh.R;

public class WebViewActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        webView = (WebView)findViewById(R.id.webView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Konten Budidaya");
        if(getIntent().getStringExtra("tipe").equalsIgnoreCase("budidaya")){
            webView.loadUrl("file:///android_asset/budidaya_" + getIntent().getIntExtra("pos",0) + ".html");
        } else if(getIntent().getStringExtra("tipe").equalsIgnoreCase("tentang")){
            webView.loadUrl("file:///android_asset/tentang.html");
        }
    }
}
