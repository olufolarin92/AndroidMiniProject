package com.example.ob218.androidminiproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ob218.androidminiproject.R;

/**
 * Created by ob218 on 01/02/2017.
 */

public class MyAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;

    private String[] labelID = {"News", "Search"};
    private Integer[] imageID = {R.drawable.newsclipart, R.drawable.searchclipart};

    public MyAdapter(Context context) {this.layoutInflater = layoutInflater.from(context);}

    @Override
    public int getCount() {
        return imageID.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = layoutInflater.inflate(R.layout.main_menu_row, null);

        ImageView imageView = (ImageView)convertView.findViewById(R.id.menuImage);
        TextView textView = (TextView)convertView.findViewById(R.id.menuTitle);

        textView.setText(labelID[position]);
        imageView.setBackgroundResource(imageID[position]);

        return convertView;
    }
}
