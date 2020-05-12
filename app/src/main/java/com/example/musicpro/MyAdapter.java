package com.example.musicpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.musicpro.Model.Venue;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Venue> arrayList;

    public MyAdapter(Context context,ArrayList<Venue> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.mycustomlistview,null);
            TextView t1_name=(TextView)convertView.findViewById(R.id.name);
            TextView t1_add=(TextView)convertView.findViewById(R.id.address);
            TextView t1_time=(TextView)convertView.findViewById(R.id.time);


            Venue v1=arrayList.get(position);
            t1_name.setText(v1.getName());
            t1_add.setText(v1.getAddress());
      //      t1_time.setText(v1.getTime());

        return convertView;

    }
}
