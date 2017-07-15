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

import java.util.ArrayList;

/**
 * Created by ob218 on 17/04/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<ArticleModels> articleModelseList;

    public CustomAdapter(ArrayList<ArticleModels> articleModelseList, Context c) {
        this.articleModelseList = articleModelseList;
        this.c = c;
    }

    @Override
    public int getCount() {
        return articleModelseList.size();
    }

    @Override
    public Object getItem(int position) {
        return articleModelseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(c).inflate(R.layout.row, parent, false);
        }

        ImageView imageView = (ImageView)convertView.findViewById(R.id.ivIcon);
        TextView textView = (TextView)convertView.findViewById(R.id.newsArticle);
        TextView textView2 = (TextView)convertView.findViewById(R.id.articleDate);

        //textView.setText(articleModelList.get(position).getTitle());
        //textView2.setText(articleModelList.get(position).getDate());

        ArticleModels articleModels = (ArticleModels) this.getItem(position);

        textView.setText(articleModels.getTitle());
        textView2.setText(articleModels.getDate());

        return convertView;
    }
}
