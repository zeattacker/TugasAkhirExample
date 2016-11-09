package com.ian.pakarteh.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ian.pakarteh.R;
import com.ian.pakarteh.views.adapters.BudidayaItemAdapter;

public class BudidayaActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private BudidayaItemAdapter bia;
    private String[] texts = {"Iklim","Tanah","Pembibitan","Penanaman","Pemeliharaan","Pemangkasan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budidaya);
        listView = (ListView)findViewById(R.id.listBudidaya);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cara Budidaya Teh");
        bia = new BudidayaItemAdapter(this, texts);
        listView.setAdapter(bia);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(BudidayaActivity.this, WebViewActivity.class);
                i.putExtra("pos",position);
                i.putExtra("tipe","budidaya");
                startActivity(i);
            }
        });
    }
}
