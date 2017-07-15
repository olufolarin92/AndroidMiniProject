package com.example.ob218.androidminiproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ob218.androidminiproject.R;
import com.example.ob218.androidminiproject.models.ArticleModels;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by ob218 on 02/02/2017.
 */

public class MyAdapter2 extends BaseAdapter {

    private List<ArticleModels> articleModelList;
    private int resource;
    private LayoutInflater layoutInflater;

    public MyAdapter2(Context context, int resource, List objects) {
        articleModelList = objects;
        this.resource = resource;
        //layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row, null);
        }

        ImageView imageView = (ImageView)convertView.findViewById(R.id.ivIcon);
        TextView textView = (TextView)convertView.findViewById(R.id.newsArticle);
        TextView textView2 = (TextView)convertView.findViewById(R.id.articleDate);

        textView.setText(articleModelList.get(position).getTitle());
        textView2.setText(articleModelList.get(position).getDate());

        return convertView;
    }
}
