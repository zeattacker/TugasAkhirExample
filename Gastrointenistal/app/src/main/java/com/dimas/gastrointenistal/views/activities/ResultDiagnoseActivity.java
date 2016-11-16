package com.dimas.gastrointenistal.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.helpers.SQLiteHelper;
import com.dimas.gastrointenistal.models.Keputusan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ResultDiagnoseActivity extends AppCompatActivity {
    private String[] results;
    private ListView listView;
    private HashMap<String, ArrayList<String>> chains = new HashMap<>();
    private Toolbar toolbar;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_diagnose);
        setupToolbar();
        getBundle();
        setupView();
        chainProcess();
        setupList();
    }

    private void setupToolbar(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hasil diagnosa");
    }

    private void setupView(){
        listView = (ListView)findViewById(R.id.listPenyakit);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void getBundle(){
        Bundle b = getIntent().getExtras();
        results = b.getStringArray("selectedItems");
    }

    private void chainProcess(){
        for(String code : results){
            for(Keputusan keputusan : SQLiteHelper.getInstance(this).getKeputusans()){
                if(keputusan.getGejala().contains(code + ",")){
                    if(chains.containsKey(keputusan.getPenyakit())){
                        chains.get(keputusan.getPenyakit()).add(code);
                    } else {
                        ArrayList<String> str = new ArrayList<>();
                        str.add(keputusan.getGejala().split(",").length + "");
                        str.add(code);
                        chains.put(keputusan.getPenyakit(), str);
                    }
                }
            }
        }
    }

    private void setupList(){
        ArrayList<String> resultnya = new ArrayList<>();
        final Set<String> keySet = chains.keySet();
        for(String key : keySet){
            float ms = Float.parseFloat(chains.get(key).get(0));
            Log.d("MainApp","ms : " + ms);
            float ma = chains.get(key).size() - 1;
            Log.d("MainApp","ma : " + ma);
//            int pa = (int) Math.ceil((1 - (ma/ms)) * 100);
            float pa = ma / ms * 100;
            Log.d("MainApp","Pa : " + pa);
            String namaPenyakit = SQLiteHelper.getInstance(this).getPenyakit(key).getKode();
            Log.d("MainApp","Penyakit : " + namaPenyakit + " Code : " + key);
            Log.d("MainApp","=======================");
            resultnya.add((int)pa + " % " + namaPenyakit);
        }

        ArrayAdapter<String> diagnoseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultnya);
        listView.setAdapter(diagnoseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ResultDiagnoseActivity.this, DetailDataActivity.class);
                i.putExtra("id",(String)keySet.toArray()[position]);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
