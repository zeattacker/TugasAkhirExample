package com.hardy.pakarapel.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hardy.pakarapel.R;
import com.hardy.pakarapel.helpers.SQLiteHelper;
import com.hardy.pakarapel.models.Gejala;
import com.hardy.pakarapel.views.adapters.GejalaItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class KonsultasiActivity extends AppCompatActivity {
    private ListView listGejala;
    private GejalaItemAdapter gia;
    private Button btnDiagnosa;
    private Toolbar toolbar;
    private List<Gejala> listgejalas;
    private EditText txtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi);
        listGejala = (ListView)findViewById(R.id.listGejala);
        btnDiagnosa = (Button)findViewById(R.id.btnDiagnosa);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        txtSearch = (EditText)findViewById(R.id.txtSearch);
        setupView();
        setupData();
    }

    private void setupView(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pilih Gejala yang sesuai");
    }

    private void setupData(){
        listgejalas = SQLiteHelper.getInstance(this).getAllGejala();
        gia = new GejalaItemAdapter(listgejalas, this);
        listGejala.setAdapter(gia);
        listGejala.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listGejala.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        btnDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checked = listGejala.getCheckedItemPositions();
                if(checked.size() <= listgejalas.size()) {
                    ArrayList<Gejala> selectedItems = new ArrayList<Gejala>();
                    for (int i = 0; i < checked.size(); i++) {
                        int pos = checked.keyAt(i);
                        if (checked.valueAt(i))
                            selectedItems.add((Gejala) gia.getItem(pos));
                    }

                    String[] outArr = new String[selectedItems.size()];
                    for (int j = 0; j < selectedItems.size(); j++) {
                        outArr[j] = selectedItems.get(j).getGid();
                    }

                    Intent i = new Intent(KonsultasiActivity.this, DiagnosaActivity.class);
                    Bundle b = new Bundle();
                    b.putStringArray("selectedItems", outArr);
                    i.putExtras(b);
                    startActivity(i);
                } else {
                    Toast.makeText(KonsultasiActivity.this, "Gejala tidak boleh dipilih semua", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gia.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
