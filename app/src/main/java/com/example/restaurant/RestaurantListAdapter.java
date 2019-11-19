package com.example.restaurant;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

public class RestaurantListAdapter extends BaseAdapter{
    private Context context;
    private List<Restaurant> restaurantList;
    private List<Restaurant> saveList;

    public RestaurantListAdapter(Context context, List<Restaurant> restaurantList, Activity parentActivity, List<Restaurant> saveList){
        this.context = context;
        this.restaurantList = restaurantList;
        this.saveList = saveList;
    }



    @Override
    public int getCount() {
        return restaurantList.size();
    }

    @Override
    public Object getItem(int i) {
        return restaurantList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.activity_restaurant, null);

        final TextView Rname = (TextView) v.findViewById(R.id.ResnameText);
        final TextView Raddress = (TextView) v.findViewById(R.id.Raddress);
        final TextView Rlocation = (TextView) v.findViewById(R.id.TitleText);
        final TextView Telenum = (TextView) v.findViewById(R.id.Telenum);

        Rname.setText(restaurantList.get(i).getRname());
        Raddress.setText(restaurantList.get(i).getRaddress());
        Rlocation.setText(restaurantList.get(i).getRlocation());
        Telenum.setText(restaurantList.get(i).getTelenum());

        v.setTag(restaurantList.get(i).getRname());

        return v;
    }
}
