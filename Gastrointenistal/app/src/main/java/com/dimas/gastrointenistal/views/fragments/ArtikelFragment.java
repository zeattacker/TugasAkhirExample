package com.dimas.gastrointenistal.views.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.helpers.SQLiteHelper;
import com.dimas.gastrointenistal.helpers.XMLParser;
import com.dimas.gastrointenistal.views.adapters.ArtikelItemAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtikelFragment extends Fragment {
    private ArtikelItemAdapter aia;
    private ListView listView;


    public ArtikelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artikel, container, false);
        listView = (ListView)view.findViewById(R.id.listArtikel);
        new loadArtikel().execute();
        return view;
    }

    private void startWebActivity(String url)
    {
        try
        {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }
        catch(android.content.ActivityNotFoundException e)
        {
            // can't start activity
        }
    }

    class loadArtikel extends AsyncTask<String, String, HashMap<String, ArrayList<String>>>{
        @Override
        protected HashMap<String, ArrayList<String>> doInBackground(String... params) {
            return XMLParser.getInstance().getData();
        }

        @Override
        protected void onPostExecute(final HashMap<String, ArrayList<String>> datas) {
            super.onPostExecute(datas);

            Log.d("MainApp","Size : " + datas.size());
            aia = new ArtikelItemAdapter(getActivity(), datas.keySet(), datas);
            listView.setAdapter(aia);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    startWebActivity(datas.get(datas.keySet().toArray()[position]).get(1));
                }
            });
        }
    }

}
