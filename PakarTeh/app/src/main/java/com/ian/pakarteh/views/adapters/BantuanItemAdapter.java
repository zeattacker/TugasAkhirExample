package com.ian.pakarteh.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ian.pakarteh.R;

import java.util.List;

/**
 * Created by rama on 11/9/16.
 */

public class BantuanItemAdapter extends BaseAdapter {
    private Context context;
    private String[] texts;
    private String[] images = {"img_konsultasi","img_penyakit","img_budidaya","img_info","img_help","img_feedback"};
    private String[] titles = {"Konsultasi","Hama & Penyakit","Budidaya Teh","Tentang Teh","Bantuan","Profile"};

    public BantuanItemAdapter(Context context, String[] texts) {
        this.context = context;
        this.texts = texts;
    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public Object getItem(int position) {
        return texts[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.bantuan_item_layout, parent, false);
        ImageView imgBantuan = (ImageView)view.findViewById(R.id.imgBantuan);
        TextView txtBantuan = (TextView)view.findViewById(R.id.txtBantuan);
        TextView txtPenjelasan = (TextView)view.findViewById(R.id.txtPenjelasan);
        txtBantuan.setText(titles[position]);
        imgBantuan.setImageResource(context.getResources().getIdentifier(images[position],"drawable",context.getPackageName()));
        txtPenjelasan.setText(texts[position]);
        return view;
    }
}
