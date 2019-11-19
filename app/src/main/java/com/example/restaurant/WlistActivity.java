package com.example.restaurant;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class WlistActivity extends AppCompatActivity {

    private ListView listView;
    private textlistAdapter adapter;
    private List<text> textList;
    private List<text> saveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wlist);
        Intent intent = getIntent();

        listView = (ListView) findViewById(R.id.listView);
        textList = new ArrayList<text>();
        saveList = new ArrayList<text>();
        adapter = new textlistAdapter(getApplicationContext(), textList, this, saveList);
        listView.setAdapter(adapter);

        Button writeButton = (Button) findViewById(R.id.writeButton);


        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(WlistActivity.this, WriteActivity.class);
                WlistActivity.this.startActivity(Intent);
                finish();
            }
        });

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("textList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String Resname, text;
            while(count < jsonArray.length())
            {
                JSONObject object = jsonArray.getJSONObject(count);;
                Resname = object.getString("Resname");
                text = object.getString("text");
                text Text = new text(Resname, text);

                textList.add(Text);
                saveList.add(Text);

                count++;
            }
        } catch(Exception e){
            e.printStackTrace();
        }


    }

}
