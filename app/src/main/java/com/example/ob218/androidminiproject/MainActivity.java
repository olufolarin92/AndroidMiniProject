package com.example.ob218.androidminiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ob218.androidminiproject.adapters.MyAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.myListView);

        listView.setAdapter(new MyAdapter(getApplicationContext()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "News", Toast.LENGTH_LONG).show();

                        Intent newsIntent = new Intent(MainActivity.this, NewsActivity.class);
                        MainActivity.this.startActivity(newsIntent);

                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
}
