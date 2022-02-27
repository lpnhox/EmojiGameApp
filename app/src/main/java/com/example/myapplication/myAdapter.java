package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.versionedparcelable.NonParcelField;

import java.util.List;
import java.util.Random;

public class myAdapter extends ArrayAdapter {
    public myAdapter (@NonNull Context context, int resource, @NonNull List objects){
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
        View myView = super.getView(position,convertView,parent);
        Random rnd = new Random();
        myView.setBackgroundColor(Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
        return myView;
    }
}
