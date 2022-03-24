package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {

    //textviews initen
    TextView text1;

    //alles met de listview en zijn adapter te maken
    //de listview initen
    ListView listView;

    //test data
    String a[] = {"renners","renners","renners"};
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

        //listview stuff
        //pre listview functies

        //listview initen
        listView = findViewById(R.id.list_view_1);

        //adapter conecten
        mainActivity8_bar = new MainActivity8_bar(this,a,b);
        listView.setAdapter(mainActivity8_bar);

        //functions
        click_1();
    }



    public void click_1() {
        text1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);

            }
        });
    }
}