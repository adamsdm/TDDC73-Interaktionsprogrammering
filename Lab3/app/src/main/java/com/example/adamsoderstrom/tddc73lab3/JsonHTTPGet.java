package com.example.adamsoderstrom.tddc73lab3;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.ContentValues.TAG;


// https://stackoverflow.com/questions/33229869/get-json-data-from-url-using-android

public class JsonHTTPGet extends AsyncTask<String, String, String> {

    private String searchResult;
    private InteractiveSearcher interactiveSearcher;

    private int id;

    public JsonHTTPGet(int _id, InteractiveSearcher _interactiveSearcher){
        id = _id;
        interactiveSearcher = _interactiveSearcher;
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String doInBackground(String... params) {


        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {

            String name = params[0];
            String id = params[1];

            String urlString = "http://getnames-getnames.a3c1.starter-us-west-1.openshiftapps.com/getnames/" + id + "/" +name;


            URL url = new URL(urlString);


            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
            }

            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
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
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if(result == null || result.isEmpty()) {
            return;
        }

        try {
            JSONObject jsonObj = new JSONObject(result);

            int id = jsonObj.getInt("id");
            JSONArray res = jsonObj.getJSONArray("result");


            String[] stringArray = new String[ res.length()];
            for(int i=0; i<res.length(); i++) {
                stringArray[i] = res.getString(i);
            }


            // We only want to update the results if its the latest result
            if(id>=interactiveSearcher.getId())
                interactiveSearcher.getSuggestionBox().setSuggestions(stringArray);


        } catch (JSONException e){
            e.printStackTrace();
        }



    }

}