package com.dimas.gastrointenistal.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.helpers.SQLiteHelper;
import com.dimas.gastrointenistal.models.Penyakit;

public class DetailDataActivity extends AppCompatActivity {
    private TextView txtPenanganan,txtDesc;
    private ImageView imgPenyakit;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        txtPenanganan = (TextView)findViewById(R.id.txtPenanganan);
        txtDesc = (TextView)findViewById(R.id.txtDesc);
        imgPenyakit = (ImageView)findViewById(R.id.imgPenyakit);
        setupData();
    }

    private void setupData(){
        Log.d("MainApp","Id : " + getIntent().getStringExtra("id"));
        Penyakit penyakit = SQLiteHelper.getInstance(this).getPenyakit(getIntent().getStringExtra("id"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(penyakit.getKode());
        txtPenanganan.setText(penyakit.getPenanganan());
        txtDesc.setText(penyakit.getDesc());
        imgPenyakit.setImageResource(getResources().getIdentifier(penyakit.getImg(),"drawable",getPackageName()));
    }
}
