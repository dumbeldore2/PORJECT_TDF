package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class MainActivity3 extends AppCompatActivity {

    //textview initen
    TextView text2,text3;

    //databse initen
    database db;

    //alles met de listview en zijn adapter te maken
    //de listview initen
    ListView listView;

    //test data
    String a[] = {""};
    String b[] = {""};

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
        text3 = findViewById(R.id.text_3);

        //db conecten
        db = new database(this);


        if(db.length_table_3() != 0){
            //listview stuff
            //pre listview functies
            syncdb();
            //listview initen
            listView = findViewById(R.id.list_view_1);

            //adapter conecten
            mainActivity3_bar = new MainActivity3_bar(this,a,b);
            listView.setAdapter(mainActivity3_bar);

        }
        //functies
        click_fun1();
        click_fun2();
        click_fun3();
    }

    public void click_fun1(){
        text2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity7.class);
                startActivity(intent);
            }
        });
    }
    public void click_fun2(){
        text3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(intent);
            }
        });
    }
    public void click_fun3(){
        if(db.length_table_3() != 0){
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity8.class);

                    System.out.println(i);
                    System.out.println(db.getTable_3_col_7(i));

                    startActivity(intent);
                }
            });
        }
    }

    public void syncdb(){
        if (db.t3s1().length != 0){
            a = db.t3s1();
            b = db.t3s2();
        }
    }
}