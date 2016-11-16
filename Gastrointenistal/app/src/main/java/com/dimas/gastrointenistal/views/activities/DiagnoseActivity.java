package com.dimas.gastrointenistal.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.helpers.SQLiteHelper;
import com.dimas.gastrointenistal.models.Gejala;
import com.dimas.gastrointenistal.views.adapters.GejalaItemAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DiagnoseActivity extends AppCompatActivity {
    private ListView listGejala;
    private Button btnDiagnose;
    private EditText txtSearch;
    private GejalaItemAdapter gia;
    private Toolbar toolbar;
    private List<Gejala> listGejalas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);
        setupToolbar();
        setupView();
        setupList();
        setupBtn();
    }

    private void setupToolbar(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pilih Gejala");
    }

    private void setupView(){
        listGejala = (ListView)findViewById(R.id.listGejala);
        btnDiagnose = (Button)findViewById(R.id.btnDiagnose);
        txtSearch = (EditText)findViewById(R.id.txtSearch);
    }

    private void setupList(){
        listGejalas = SQLiteHelper.getInstance(this).getGejalas();
        gia = new GejalaItemAdapter(listGejalas, this);
        listGejala.setAdapter(gia);
        listGejala.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void setupBtn(){
        btnDiagnose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checked = listGejala.getCheckedItemPositions();
                Log.d("MainApp","Checked size : " + checked.size());
                Log.d("MainApp","List Gejala size : " + listGejalas.size());
                if(checked.size() < listGejalas.size()) {
                    ArrayList<Gejala> selectedItems = new ArrayList<Gejala>();
                    for (int i = 0; i < checked.size(); i++) {
                        int pos = checked.keyAt(i);
                        if (checked.valueAt(i))
                            selectedItems.add((Gejala) gia.getItem(pos));
                    }

                    String[] outArr = new String[selectedItems.size()];
                    for (int j = 0; j < selectedItems.size(); j++) {
                        outArr[j] = selectedItems.get(j).getParameter();
                    }

                    Intent i = new Intent(DiagnoseActivity.this, ResultDiagnoseActivity.class);
                    Bundle b = new Bundle();
                    b.putStringArray("selectedItems", outArr);
                    i.putExtras(b);
                    startActivity(i);
                } else {
                    Toast.makeText(DiagnoseActivity.this, "Gejala tidak boleh dipilih semua", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String text = txtSearch.getText().toString().toLowerCase(Locale.getDefault());
                gia.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
