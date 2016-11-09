package com.dimas.gastrointenistal.views.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.models.Hospital;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rama on 11/4/16.
 */

public class HospitalItemAdapter extends BaseAdapter implements Filterable{
    private Context context;
    private List<Hospital> hospitals;
    private List<Hospital> tempHospital;

    public HospitalItemAdapter(Context context, List<Hospital> hospitals) {
        this.context = context;
        this.hospitals = hospitals;
        this.tempHospital = hospitals;
    }

    @Override
    public int getCount() {
        if(tempHospital.size() > 0)
            return tempHospital.size();
        else
            return hospitals.size();
    }

    @Override
    public Object getItem(int position) {
        if(tempHospital.size() > 0)
            return tempHospital.get(position);
        else
            return hospitals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.hospital_item_layout, parent, false);
        TextView txtNamaRs = (TextView)view.findViewById(R.id.txtNamaRs);
        TextView txtNoRs = (TextView)view.findViewById(R.id.txtNoRs);
        if(tempHospital.size() > 0) {
            txtNamaRs.setText(hospitals.get(position).getName());
            txtNoRs.setText(hospitals.get(position).getTelp());
        } else {
            txtNamaRs.setText(tempHospital.get(position).getName());
            txtNoRs.setText(tempHospital.get(position).getTelp());
        }
        return view;
    }

    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                tempHospital=(ArrayList<Hospital>)results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                Log.d("MainApp", "keyword : "+constraint);
                ArrayList<Hospital> FilteredList= new ArrayList<Hospital>();
                if (constraint == null || constraint.length() == 0) {
                    // No filter implemented we return all the list
                    results.values = hospitals;
                    results.count = hospitals.size();
                } else {
                    for (int i = 0; i < hospitals.size(); i++) {
                        String data = hospitals.get(i).getName();
                        if (data.toLowerCase().contains(constraint.toString()))  {
                            FilteredList.add(hospitals.get(i));
                        }
                    }
                    results.values = FilteredList;
                    results.count = FilteredList.size();
                }
                return results;
            }
        };
        return filter;
    }
}
