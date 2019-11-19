package com.example.restaurant;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ImageButton img = (ImageButton) findViewById(R.id.imageButton);
        ImageButton img2 = (ImageButton) findViewById(R.id.imageButton2);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BackgroundTask().execute();

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(CategoryActivity.this, GotowlistActivity.class);
                CategoryActivity.this.startActivity(Intent);

            }
        });
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected void onPreExecute() {
            target = "http://seun116.cafe24.com/rlist.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null) {
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        public void onPostExecute(String result) {
            Intent intent = new Intent(CategoryActivity.this, RlistActivity.class);
            intent.putExtra("restaurantList", result);
            CategoryActivity.this.startActivity(intent);
        }
    }





}
