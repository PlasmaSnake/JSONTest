package com.example.mike.jsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String json = "{"
                    + " \"name\": \"Alice\", "
                    + " \"age\": 20, "
                    + " \"address\": " + "{"
                        + " \"streetAddress\": \"100 Wall Street\", "
                        + " \"city\": \"New York\" "
                    + "},"
                    + " \"phoneNumber\": [ "
                        + "{"
                        + " \"type\": \"home\", "
                        + " \"number\": \"212-333-1111\" "
                        + "},"
                        + "{"
                        + " \"type\": \"fax\", "
                        + " \"number\": \"646-444-2222\" "
                        + "}"
                    + "]"
                + "}";
        
        if (json != null) try {
            JSONObject obj = new JSONObject(json);

            String name = obj.getString("name");
            String age = obj.getString("age");

            JSONObject ad = obj.getJSONObject("address");
            String streetAddress = ad.getString("streetAddress");
            String city = ad.getString("city");

        /*  JSONArray phone = obj.getJSONArray("phoneNumber");
            for (int i = 0; i < phone.length(); i++) {

            } */

        } catch (final JSONException e) {
        Log.e(TAG, "Json parsing error: " + e.getMessage());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),
                        "Json parsing error: " + e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });


    }
}
