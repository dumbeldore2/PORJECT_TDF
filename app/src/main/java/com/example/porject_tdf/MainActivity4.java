package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    //inite text
    TextView text6,text7;

    //init edits
    EditText edit1,edit2,edit3,edit4;

    //databse initen
    database db;

    //errorstring initen
    String error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.c1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c1));

        //text connecten
        text6 = findViewById(R.id.text_6);
        text7 = findViewById(R.id.text_7);

        //edits conecten
        edit1 = findViewById(R.id.edit_1);
        edit2 = findViewById(R.id.edit_2);
        edit3 = findViewById(R.id.edit_3);
        edit4 = findViewById(R.id.edit_4);

        //db conecten
        db = new database(this);

        //errorstring conecten
        error = "";

        //functions
        click_1();
        click_2();
    }

    public void click_1(){
        text7.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(intent);
            }
        });
    }
    public void click_2(){
        text6.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                /*
                System.out.println(get1());
                System.out.println(get2());
                System.out.println(get3());
                System.out.println(get4());
                 */
                /*
                System.out.println(get1bool());
                System.out.println(get2bool());
                System.out.println(get3bool());
                System.out.println(get4bool());
                 */

                System.out.println(check1());
                System.out.println(check2());

                if (get1bool() && get2bool() && get3bool() && get4bool() && !check1() && !check2()){
                    db.addToTabel1(get1(),get2(),get4(),get3());

                    Intent intent = new Intent(getApplicationContext(),MainActivity6.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),error,Toast.LENGTH_SHORT).show();
                }
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
    public String get3(){
        String uit = "";
        uit = edit3.getText().toString();
        return uit;
    }
    public String get4(){
        String uit = "";
        uit = edit4.getText().toString();
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
    public boolean get3bool(){
        Boolean b = false;
        if (!get3().isEmpty()){
            b = true;
            error = "";
        } else {
            error = "de geboorte datum moet ingevuld zijn";
        }
        return b;
    }
    public boolean get4bool(){
        Boolean b = false;
        if (!get4().isEmpty()){
            b = true;
            error = "";
        } else {
            error = "de gewicht moet ingevuld zijn";
        }
        return b;
    }

    public boolean check1(){
        Boolean b = false;
        if (!get1().isEmpty()){
            for (int i = 0; i < db.s1().length; i++){
                if (get1().equals(db.s1()[i])){
                    b = true;
                    error = "deze naam is al toegevoegd in de databse";
                } else {
                    error = "";
                }
            }
        }
        return b;
    }
    public boolean check2(){
        Boolean b = false;
        if (!get2().isEmpty()){
            for (int i = 0; i < db.s2().length; i++){
                if (get2().equals(db.s2()[i])){
                    b = true;
                    error = "deze emailadres is al toegevoegd in de databse";
                } else {
                    error = "";
                }
            }
        }
        return b;
    }
}