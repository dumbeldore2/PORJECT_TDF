package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity10 extends AppCompatActivity {
    //textviews initen
    TextView text2,text3;

    //database initen
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.c1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c1));

        //text connecten
        text2 = findViewById(R.id.text_2);
        text3 = findViewById(R.id.text_3);

        //database conecten
        db = new database(this);

        //functions
        click_1();
        click_2();
    }


    public void click_1() {
        text2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity8.class);
                startActivity(intent);

            }
        });
    }
    public void click_2() {
        text3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity11.class);
                startActivity(intent);

            }
        });
    }
}