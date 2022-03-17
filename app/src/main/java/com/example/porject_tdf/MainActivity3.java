package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

public class MainActivity3 extends AppCompatActivity {


    //alles met de listview en zijn adapter te maken
    //de listview initen
    ListView listView;

    //test data
    String a[] = {"Team 1","Team 2","Team 3","Team 4"};
    String b[] = {"yago,scott,aiko","yago,scott","phara,yago","merel,yago"};

    //adapter initen
    MainActivity3_bar mainActivity3_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.c1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c1));


        //listview stuff
        //listview initen
        listView = findViewById(R.id.list_view_1);

        //adapter conecten
        mainActivity3_bar = new MainActivity3_bar(this,a,b);
        listView.setAdapter(mainActivity3_bar);
    }
}