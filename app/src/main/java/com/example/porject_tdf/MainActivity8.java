package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {
    //textviews initen
    TextView text1;

    //databse initen
    database db;

    //alles met de listview en zijn adapter te maken
    //de listview initen
    ListView listView;

    //test data
    String a[] = {"renners","ettapes","truinen"};
    //test data
    int b[] = {R.drawable.foto2,R.drawable.foto3,R.drawable.foto4};

    //adapter initen
    MainActivity8_bar mainActivity8_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.c1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c1));

        //text connecten
        text1 = findViewById(R.id.text_1);

        //db conecten
        db = new database(this);

        //listview stuff
        //pre listview functies

        //listview initen
        listView = findViewById(R.id.list_view_1);

        //adapter conecten
        mainActivity8_bar = new MainActivity8_bar(this,a,b);
        listView.setAdapter(mainActivity8_bar);

        //functions
        click_1();
        click_2();
    }



    public void click_1() {
        text1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);

            }
        });
    }
    public void click_2(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getApplicationContext(),MainActivity9.class);
                        db.addToTabel4("open renners",db.getTable_4_col_3());
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(),MainActivity10.class);
                        db.addToTabel4("open etapes",db.getTable_4_col_3());
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(),MainActivity2.class);
                        db.addToTabel4("open truien",db.getTable_4_col_3());
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}