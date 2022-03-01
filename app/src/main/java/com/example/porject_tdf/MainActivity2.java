package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    //textvieuws initen
    TextView textView_1, textView_2,textView_3,textView_4;

    //image view intien
    ImageView imageView_1;

    //int color
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.c1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c1));

        //textviews conecten
        textView_1 = findViewById(R.id.text_1);
        textView_2 = findViewById(R.id.text_2);
        textView_3 = findViewById(R.id.text_3);
        textView_4 = findViewById(R.id.text_4);

        //imageview conecten
        imageView_1 = findViewById(R.id.image_1);

        //c initen
        c = 0;

        //functions
        setToYellow();
        clickListners();
    }

    public void setToYellow(){
        textView_1.setBackground(ContextCompat.getDrawable(this,
                R.drawable.button_background_bollen));
        textView_2.setBackground(ContextCompat.getDrawable(this,
                R.drawable.button_background_green));
        imageView_1.setImageResource(R.drawable.geel);
        textView_3.setBackgroundColor(getResources().getColor(R.color.c6));
        textView_3.setTextColor(getResources().getColor(R.color.c1));
        textView_4.setText("GEEL");
        textView_4.setTextColor(getResources().getColor(R.color.c6));
    }

    public void setToGreen(){
        textView_1.setBackground(ContextCompat.getDrawable(this,
                R.drawable.button_background_yellow));
        textView_2.setBackground(ContextCompat.getDrawable(this,
                R.drawable.button_background_wit));
        imageView_1.setImageResource(R.drawable.groen);
        textView_3.setBackgroundColor(getResources().getColor(R.color.c7));
        textView_3.setTextColor(getResources().getColor(R.color.c1));
        textView_4.setText("GROEN");
        textView_4.setTextColor(getResources().getColor(R.color.c7));
    }

    public void setToWit(){
        textView_1.setBackground(ContextCompat.getDrawable(this,
                R.drawable.button_background_green));
        textView_2.setBackground(ContextCompat.getDrawable(this,
                R.drawable.button_background_bollen));
        imageView_1.setImageResource(R.drawable.wit);
        textView_3.setBackgroundColor(getResources().getColor(R.color.c9));
        textView_3.setTextColor(getResources().getColor(R.color.c1));
        textView_4.setText("WIT");
        textView_4.setTextColor(getResources().getColor(R.color.c9));
    }

    public void setToBol(){
        textView_1.setBackground(ContextCompat.getDrawable(this,
                R.drawable.button_background_wit));
        textView_2.setBackground(ContextCompat.getDrawable(this,
                R.drawable.button_background_yellow));
        imageView_1.setImageResource(R.drawable.bol);
        textView_3.setBackgroundColor(getResources().getColor(R.color.c8));
        textView_3.setTextColor(getResources().getColor(R.color.c10));
        textView_4.setText("BOLLEN");
        textView_4.setTextColor(getResources().getColor(R.color.c8));
    }

    public void clickListners(){
        textView_1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                switch (c){
                    case 0:
                        setToBol();
                        break;
                    case 1:
                        setToYellow();
                        break;
                    case 2:
                        setToGreen();
                        break;
                    case 3:
                        setToWit();
                        break;
                }
                if (c == 0){
                    c = 3;
                } else {
                    c --;
                }
            }
        });
        textView_2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                switch (c){
                    case 0:
                        setToGreen();
                        break;
                    case 1:
                        setToWit();
                        break;
                    case 2:
                        setToBol();
                        break;
                    case 3:
                        setToYellow();
                        break;
                }
                if (c == 3){
                    c = 0;
                } else {
                    c ++;
                }
            }
        });
    }
}