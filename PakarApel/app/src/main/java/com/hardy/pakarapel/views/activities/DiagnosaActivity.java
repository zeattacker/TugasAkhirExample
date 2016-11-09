package com.hardy.pakarapel.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hardy.pakarapel.R;
import com.hardy.pakarapel.helpers.SQLiteHelper;
import com.hardy.pakarapel.models.Hama;
import com.hardy.pakarapel.models.Keputusan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DiagnosaActivity extends AppCompatActivity {
    private String[] results;
    private HashMap<String, ArrayList<String>> chains = new HashMap<>();
    private TextView txtNamaHama,txtDescHama;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa);
        getBundle();
        setupView();
        chainProcess();
        setupData();
    }

    private void setupView(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        txtNamaHama = (TextView)findViewById(R.id.txtNamaHama);
        txtDescHama = (TextView) findViewById(R.id.txtDescHama);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hasil Diagnosa Gejala");
    }

    private void getBundle(){
        Bundle b = getIntent().getExtras();
        results = b.getStringArray("selectedItems");
    }

    private void chainProcess(){
        for(String code : results){
            for(Keputusan keputusan : SQLiteHelper.getInstance(this).getAllKeputusan()){
                if(keputusan.getGid().contains(code + ",")){
                    if(chains.containsKey(keputusan.getPid())){
                        chains.get(keputusan.getPid()).add(code);
                    } else {
                        ArrayList<String> str = new ArrayList<>();
                        str.add(keputusan.getGid().split(",").length + "");
                        str.add(code);
                        chains.put(keputusan.getPid(), str);
                    }
                }
            }
        }
    }

    private void setupData(){
        Set<String> keySet = chains.keySet();
        float top = -1;
        String keyset = "";
        for(String key : keySet){
            float ms = Float.parseFloat(chains.get(key).get(0));
            float ma = chains.get(key).size() - 1;
            float current = ma / ms * 100;
            if(current >= top){
                top = current;
                keyset = key;
            }
        }

        Hama hama = SQLiteHelper.getInstance(this).getHama(keyset);
        txtNamaHama.setText(hama.getNama());
        txtDescHama.setText(hama.getCara());
    }
}
