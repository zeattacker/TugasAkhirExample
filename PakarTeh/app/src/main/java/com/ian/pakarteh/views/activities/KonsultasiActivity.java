package com.ian.pakarteh.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.ian.pakarteh.R;
import com.ian.pakarteh.helpers.SQLiteHelper;
import com.ian.pakarteh.models.Gejala;
import com.ian.pakarteh.views.adapters.CheckedItemAdapter;
import com.ian.pakarteh.views.adapters.GejalaItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class KonsultasiActivity extends AppCompatActivity {
    private ListView listGejala;
    private CheckedItemAdapter cia;
    private Button btnDiagnosa;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi);
        listGejala = (ListView) findViewById(R.id.listGejala);
        btnDiagnosa = (Button)findViewById(R.id.btnDiagnose);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pilih Gejala");
        setupView();
    }

    private void setupView(){
        if(getIntent().getStringExtra("bagian").equalsIgnoreCase("daun")){
            btnDiagnosa.setVisibility(View.VISIBLE);
            btnDiagnosa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(SQLiteHelper.getInstance(KonsultasiActivity.this).getAllTemp().size() == 0){
                        SparseBooleanArray checked = listGejala.getCheckedItemPositions();

                        for(int i = 0;i < checked.size();i++){
                            int pos = checked.keyAt(i);
                            if(checked.valueAt(i)) {
                                SQLiteHelper.getInstance(KonsultasiActivity.this).addTemp(getIntent().getStringExtra("gid"), ((Gejala)cia.getItem(pos)).getGid());
                            } else
                                SQLiteHelper.getInstance(KonsultasiActivity.this).addTemp(getIntent().getStringExtra("gid"),"b");
                        }
                    }
                    Intent i = new Intent(KonsultasiActivity.this, HasilKonsultasiActivity.class);
                    Bundle b = new Bundle();
                    b.putStringArrayList("selectedItems", SQLiteHelper.getInstance(KonsultasiActivity.this).getAllTemp());
                    i.putExtras(b);
                    SQLiteHelper.getInstance(KonsultasiActivity.this).deleteTemp();
                    startActivity(i);
                }
            });
        } else {
            btnDiagnosa.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupData();
    }

    private void setupData(){
        List<Gejala> gejalas = SQLiteHelper.getInstance(this).getGejalaByLikeIndex("index5","index6",getIntent().getStringExtra("gid"),getIntent().getStringExtra("gid"));
        List<String> checkedS = SQLiteHelper.getInstance(this).getTempByGid(getIntent().getStringExtra("gid"));
        cia = new CheckedItemAdapter(this, gejalas);
        listGejala.setAdapter(cia);
        listGejala.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        for (int i = 0; i < gejalas.size(); i++) {
            if(checkedS.size() > 0) {
                for (int j = 0; j < checkedS.size(); j++) {
                    if (gejalas.get(i).getGid().equalsIgnoreCase(checkedS.get(j)))
                        listGejala.setItemChecked(i, true);
                }
            } else {
                listGejala.setItemChecked(i, false);
            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(SQLiteHelper.getInstance(this).getTempByGid(getIntent().getStringExtra("gid")).size() > 0){
            SQLiteHelper.getInstance(this).deleteTemp(getIntent().getStringExtra("gid"));
        }

        SparseBooleanArray checked = listGejala.getCheckedItemPositions();

        for(int i = 0;i < checked.size();i++){
            int pos = checked.keyAt(i);
            if(checked.valueAt(i)) {
                SQLiteHelper.getInstance(KonsultasiActivity.this).addTemp(getIntent().getStringExtra("gid"), ((Gejala)cia.getItem(pos)).getGid());
            }
        }
    }
}
