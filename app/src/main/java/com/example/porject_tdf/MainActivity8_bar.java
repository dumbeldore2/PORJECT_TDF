package com.example.porject_tdf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity8_bar extends ArrayAdapter<String> {

    Context context;
    String stringData[];
    int stringData2[];

    public MainActivity8_bar(@NonNull Context c, String resource[], int resource2[]) {
        super(c,R.layout.activity_main_activity3_bar,resource);

        this.context = c;
        this.stringData = resource;
        this.stringData2 = resource2;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.activity_main_activity8_bar,parent,false);
        TextView textView1;
        ImageView imageView1;


        textView1 = row.findViewById(R.id.text_1);
        imageView1 = row.findViewById(R.id.image_1);

        textView1.setText(stringData[position]);
        imageView1.setBackground(ContextCompat.getDrawable(context, stringData2[position]));
        return row;
    }
}