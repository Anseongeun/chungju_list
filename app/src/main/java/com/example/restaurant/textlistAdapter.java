package com.example.restaurant;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class textlistAdapter extends BaseAdapter {

    private Context context;
    private List<text> textList;
    private List<text> saveList;

    public textlistAdapter(Context context, List<text> textList,  Activity parentActivity,  List<text> saveList){
        this.context = context;
        this.textList = textList;
        this.saveList = saveList;
    }



    @Override
    public int getCount() {
        return textList.size();
    }

    @Override
    public Object getItem(int i) {
        return textList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.text, null);


        final TextView Resname = (TextView) v.findViewById(R.id.ResnameText);
        //final TextView text = (TextView) v.findViewById(R.id.textText);
        final TextView text = (TextView) v.findViewById(R.id.text);


        Resname.setText(textList.get(i).getResname());
        text.setText(textList.get(i).gettext());

        v.setTag(textList.get(i).getResname());

        return v;
    }
}
