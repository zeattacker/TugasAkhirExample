package com.dimas.gastrointenistal.views.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.helpers.SQLiteHelper;
import com.dimas.gastrointenistal.models.Hospital;

public class DetailRSActivity extends AppCompatActivity {
    private TextView txtAlamat;
    private TextView txtKecamatan;
    private TextView txtTelp;
    private Button btnCall;
    private Button btnDirection;
    private ImageView imgRs;
    private Hospital hospital;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rs);

        txtAlamat = (TextView)findViewById(R.id.txtAlamat);
        txtKecamatan = (TextView)findViewById(R.id.txtKec);
        txtTelp = (TextView)findViewById(R.id.txtTelp);
        btnCall = (Button)findViewById(R.id.btnCall);
        btnDirection = (Button)findViewById(R.id.btnDirection);
        imgRs = (ImageView)findViewById(R.id.imgRsMap);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setupData();
        setupToolbar();
        setPlaceMap();
    }

    private void setupToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(hospital.getName());
    }

    private void setupData(){
        int id = getIntent().getIntExtra("id_rs", 0);
        id += 1;
        hospital = SQLiteHelper.getInstance(this).getHospital(id);
        txtAlamat.setText(hospital.getAlamat());
        txtKecamatan.setText(hospital.getKec());
        txtTelp.setText(hospital.getTelp());
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCallActivity(hospital.getTelp().replace("(","").replace(")","").replace(" ",""));
            }
        });
        btnDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNavigateActivity(Double.parseDouble(hospital.getLat()),Double.parseDouble(hospital.getLng()));
            }
        });
    }

    private void setPlaceMap(){
        String key = getString(R.string.g_api_key);
        String url = getStaticMapUrl(key, Double.parseDouble(hospital.getLat()), Double.parseDouble(hospital.getLng()), 14);
        Log.d("MAP URL", "Is : " + url);
        Glide.with(this).load(url).centerCrop().crossFade().into(imgRs);
    }

    private String getStaticMapUrl(String key, double lat, double lon, int zoom)
    {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        int markerColor = typedValue.data;
        String markerColorHex = String.format("0x%06x", (0xffffff & markerColor));

        StringBuilder builder = new StringBuilder();
        builder.append("https://maps.googleapis.com/maps/api/staticmap");
        builder.append("?key=");
        builder.append(key);
        builder.append("&size=320x320");
        builder.append("&scale=2");
        builder.append("&maptype=roadmap");
        builder.append("&zoom=");
        builder.append(zoom);
        builder.append("&center=");
        builder.append(lat);
        builder.append(",");
        builder.append(lon);
        builder.append("&markers=color:");
        builder.append(markerColorHex);
        builder.append("%7C");
        builder.append(lat);
        builder.append(",");
        builder.append(lon);
        return builder.toString();
    }

    private void startNavigateActivity(double lat, double lon)
    {
        try
        {
            String uri = String.format("http://maps.google.com/maps?daddr=%s,%s", Double.toString(lat), Double.toString(lon));
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        }
        catch(android.content.ActivityNotFoundException e)
        {
            // can't start activity
        }
    }

    private void startCallActivity(String phoneNumber)
    {
        try
        {
            StringBuilder builder = new StringBuilder();
            builder.append("tel:");
            builder.append(phoneNumber);

            Intent intent = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse(builder.toString()));
            startActivity(intent);
        }
        catch(android.content.ActivityNotFoundException e)
        {
            // can't start activity
        }
    }




}
