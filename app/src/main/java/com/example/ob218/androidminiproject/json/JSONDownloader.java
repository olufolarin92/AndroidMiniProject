package com.example.ob218.androidminiproject.json;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by ob218 on 13/03/2017.
 */

public class JSONDownloader extends AsyncTask<Void, Void, String> {
    Context context;
    String jsonURL;
    ListView listView;

    ProgressDialog dialog;

    public JSONDownloader(Context context, String jsonURL, ListView listView) {
        this.context = context;
        this.jsonURL = jsonURL;
        this.listView = listView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        dialog = new ProgressDialog(context);
        dialog.setTitle("Download JSON");
        dialog.setMessage("Downloading....please wait");
        dialog.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return download();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        //Toast.makeText(context, "Post Execute",Toast.LENGTH_SHORT).show();

        dialog.dismiss();

        if (jsonData.startsWith("Error"))
        {
            String error = jsonData;
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
        } else
        {
            new JSONParser(context, jsonData, listView).execute();
        }
    }

    private String download()
    {
        //HttpURLConnection connection = null;
        //BufferedReader reader = null;

        //Toast.makeText(context, "Download Method",Toast.LENGTH_SHORT).show();

        Object connection = Connector.connect(jsonURL);
        if (connection.toString().startsWith("Error"))
        {
            return connection.toString();
        }

        try {
            HttpURLConnection con = (HttpURLConnection) connection;
            if(con.getResponseCode() == con.HTTP_OK)
            {
                InputStream stream = new BufferedInputStream(con.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

                String line = "";
                StringBuffer jsonData = new StringBuffer();

                while ((line = reader.readLine()) != null)
                {
                    jsonData.append(line);
                }

                reader.close();
                stream.close();

                return jsonData.toString();

            } else {
                return "Error: " + con.getResponseMessage();
            }


        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
