package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity9 extends AppCompatActivity {

    //textviews initen
    TextView text2,text3;

    //alles met een dialog te maken
    //initen dialog
    Dialog dialog;

    //de dialog elementen initen
    TextView textViewdialog1;
    EditText editTextDialog1 ,editTextDialog2 , editTextDialog3;

    //alles met de listview en zijn adapter te maken
    //de listview initen
    ListView listView;

    //test data
    String a[] = {"yago","scott","aiko","aiko","aiko","aiko","aiko","aiko"};

    //adapter initen
    MainActivity9_bar mainActivity9_bar;
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
        text3 = findViewById(R.id.text_3);

        //dialogt koppelen
        dialog = new Dialog(this);

        //listview stuff
        //pre listview functies

        //listview initen
        listView = findViewById(R.id.list_view_1);

        //adapter conecten
        mainActivity9_bar = new MainActivity9_bar(this,a);
        listView.setAdapter(mainActivity9_bar);

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

                dialog.setContentView(R.layout.dialog1);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                textViewdialog1 = dialog.findViewById(R.id.text_4);
                editTextDialog1 = dialog.findViewById(R.id.edit_1);
                editTextDialog2 = dialog.findViewById(R.id.edit_2);
                editTextDialog3 = dialog.findViewById(R.id.edit_3);

                textViewdialog1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
    }
}