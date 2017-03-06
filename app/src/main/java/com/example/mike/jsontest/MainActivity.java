package com.example.mike.jsontest;

import android.os.SystemClock;
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

        try {
            JSONObject obj = new JSONObject(json);

            String name = obj.getString("name");
            int age = obj.getInt("age");

            JSONObject ad = obj.getJSONObject("address");
            String streetAddress = ad.getString("streetAddress");
            String city = ad.getString("city");

            System.out.println(name);
            System.out.println(age);
            System.out.println(city);
            System.out.println(streetAddress);

            JSONArray phone = obj.getJSONArray("phoneNumber");
            for (int i = 0; i < phone.length(); i++) {
                JSONObject object = phone.getJSONObject(i);
                String type = object.getString("type");
                String number = object.getString("number");
                System.out.println(type);
                System.out.println(number);
            }
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
}
