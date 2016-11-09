package com.ian.pakarteh.views.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import com.ian.pakarteh.R;
import com.ian.pakarteh.models.Gejala;

import java.util.List;

/**
 * Created by rama on 11/8/16.
 */

public class CheckedItemAdapter extends BaseAdapter {
    private Context context;
    private List<Gejala> listGejala;
    private List<String> selectedGid;

    public CheckedItemAdapter(Context context, List<Gejala> listGejala) {
        this.context = context;
        this.listGejala = listGejala;
    }

    public CheckedItemAdapter(Context context, List<Gejala> listGejala, List<String> selectedGid) {
        this.context = context;
        this.listGejala = listGejala;
        this.selectedGid = selectedGid;
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
        View view = LayoutInflater.from(context).inflate(R.layout.checked_item_layout, parent, false);
        CheckedTextView textView = (CheckedTextView)view.findViewById(R.id.txtCheckGejala);
        textView.setText(listGejala.get(position).getNama());
        return view;
    }

    public void refresh(){
        notifyDataSetChanged();
    }
}
