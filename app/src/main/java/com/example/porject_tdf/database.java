package com.example.porject_tdf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CpuUsageInfo;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    //db naam
    public static String DATABASE_NAME = "database_project_TDF.db";

    //tabel 1
    public static final String DATABASE_table_1 = "accounts";
    public static final String Table_1_col_0 = "accounts_id";
    public static final String Table_1_col_1 = "accounts_naam";
    public static final String Table_1_col_2 = "accounts_email";
    public static final String Table_1_col_3 = "accounts_gewicht";
    public static final String Table_1_col_4 = "accounts_geboorte";

    //tabel 2
    public static final String DATABASE_table_2 = "inlog_log";
    public static final String Table_2_col_0 = "inlog_log_id";
    public static final String Table_2_col_1 = "inlog_log_naam";
    public static final String Table_2_col_2 = "inlog_log_status";


    public database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_table_1 + "(" + Table_1_col_0 + " INTEGER DEFAULT 0 primary key ,"
                + Table_1_col_1 + " TEXT default 'def'," + Table_1_col_2 + " TEXT default 'def'," + Table_1_col_3 +
                "  TEXT default 'def'," + Table_1_col_4 + " TEXT default 'def')");

        db.execSQL("create table " + DATABASE_table_2 + "(" + Table_2_col_0 + " INTEGER DEFAULT 0" +
                " primary key ,"
                + Table_2_col_1 + " TEXT default 'def'," + Table_2_col_2 + " TEXT default 'def')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_table_1);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_table_2);
    }


    //table 1
    public int IDMAKER_TABLE_1(){
        int uit = -1;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from " + DATABASE_table_1, null
        );
        if (cursor.getCount() == 0) {
            uit = 0;
        } else {
            Cursor cursor1 = sqLiteDatabase.rawQuery("select max(" + Table_1_col_0 + " ) from " + DATABASE_table_1 + "", null);
            StringBuffer stringBuffer = new StringBuffer();
            if (cursor1.moveToFirst()) {
                stringBuffer.append(cursor1.getString(0));
                uit = Integer.parseInt(stringBuffer.toString()) + 1;
            }
        }
        return uit;
    }

    public void addToTabel1(String s1,String s2,String s3,String s4) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Table_1_col_0, IDMAKER_TABLE_1());
        contentValues.put(Table_1_col_1, s1);
        contentValues.put(Table_1_col_2, s2);
        contentValues.put(Table_1_col_3, s3);
        contentValues.put(Table_1_col_4, s4);

        sqLiteDatabase.insert(DATABASE_table_1, null, contentValues);
    }

    public String[] s1() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select " + Table_1_col_1 + " from " + DATABASE_table_1 + "", null);

        String[] uits = new String[cursor.getCount()];
        for (int i = 0; i <= cursor.getCount(); i++) {
            if (cursor.moveToPosition(i)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cursor.getString(0));
                uits[i] = stringBuffer.toString();
            }
        }
        return uits;
    }
    public String[] s2() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_1_col_2 + " from " + DATABASE_table_1 + "", null);

        String[] uits = new String[cursor.getCount()];
        for (int i = 0; i <= cursor.getCount(); i++) {
            if (cursor.moveToPosition(i)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cursor.getString(0));
                uits[i] = stringBuffer.toString();
            }
        }
        return uits;
    }

    public int length_table_1(){
        int uit = 0;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from " + DATABASE_table_1, null
        );

        uit = cursor.getCount();
        return uit;
    }




    //table 2
    public int IDMAKER_TABLE_2(){
        int uit = -1;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from " + DATABASE_table_2, null
        );
        if (cursor.getCount() == 0) {
            uit = 0;
        } else {
            Cursor cursor1 =
                    sqLiteDatabase.rawQuery("select max(" + Table_2_col_0 + " ) from " + DATABASE_table_2 + "", null);
            StringBuffer stringBuffer = new StringBuffer();
            if (cursor1.moveToFirst()) {
                stringBuffer.append(cursor1.getString(0));
                uit = Integer.parseInt(stringBuffer.toString()) + 1;
            }
        }
        return uit;
    }

    public void addToTabel2(String s1,String s2) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Table_2_col_0, IDMAKER_TABLE_2());
        contentValues.put(Table_2_col_1, s1);
        contentValues.put(Table_2_col_2, s2);

        sqLiteDatabase.insert(DATABASE_table_2, null, contentValues);
    }

    public int length_table_2(){
        int uit = 0;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from " + DATABASE_table_2, null
        );

        uit = cursor.getCount();
        return uit;
    }

    public String lastStatus(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_2_col_2 + " from " + DATABASE_table_2 + "", null);

        String uit = "";
        for (int i = 0; i <= cursor.getCount(); i++) {
            if (cursor.moveToPosition(i)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cursor.getString(0));
                uit = stringBuffer.toString();
            }
        }
        return uit;
    }
}