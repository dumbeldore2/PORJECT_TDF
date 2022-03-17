package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class MainActivity3 extends AppCompatActivity {

    //textview initen
    TextView text2;

    //alles met de listview en zijn adapter te maken
    //de listview initen
    ListView listView;

    //test data
    String a[] = {"Team 1","Team 2","Team 3","Team 4","Team 4","Team 4"};
    String b[] = {"yago,scott,aiko","yago,scott","phara,yago","merel,yago","merel,yago","merel,yago"};

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

        //textviews conecten
        text2 = findViewById(R.id.text_2);

        //listview stuff
        //listview initen
        listView = findViewById(R.id.list_view_1);

        //adapter conecten
        mainActivity3_bar = new MainActivity3_bar(this,a,b);
        listView.setAdapter(mainActivity3_bar);

        //functies
        click_fun1();
    }

    public void click_fun1(){
        text2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity7.class);
                startActivity(intent);
            }
        });
    }
}