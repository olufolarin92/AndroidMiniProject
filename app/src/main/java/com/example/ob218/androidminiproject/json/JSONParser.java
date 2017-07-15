package com.example.ob218.androidminiproject.json;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ob218.androidminiproject.R;
import com.example.ob218.androidminiproject.adapters.MyAdapter2;
import com.example.ob218.androidminiproject.models.ArticleModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ob218 on 13/03/2017.
 */

public class JSONParser extends AsyncTask<Void, Void, Boolean> {

    List<ArticleModels> articleModelList = new ArrayList<>();

    Context context;
    String jsonData;
    ListView listView;

    ProgressDialog dialog;
    ArrayList<String> articles = new ArrayList<>();

    public JSONParser(Context context, String jsonData, ListView listView) {
        this.context = context;
        this.jsonData = jsonData;
        this.listView = listView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        dialog = new ProgressDialog(context);
        dialog.setTitle("Parse JSON");
        dialog.setMessage("Parsing...please wait");
        dialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return parse();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        dialog.dismiss();
        if (isParsed)
        {
            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.row, articles);
            //listView.setAdapter(adapter);

            /*listView.setAdapter(new MyAdapter2(context, R.layout.row, articleModelList));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, (CharSequence) articleModelList.get(position), Toast.LENGTH_SHORT).show();
                }
            });*/
        } else
        {
            Toast.makeText(context, "Unable to parse. Check your log output", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parse()
    {
        try {

        JSONArray parentArray = null;

            parentArray = new JSONArray(jsonData);
            articleModelList.clear();
            ArticleModels articleModels;

            for (int i = 0; i < parentArray.length(); i++)
            {
                JSONObject finalObject = parentArray.getJSONObject(i);

                String title = finalObject.getString("title");
                String date = finalObject.getString("date");
                int record_id = finalObject.getInt("record_id");
                String image_url = finalObject.getString("image_url");
                String short_info = finalObject.getString("short_info");

                articleModels = new ArticleModels();

                articleModels.setTitle(title);
                articleModels.setDate(date);
                articleModels.setRecord_id(record_id);
                articleModels.setImage_url(image_url);
                articleModels.setShort_info(short_info);

                //ArticleModels articleModel = new ArticleModels();
                //articleModel.setTitle(finalObject.getString("title"));
                //articleModel.setDate(finalObject.getString("date"));
                //articleModel.setRecord_id(finalObject.getInt("record_id"));
                //articleModel.setImage_url(finalObject.getString("image_url"));
                //articleModel.setShort_info(finalObject.getString("short_info"));

                articleModelList.add(articleModels);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
