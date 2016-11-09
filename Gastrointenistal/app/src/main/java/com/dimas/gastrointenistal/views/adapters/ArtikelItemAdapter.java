package com.dimas.gastrointenistal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dimas.gastrointenistal.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by rama on 11/9/16.
 */

public class ArtikelItemAdapter extends BaseAdapter {
    private Context context;
    private Set<String> keySet;
    private HashMap<String, ArrayList<String>> listArtikel;

    public ArtikelItemAdapter(Context context, Set<String> keySet, HashMap<String, ArrayList<String>> listArtikel) {
        this.context = context;
        this.keySet = keySet;
        this.listArtikel = listArtikel;
    }

    @Override
    public int getCount() {
        return keySet.size();
    }

    @Override
    public Object getItem(int position) {
        return listArtikel.get(keySet.toArray()[position]);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.artikel_item_layout, parent, false);
        TextView txtNama = (TextView)view.findViewById(R.id.txtTitle);
        TextView txtDesc = (TextView)view.findViewById(R.id.txtDesc);
        txtNama.setText(listArtikel.get(keySet.toArray()[position]).get(0));
        if(listArtikel.get(keySet.toArray()[position]).get(2).length() > 23) {
            txtDesc.setText(listArtikel.get(keySet.toArray()[position]).get(2).substring(24));
        }
        return view;
    }
}
