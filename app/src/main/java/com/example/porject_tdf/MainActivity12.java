package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity12 extends AppCompatActivity {

    //image views initen
    ImageView imageView1;

    //database initen
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.c1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c1));

        //imageviews conecten
        imageView1 = findViewById(R.id.image_1);

        //database conecten
        db = new database(this);

        //functies
        click_1();
    }

    public void click_1(){
        Intent intent = new Intent(getApplicationContext(),MainActivity13.class);
        db.addToTabel4("adding yellow info", db.getTable_4_col_3());
        startActivity(intent);
    }


}