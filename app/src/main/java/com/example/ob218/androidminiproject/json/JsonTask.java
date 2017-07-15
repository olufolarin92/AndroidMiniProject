package com.example.ob218.androidminiproject.json;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.ob218.androidminiproject.models.ArticleModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ob218 on 02/02/2017.
 */

public class JsonTask extends AsyncTask<String, String, List<ArticleModels>> {



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<ArticleModels> doInBackground(String... params) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            String line = "";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();

            JSONArray parentArray = new JSONArray(finalJson);

            List<ArticleModels> articleModelList = new ArrayList<>();

            for (int i = 0; i < parentArray.length(); i++)
            {
                JSONObject finalObject = parentArray.getJSONObject(i);

                ArticleModels articleModel = new ArticleModels();
                articleModel.setTitle(finalObject.getString("title"));
                articleModel.setDate(finalObject.getString("date"));
                articleModel.setRecord_id(finalObject.getInt("record_id"));
                articleModel.setImage_url(finalObject.getString("image_url"));
                articleModel.setShort_info(finalObject.getString("short_info"));

                articleModelList.add(articleModel);

            }

            return articleModelList;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection !=null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<ArticleModels> result) {
        super.onPostExecute(result);
    }
}
