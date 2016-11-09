package com.dimas.gastrointenistal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.models.Gejala;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by rama on 11/5/16.
 */

public class GejalaItemAdapter extends BaseAdapter{
    private List<Gejala> gejalas;
    private ArrayList<Gejala> arraylist;
    private Context context;


    public GejalaItemAdapter(List<Gejala> gejalas, Context context) {
        this.gejalas = gejalas;
        this.context = context;
        this.arraylist = new ArrayList<Gejala>();
        this.arraylist.addAll(gejalas);
    }

    @Override
    public int getCount() {
        return gejalas.size();
    }

    @Override
    public Object getItem(int position) {
        return gejalas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.gejala_item_layout, parent, false);
        CheckedTextView textView = (CheckedTextView)rootView.findViewById(R.id.txtCheckGejala);
        textView.setText(gejalas.get(position).getNama());
        return rootView;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        gejalas.clear();
        if (charText.length() == 0) {
            gejalas.addAll(arraylist);
        }
        else
        {
            for (Gejala gj : arraylist)
            {
                if (gj.getNama().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    gejalas.add(gj);
                }
            }
        }
        notifyDataSetChanged();
    }
}
