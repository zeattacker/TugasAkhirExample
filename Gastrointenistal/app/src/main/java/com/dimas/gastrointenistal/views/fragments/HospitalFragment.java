package com.dimas.gastrointenistal.views.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.helpers.SQLiteHelper;
import com.dimas.gastrointenistal.views.activities.DetailRSActivity;
import com.dimas.gastrointenistal.views.adapters.HospitalItemAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalFragment extends Fragment {
    private ListView listHospital;
    private HospitalItemAdapter hia;
    private EditText txtSearch;

    public static HospitalFragment newInstance(String kec){
        HospitalFragment fragment = new HospitalFragment();
        Bundle bundle = new Bundle();
        bundle.putString("kec", kec);
        fragment.setArguments(bundle);

        return fragment;
    }

    public HospitalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hospital, container, false);
        listHospital = (ListView)view.findViewById(R.id.listHospital);
        txtSearch = (EditText)view.findViewById(R.id.txtCariRs);
        setupData();
        return view;
    }
    
    private void setupData(){
        hia = new HospitalItemAdapter(getActivity(), SQLiteHelper.getInstance(getActivity()).getHospitals(getArguments().getString("kec")));
        listHospital.setAdapter(hia);
        listHospital.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainApp","Pos : " + position + " id : " + id);
                Intent i = new Intent(getActivity(), DetailRSActivity.class);
                i.putExtra("id_rs", ++position);
                startActivity(i);
            }
        });
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hia.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
