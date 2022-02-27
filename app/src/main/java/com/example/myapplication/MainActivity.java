package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.media.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        List<Integer> emojis = Arrays.asList(
                9800,9802,9803, 9804, 9805, 9806, 9807, 9808
        );
        List data = new ArrayList();
        for(int i = 0; i<emojis.size(); i++){
            data.add(new String(Character.toChars(emojis.get(i))));
        }
        Collections.shuffle(data);

        myAdapter adapter = new myAdapter(getApplicationContext(), R.layout.items, data);
        gridView.setAdapter(adapter);

        List temp = new ArrayList(data);
        final String[] target = {showEmoji(temp)};
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView v = (TextView) view;
                String selected = v.getText().toString();
                if(selected == target[0]){
                    temp.remove(target[0]);
                    v.setText("");
                    if (temp.size() <= 0){
                        Intent winAct = new Intent(getApplicationContext(), WinActivity.class);
                        startActivity(winAct);
                    }
                }
                else {
                    startActivity(new Intent(getApplicationContext(), LoseActivity.class));
                }
                target[0] = showEmoji(temp);
            }
        });
    }

    protected String showEmoji(List<String> list) {
        Random rnd = new Random();
        String result = list.get(rnd.nextInt(list.size()));
        TextView target = findViewById(R.id.target);
        target.setText(result);
        return result;
    }
}