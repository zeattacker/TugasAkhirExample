package com.dimas.gastrointenistal.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dimas.gastrointenistal.R;

public class KategoriRumahSakit extends AppCompatActivity {
    private Button btnBlimbing,btnKlojen,btnLowokWaru,btnKedungKandang,btnSukun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_rumah_sakit);
        btnKlojen = (Button)findViewById(R.id.btnKlojen);
        btnBlimbing = (Button)findViewById(R.id.btnBlimbing);
        btnSukun = (Button)findViewById(R.id.btnSukun);
        btnKedungKandang = (Button)findViewById(R.id.btnKedungKandang);
        btnLowokWaru = (Button)findViewById(R.id.btnLowokWaru);

        btnKlojen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KategoriRumahSakit.this, MainDataActivity.class);
                i.putExtra("tipe","hospital");
                i.putExtra("kec","klojen");
                startActivity(i);
            }
        });

        btnBlimbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KategoriRumahSakit.this, MainDataActivity.class);
                i.putExtra("tipe","hospital");
                i.putExtra("kec","blimbing");
                startActivity(i);
            }
        });

        btnSukun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KategoriRumahSakit.this, MainDataActivity.class);
                i.putExtra("tipe","hospital");
                i.putExtra("kec","sukun");
                startActivity(i);
            }
        });

        btnKedungKandang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KategoriRumahSakit.this, MainDataActivity.class);
                i.putExtra("tipe","hospital");
                i.putExtra("kec","kedungkandang");
                startActivity(i);
            }
        });

        btnLowokWaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KategoriRumahSakit.this, MainDataActivity.class);
                i.putExtra("tipe","hospital");
                i.putExtra("kec","lowokwaru");
                startActivity(i);
            }
        });
    }
}
