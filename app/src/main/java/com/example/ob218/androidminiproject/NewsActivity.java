package com.example.ob218.androidminiproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ob218.androidminiproject.json.JSONDownloader;
import com.example.ob218.androidminiproject.json.JsonTask;

public class NewsActivity extends AppCompatActivity {

    String jsonURL = "http://www.efstratiou.info/projects/newsfeed/getList.php";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        //JsonTask jsonTask = new JsonTask();

        //jsonTask.execute("http://www.efstratiou.info/projects/newsfeed/getList.php");

        listView = (ListView) findViewById(R.id.lvArticles);

        new JSONDownloader(NewsActivity.this, jsonURL, listView).execute();
    }
}
