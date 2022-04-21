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
    //database initen
    database db;

    //errorstring initen
    String error;

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
    String a[] = {""};
    int b = -1;
    int c = -1;
    int d = -1;
    int e = -1;

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

        //System.out.println(idList);

        //database conecten
        db = new database(this);

        //text connecten
        text2 = findViewById(R.id.text_2);
        text3 = findViewById(R.id.text_3);

        //dialogt koppelen
        dialog = new Dialog(this);

        //errorstring conecten
        error = "";

        if(a.length != 0){
            //listview stuff
            //pre listview functies
            syncdb();

            //listview initen
            listView = findViewById(R.id.list_view_1);

            //adapter conecten
            mainActivity9_bar = new MainActivity9_bar(this,a,b,c,d,e);
            listView.setAdapter(mainActivity9_bar);
        }

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
                        if(get1bool()){
                            db.addToT3C7(get1(),db.getTable_4_col_3());
                            syncdb();
                            mainActivity9_bar = new MainActivity9_bar(getApplicationContext(),a,b
                                    ,c,d,e);
                            listView.setAdapter(mainActivity9_bar);
                        }
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
    }

    public String get1(){
        String uit = "";
        uit = editTextDialog1.getText().toString();
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

    public boolean check1(){
        Boolean b = false;

        //System.out.println(db.length_table_1());

        if (db.length_table_1() == 0){
            error = "deze naam is nog niet gekend in de databse";
        } else {
            if (!get1().isEmpty()){
                for (int i = 0; i < db.t1s1().length; i++){
                    if (get1().equals(db.t1s1()[i])){
                        b = true;
                        error = "";
                    } else {
                        error = "deze naam is nog niet gekend in de databse";
                    }
                }
            }
        }
        return b;
    }

    public void syncdb(){
        if (db.t3s7().length != 0){
            //System.out.println(idList);
            a = db.t3s7()[db.getTable_4_col_3()].split(",");
            //System.out.println(a.length);
            b = db.bol(db.getTable_4_col_3());
            c = db.wit(db.getTable_4_col_3());
            d = db.groen(db.getTable_4_col_3());
            e = db.geel(db.getTable_4_col_3());
        }
    }
}

