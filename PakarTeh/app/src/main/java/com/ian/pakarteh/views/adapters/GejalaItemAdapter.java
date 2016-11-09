package com.ian.pakarteh.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ian.pakarteh.R;
import com.ian.pakarteh.models.Gejala;

import java.util.List;

/**
 * Created by rama on 11/8/16.
 */

public class GejalaItemAdapter extends BaseAdapter {
    private Context context;
    private List<Gejala> listGejala;

    public GejalaItemAdapter(Context context, List<Gejala> listGejala) {
        this.context = context;
        this.listGejala = listGejala;
    }

    @Override
    public int getCount() {
        return listGejala.size();
    }

    @Override
    public Object getItem(int position) {
        return listGejala.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.gejala_item_layout, parent, false);
        TextView txtNamaGejala = (TextView)view.findViewById(R.id.txtNamaGejala);
        txtNamaGejala.setText(listGejala.get(position).getNama());
        return view;
    }
}
