package com.example.porject_tdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    //images initen
    ImageView image1;

    //textviews initen
    TextView text3,text4;

    //errorstring initen
    String error;

    //databse initen
    database db;

    //init edits
    EditText edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.c1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c1));

        //images conectyen
        image1 = findViewById(R.id.image_1);

        // textviews conecten
        text3 = findViewById(R.id.text_3);
        text4 = findViewById(R.id.text_4);

        //edits conecten
        edit1 = findViewById(R.id.edit_1);

        //db conecten
        db = new database(this);

        //errorstring conecten
        error = "";

        //function
        click_1();
        click_2();
        click_3();
    }

    public void click_1(){
        image1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(intent);
            }
        });
    }

    public void click_2(){
        text4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(intent);
            }
        });
    }

    public void click_3(){
        text3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                /*
                System.out.println(get1());
                System.out.println(get1bool());
                System.out.println(check1());
                 */

                if (get1bool() && check1()){

                    db.addToTabel2(get1(),"loged in");

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
                    for (int i = 0; i < db.s1().length; i++){
                        if (get1().equals(db.s1()[i])){
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
}