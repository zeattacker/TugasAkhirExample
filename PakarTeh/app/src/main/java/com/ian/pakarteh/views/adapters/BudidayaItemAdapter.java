package com.ian.pakarteh.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ian.pakarteh.R;

/**
 * Created by rama on 11/9/16.
 */

public class BudidayaItemAdapter extends BaseAdapter {
    private Context context;
    private String[] texts;

    public BudidayaItemAdapter(Context context, String[] texts) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.budidaya_item_layout, parent, false);
        TextView txtNamaBudidaya = (TextView)view.findViewById(R.id.txtNamaBudidaya);
        txtNamaBudidaya.setText(texts[position]);
        return view;
    }
}
