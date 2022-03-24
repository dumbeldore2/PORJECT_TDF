package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {

    //textviews initen
    TextView text1;

    //carousel initen
    Carousel carousel;

    //fotos for carousel
    int [] images = {R.drawable.foto2, R.drawable.foto3, R.drawable.foto4};

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

        //carousel connecten
        carousel = findViewById(R.id.carousel);

        //carousel adapter
        carousel.setAdapter(new Carousel.Adapter() {
            @Override
            public int count() {
                return images.length;
            }

            @Override
            public void populate(View view, int index){
            }

            @Override
            public void onNewItem(int index) {

            }
        });

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