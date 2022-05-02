package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity7 extends AppCompatActivity {

    //init edits
    EditText edit1, edit2;

    //databse initen
    database db;

    //errorstring initen
    String error;

    //textviews initen
    TextView text4, text6, text7, text8;

    //array
    ArrayList<String> strings;

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
        text6 = findViewById(R.id.text_6);
        text7 = findViewById(R.id.text_7);
        text8 = findViewById(R.id.text_8);

        //db conecten
        db = new database(this);

        //errorstring conecten
        error = "";

        //array conecten
        strings = new ArrayList<>();

        //functions
        click_1();
        click_2();
        click_3();
        addUser();
    }


    public void click_1() {
        text4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                if (get2bool() && check2(get2())) {
                    strings.add(get2());
                    //System.out.println(strings.size());
                    String uit = "";
                    for (int i = 0; i < strings.size(); i++) {
                        uit += "--- " + strings.get(i) + " ---\n";
                    }
                    edit2.setText("");
                    text6.setText(uit);
                } else {
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void click_2() {

        text7.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                if (get1bool() && strings.size() >= 2) {

                    db.addToTabel3(get1(), get2db());
                    db.addToTabel4("created", db.length_table_2());

                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                    startActivity(intent);

                } else {

                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
    public void click_3() {
        text8.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);

            }
        });
    }

    public String get1() {

        String uit = "";
        uit = edit1.getText().toString();
        return uit;

    }
    public String get2() {

        String uit = "";
        uit = edit2.getText().toString();
        return uit;

    }

    public boolean get1bool() {

        Boolean b = false;

        if (!get1().isEmpty()) {

            b = true;
            error = "";

        } else {

            error = "de naam van het klassement moet ingevuld zijn of er zijn te weinig spelers " +
                    "aawezig";

        }
        return b;
    }
    public boolean get2bool() {

        Boolean b = false;

        if (!get2().isEmpty()) {

            b = true;
            error = "";

        } else {

            error = "de naam van de player moet ingevuld zijn";

        }

        return b;
    }

    public void addUser() {

        if (db.lastStatus().equals("loged in")) {

            strings.add(db.lastName());
            text6.setText("--- " + db.lastName() + " ---");

        }

    }

    public boolean check2(String s) {

        boolean uit = true;

        for (int i = 0; i < strings.size(); i++) {

            if (strings.get(i).equals(s)) {

                uit = false;
                error = "de naam is al aanwezig";

            } else {

                error = "";

            }
        }
        return uit;
    }

    public String get2db() {
        String uit = "";

        for (int i = 0; i < strings.size(); i++) {
            if (i != strings.size() - 1) {

                uit += strings.get(i) + ",";

            } else {

                uit += strings.get(i);

            }
        }
        return uit;
    }
}