package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {

    //init edits
    EditText edit1,edit2;

    //databse initen
    database db;

    //errorstring initen
    String error;

    //textviews initen
    TextView text4,text7,text8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.c1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c1));

        //edits conecten
        edit1 = findViewById(R.id.edit_1);
        edit2 = findViewById(R.id.edit_2);

        //text connecten
        text4 = findViewById(R.id.text_4);
        text7 = findViewById(R.id.text_7);
        text8 = findViewById(R.id.text_8);

        //db conecten
        db = new database(this);

        //errorstring conecten
        error = "";

        //functions
        click_1();
        click_2();
        click_3();
    }

    public void click_1(){
        text4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(intent);
            }
        });
    }
    public void click_2(){
        text4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(intent);
            }
        });
    }
    public void click_3(){
        text4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(intent);
            }
        });
    }

    public String get1(){
        String uit = "";
        uit = edit1.getText().toString();
        return uit;
    }
    public String get2(){
        String uit = "";
        uit = edit2.getText().toString();
        return uit;
    }

    public boolean get1bool(){
        Boolean b = false;
        if (!get1().isEmpty()){
            b = true;
            error = "";
        } else {
            error = "de naam moet ingevuld zijn";
        }
        return b;
    }
    public boolean get2bool(){
        Boolean b = false;
        if (!get2().isEmpty()){
            b = true;
            error = "";
        } else {
            error = "de email moet ingevuld zijn";
        }
        return b;
    }
}