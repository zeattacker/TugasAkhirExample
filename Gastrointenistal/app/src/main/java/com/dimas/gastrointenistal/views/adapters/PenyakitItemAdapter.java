package com.dimas.gastrointenistal.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.models.Penyakit;

import java.util.List;

/**
 * Created by rama on 11/5/16.
 */

public class PenyakitItemAdapter extends BaseAdapter {
    private List<Penyakit> listPenyakits;
    private Context context;

    public PenyakitItemAdapter(List<Penyakit> listPenyakits, Context context) {
        this.listPenyakits = listPenyakits;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listPenyakits.size();
    }

    @Override
    public Object getItem(int position) {
        return listPenyakits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.penyakit_item_layout, parent, false);
        TextView txtPenyakit = (TextView)view.findViewById(R.id.txtPenyakit);
        ImageView imgPenyakit = (ImageView)view.findViewById(R.id.imgPenyakit);
        txtPenyakit.setText(listPenyakits.get(position).getName());
        imgPenyakit.setImageResource(context.getResources().getIdentifier(listPenyakits.get(position).getImg(), "drawable", context.getPackageName()));
        return view;
    }
}
