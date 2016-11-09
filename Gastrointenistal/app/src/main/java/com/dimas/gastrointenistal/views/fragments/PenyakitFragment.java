package com.dimas.gastrointenistal.views.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.helpers.SQLiteHelper;
import com.dimas.gastrointenistal.models.Penyakit;
import com.dimas.gastrointenistal.views.activities.DetailDataActivity;
import com.dimas.gastrointenistal.views.adapters.PenyakitItemAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PenyakitFragment extends Fragment {
    private ListView listPenyakit;
    private PenyakitItemAdapter pia;

    public PenyakitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_penyakit, container, false);
        listPenyakit = (ListView)view.findViewById(R.id.listPenyakit);
        setupList();
        return view;
    }

    private void setupList(){
        final List<Penyakit> penyakits = SQLiteHelper.getInstance(getActivity()).getPenyakits();
        pia = new PenyakitItemAdapter(penyakits, getActivity());
        listPenyakit.setAdapter(pia);
        listPenyakit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), DetailDataActivity.class);
                i.putExtra("id",penyakits.get(position).getKode());
                startActivity(i);
            }
        });
    }

}
