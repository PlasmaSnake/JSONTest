package com.example.mike.jsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

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


    }
}
