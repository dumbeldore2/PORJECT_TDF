package com.example.porject_tdf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity3_bar extends ArrayAdapter<String> {

    Context context;
    String stringData[];
    String names[];

    public MainActivity3_bar(@NonNull Context c, String resource[], String resource2[]) {
        super(c,R.layout.activity_main_activity3_bar,resource);

        this.context = c;
        this.stringData = resource;
        this.names = resource2;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.activity_main_activity3_bar,parent,false);
        TextView textView1,textView2,textView3;

        textView1 = row.findViewById(R.id.text_1);
        textView2 = row.findViewById(R.id.text_2);
        textView3 = row.findViewById(R.id.text_3);

        textView1.setText(position+"");
        textView2.setText(stringData[position]);
        textView3.setText(getNames(position));

        return row;
    }

    public String getNames(int a) {
        String uit = "";

        //System.out.println(names[a]);

        String[] arr = names[a].split(",");

        for (int i = 0 ; i < arr.length ; i++){
            uit += " - " + arr[i] + "\n";
        }
        return uit;
    }
}