package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity9 extends AppCompatActivity {

    //textviews initen
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.c1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c1));

        //text connecten
        text2 = findViewById(R.id.text_2);

        //functions
        click_1();
    }


    public void click_1() {
        text2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity8.class);
                startActivity(intent);

            }
        });
    }
}