package com.ian.pakarteh.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.ian.pakarteh.R;
import com.ian.pakarteh.helpers.SQLiteHelper;
import com.ian.pakarteh.models.Keputusan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HasilKonsultasiActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> results;
    private HashMap<String, ArrayList<String>> chains = new HashMap<>();
    private Toolbar toolbar;
    private Button btnBackMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_konsultasi);
        listView = (ListView)findViewById(R.id.listHasil);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        btnBackMenu = (Button)findViewById(R.id.btnBackMenu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hasil Konsultasi");
        btnBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HasilKonsultasiActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        });
        getBundle();
        chainProcess();
        setupData();
    }

    private void getBundle(){
        Bundle b = getIntent().getExtras();
        results = b.getStringArrayList("selectedItems");
    }

    private void chainProcess(){
        for(String code : results){
            Log.d("MainApp","Code gid : " + code);
            for(Keputusan keputusan : SQLiteHelper.getInstance(this).getAllKeputusan()){
                Log.d("MainApp","gid keputusan : " + keputusan.getGid());
                if(keputusan.getGid().equalsIgnoreCase(code)){
                    if(chains.containsKey(keputusan.getPid())){
                        chains.get(keputusan.getPid()).add(code + "," + keputusan.getBobot());
                    } else {
                        ArrayList<String> str = new ArrayList<>();
                        str.add(SQLiteHelper.getInstance(this).getKeputusanByPid(keputusan.getPid()).size() + "");
                        str.add(code + "," + keputusan.getBobot());
                        chains.put(keputusan.getPid(), str);
                    }
                }
            }
        }
    }

    private void setupData(){
        ArrayList<String> resultnya = new ArrayList<>();
        Set<String> keySet = chains.keySet();
        for(String key : keySet){
            float ms = Float.parseFloat(chains.get(key).get(0));
            float ma = 0;
            for(String str : chains.get(key)){
                if(str.contains(","))
                    ma += Float.parseFloat(str.split(",")[1]);
            }

            float pa = ma * 100;
            String namaPenyakit = SQLiteHelper.getInstance(this).getPenyakit(key).getNama();
            resultnya.add((int)pa + " % " + namaPenyakit);
        }

        ArrayAdapter<String> diagnoseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultnya);
        listView.setAdapter(diagnoseAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SQLiteHelper.getInstance(this).deleteTemp();
        results.clear();
        chains.clear();
    }
}
