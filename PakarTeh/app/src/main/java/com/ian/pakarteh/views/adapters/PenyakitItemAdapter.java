package com.ian.pakarteh.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ian.pakarteh.R;
import com.ian.pakarteh.models.Penyakit;

import java.util.List;

/**
 * Created by rama on 11/9/16.
 */

public class PenyakitItemAdapter extends BaseAdapter {
    private Context context;
    private List<Penyakit> penyakitList;

    public PenyakitItemAdapter(Context context, List<Penyakit> penyakitList) {
        this.context = context;
        this.penyakitList = penyakitList;
    }

    @Override
    public int getCount() {
        return penyakitList.size();
    }

    @Override
    public Object getItem(int position) {
        return penyakitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.penyakit_item_layout, parent, false);
        TextView txtNamaPenyakit = (TextView)view.findViewById(R.id.txtNamaPenyakit);
        TextView txtSolusiPenyakit = (TextView)view.findViewById(R.id.txtSolusiPenyakit);
        txtNamaPenyakit.setText(penyakitList.get(position).getNama());
        txtSolusiPenyakit.setText(penyakitList.get(position).getSolusi());
        return view;
    }
}
