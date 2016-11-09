package com.dimas.gastrointenistal.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dimas.gastrointenistal.R;

public class FeedbackActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button btnKirim;
    private EditText txtNama,txtEmail,txtKomentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        btnKirim = (Button)findViewById(R.id.btnKirim);
        txtNama = (EditText)findViewById(R.id.txtNama);
        txtKomentar = (EditText)findViewById(R.id.txtKomentar);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kirim Feedback");
        setupView();
    }

    private void setupView(){
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNama.getText().toString().equals("") && txtEmail.getText().toString().equals("") && txtKomentar.getText().toString().equals("")){
                    Toast.makeText(FeedbackActivity.this, "Harap isi semua form", Toast.LENGTH_SHORT).show();
                } else {
                    txtNama.setText("");
                    txtEmail.setText("");
                    txtKomentar.setText("");
                    //Tambahkan proses disini untuk kirim email / savedb / berinteraksi dengan API
                    Toast.makeText(FeedbackActivity.this, "Pesan anda telah kami simpan, terimakasih atas partisipasinya", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
