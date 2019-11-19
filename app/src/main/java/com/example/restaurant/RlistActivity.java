package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class RlistActivity extends AppCompatActivity {

    private ListView listView;
    private RestaurantListAdapter adapter;
    private List<Restaurant> restaurantList;
    private List<Restaurant> saveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlist);
        Intent intent = getIntent();

        listView = (ListView) findViewById(R.id.listView);
        restaurantList = new ArrayList<Restaurant>();
        saveList = new ArrayList<Restaurant>();
        adapter = new RestaurantListAdapter(getApplicationContext(), restaurantList, this, saveList);
        listView.setAdapter(adapter);

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("restaurantList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String Rname, Raddress, Rlocation, Telenum;
            while(count < jsonArray.length())
            {
                JSONObject object = jsonArray.getJSONObject(count);
                Rname =  object.getString("Rname");
                Raddress = object.getString("Raddress");
                Rlocation =  object.getString("Rlocation");
                Telenum = object.getString("Telenum");
                Restaurant restaurant = new Restaurant(Rname, Raddress, Rlocation, Telenum);

                restaurantList.add(restaurant);
                saveList.add(restaurant);

                count++;
        }
        } catch(Exception e){
            e.printStackTrace();
        }

        EditText search = (EditText) findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchRestaurant(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void searchRestaurant(String search){
        restaurantList.clear();
        for(int i =0 ; i < saveList.size(); i++){
            if(saveList.get(i).getRname().contains(search))
            {
                restaurantList.add(saveList.get(i));
            }

            if(saveList.get(i).getRlocation().contains(search))
            {
                restaurantList.add(saveList.get(i));
            }


        }
        adapter.notifyDataSetChanged();
    }
}
