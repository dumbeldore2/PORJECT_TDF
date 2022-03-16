package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity6 extends AppCompatActivity {

    //imageviews initen
    ImageView image1,image2;

    //databse initen
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.c1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c1));

        //imageses conecten
        image1 = findViewById(R.id.image_1);
        image2 = findViewById(R.id.image_2);

        //db conecten
        db = new database(this);

        //functies
        click_1();
        logInListner();
    }

    public void click_1(){
        image1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity5.class);
                startActivity(intent);
            }
        });

        image1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override public boolean onLongClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(intent);
                return true;
            }
        });
    }

    public void logInListner(){
        /*
        System.out.println(db.lastStatus());
         */

        if (db.lastStatus().equals("loged in")){
            image2.setImageResource(R.drawable.ic_baseline_check_circle_24);
        } else {
            image2.setImageResource(R.drawable.ic_baseline_clear_24);
        }
    }
}