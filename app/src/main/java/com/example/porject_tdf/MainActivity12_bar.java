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

public class MainActivity12_bar  extends ArrayAdapter<String> {

    Context context;
    String stringData[];
    int Data2;
    int Data3;
    int Data4;
    int Data5;

    public MainActivity12_bar(@NonNull Context c, String resource[], int resource2, int resource3,
                             int resource4, int resource5) {
        super(c,R.layout.activity_main_activity3_bar,resource);

        this.context = c;
        this.stringData = resource;

        this.Data2 = resource2;
        this.Data3 = resource3;
        this.Data4 = resource4;
        this.Data5 = resource5;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.activity_main_activity9_bar,parent,false);
        TextView textView1,textView2,textView3,textView4;
        ImageView imageView1,imageView2,imageView3,imageView4;

        textView1 = row.findViewById(R.id.text_1);
        textView2 = row.findViewById(R.id.text_2);
        textView3 = row.findViewById(R.id.text_3);
        textView4 = row.findViewById(R.id.text_4);



        imageView1 = row.findViewById(R.id.image_1);
        imageView2 = row.findViewById(R.id.image_2);
        imageView3 = row.findViewById(R.id.image_3);
        imageView4 = row.findViewById(R.id.image_4);

        textView1.setText(position+"");
        textView4.setText(stringData[position]);

        return row;
    }
}