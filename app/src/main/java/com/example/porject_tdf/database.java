package com.example.porject_tdf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CpuUsageInfo;

import androidx.annotation.Nullable;

import java.util.Calendar;

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

    //tabel 3
    public static final String DATABASE_table_3 = "c";
    public static final String Table_3_col_0 = "c_id";
    public static final String Table_3_col_1 = "c_naam";
    public static final String Table_3_col_2 = "c_status";
    public static final String Table_3_col_3 = "c_bol";
    public static final String Table_3_col_4 = "c_wit";
    public static final String Table_3_col_5 = "c_groen";
    public static final String Table_3_col_6 = "c_geel";
    public static final String Table_3_col_7 = "c_field";

    //tabel 4
    public static final String DATABASE_table_4 = "c_log";
    public static final String Table_4_col_0 = "c_log_id";
    public static final String Table_4_col_1 = "c_log_naam";
    public static final String Table_4_col_2 = "c_log_status";
    public static final String Table_4_col_3 = "c_log_id_c";

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

        db.execSQL("create table " + DATABASE_table_3 + "(" + Table_3_col_0 + " INTEGER DEFAULT 0" +
                " primary key ,"
                + Table_3_col_1 + " TEXT default 'def'," + Table_3_col_2 + " TEXT default 'def'," + Table_3_col_3 +
                "  TEXT default 'def'," + Table_3_col_4 + " TEXT default 'def'," + Table_3_col_5 + " TEXT default 'def'," + Table_3_col_6 + " TEXT default 'def'," + Table_3_col_7 + " TEXT default 'def')");

        db.execSQL("create table " + DATABASE_table_4 + "(" + Table_4_col_0 + " INTEGER DEFAULT " +
                "0 primary key ," + Table_4_col_1 + " TEXT default 'def' ," + Table_4_col_2 +
                " TEXT default 'def' , "+ Table_4_col_3 +" INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_table_1);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_table_2);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_table_3);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_table_4);
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
    public String[] t1s1() {
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
    public String[] t1s2() {
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
    public String lastName(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_2_col_1 + " from " + DATABASE_table_2 + "", null);

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

    //table 3
    public int IDMAKER_TABLE_3(){
        int uit = -1;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from " + DATABASE_table_3, null
        );
        if (cursor.getCount() == 0) {
            uit = 0;
        } else {
            Cursor cursor1 =
                    sqLiteDatabase.rawQuery("select max(" + Table_3_col_0 + " ) from " + DATABASE_table_3 + "", null);
            StringBuffer stringBuffer = new StringBuffer();
            if (cursor1.moveToFirst()) {
                stringBuffer.append(cursor1.getString(0));
                uit = Integer.parseInt(stringBuffer.toString()) + 1;
            }
        }
        return uit;
    }
    public void addToTabel3(String s1,String s2) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String [] s2Ar = s2.split(",");
        String jerseys = "";

        for (int i = 0 ; i < s2Ar.length; i++){
            if (i == 0){
                jerseys += s2Ar[i] + "=0";
            } else {
                jerseys +="," + s2Ar[i] + "=0";
            }
        }

        contentValues.put(Table_3_col_0, IDMAKER_TABLE_3());
        contentValues.put(Table_3_col_1, s1);
        contentValues.put(Table_3_col_2, "inactief");
        contentValues.put(Table_3_col_3, jerseys);
        contentValues.put(Table_3_col_4, jerseys);
        contentValues.put(Table_3_col_5, jerseys);
        contentValues.put(Table_3_col_6, jerseys);
        contentValues.put(Table_3_col_7, s2);

        sqLiteDatabase.insert(DATABASE_table_3, null, contentValues);
    }
    public int length_table_3(){
        int uit = 0;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from " + DATABASE_table_3, null
        );

        uit = cursor.getCount();
        return uit;
    }
    public String [] t3s1(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_3_col_1 + " from " + DATABASE_table_3 + "", null);

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
    public String [] t3s3(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_3_col_3 + " from " + DATABASE_table_3 + "", null);

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
    public String [] t3s4(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_3_col_4 + " from " + DATABASE_table_3 + "", null);

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
    public String [] t3s5(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_3_col_5 + " from " + DATABASE_table_3 + "", null);

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
    public String [] t3s6(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_3_col_6 + " from " + DATABASE_table_3 + "", null);

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
    public String [] t3s7(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_3_col_7 + " from " + DATABASE_table_3 + "", null);

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
    public void addToT3C3(String s1, int id){

        String uit = getTable_3_col_3(id);
        uit += "," + s1;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Table_3_col_3, uit);

        sqLiteDatabase.update(DATABASE_table_3, contentValues, Table_3_col_0+" = ?",new String[]{id + ""});
    }
    public void addToT3C4(String s1, int id){

        String uit = getTable_3_col_4(id);
        uit += "," + s1;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Table_3_col_4, uit);

        sqLiteDatabase.update(DATABASE_table_3, contentValues, Table_3_col_0+" = ?",new String[]{id + ""});
    }
    public void addToT3C5(String s1, int id){

        String uit = getTable_3_col_5(id);
        uit += "," + s1;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Table_3_col_5, uit);

        sqLiteDatabase.update(DATABASE_table_3, contentValues, Table_3_col_0+" = ?",new String[]{id + ""});
    }
    public void addToT3C6(String s1, int id){

        String uit = getTable_3_col_6(id);
        uit += "," + s1;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Table_3_col_6, uit);

        sqLiteDatabase.update(DATABASE_table_3, contentValues, Table_3_col_0+" = ?",new String[]{id + ""});
    }
    public void addToT3C7(String s1, int id){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Table_3_col_3, getTable_3_col_3(id) + ","+s1+"=0");
        contentValues.put(Table_3_col_4, getTable_3_col_3(id) + ","+s1+"=0");
        contentValues.put(Table_3_col_5, getTable_3_col_3(id) + ","+s1+"=0");
        contentValues.put(Table_3_col_6, getTable_3_col_3(id) + ","+s1+"=0");
        contentValues.put(Table_3_col_7, getTable_3_col_7(id) + ","+s1);

        sqLiteDatabase.update(DATABASE_table_3, contentValues, Table_3_col_0+" = ?",new String[]{id + ""});
    }
    public String getTable_3_col_3(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_3_col_3 + " from " + DATABASE_table_3 + " where " + Table_3_col_0 + " == " + id + "", null);

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
    public String getTable_3_col_4(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_3_col_4 + " from " + DATABASE_table_3 + " where " + Table_3_col_0 + " == " + id + "", null);

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
    public String getTable_3_col_5(int id){
                SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
                Cursor cursor =
                        sqLiteDatabase.rawQuery("select " + Table_3_col_5 + " from " + DATABASE_table_3 + " where " + Table_3_col_0 + " == " + id + "", null);

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
    public String getTable_3_col_6(int id){
                SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
                Cursor cursor =
                        sqLiteDatabase.rawQuery("select " + Table_3_col_6 + " from " + DATABASE_table_3 + " where " + Table_3_col_0 + " == " + id + "", null);

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
    public String getTable_3_col_7(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_3_col_7 + " from " + DATABASE_table_3 + " where " + Table_3_col_0 + " == " + id + "", null);

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
    public int bol(int id){
        String naam = "";
        int punten = -1;
        int pos = -1;

        String [] klassement = getTable_3_col_3(id).split(",");

        for (int i = 0 ; i < klassement.length ; i ++){
            String [] cijfer = klassement[i].split("=");
            if (Integer.parseInt(cijfer[1]) > punten){

                punten = Integer.parseInt(cijfer[1]);
                naam = cijfer[0];
                pos = i;

            }
        }
        return pos;
    }
    public int wit(int id){
        String naam = "";
        int punten = -1;
        int pos = -1;

        String [] klassement = getTable_3_col_4(id).split(",");

        for (int i = 0 ; i < klassement.length ; i ++){
            String [] cijfer = klassement[i].split("=");
            if (Integer.parseInt(cijfer[1]) > punten){

                punten = Integer.parseInt(cijfer[1]);
                naam = cijfer[0];
                pos = i;

            }
        }

        return pos;
    }
    public int groen(int id){
        String naam = "";
        int punten = -1;
        int pos = -1;

        String [] klassement = getTable_3_col_5(id).split(",");

        for (int i = 0 ; i < klassement.length ; i ++){
            String [] cijfer = klassement[i].split("=");
            if (Integer.parseInt(cijfer[1]) > punten){

                punten = Integer.parseInt(cijfer[1]);
                naam = cijfer[0];
                pos = i;

            }
        }

        return pos;
    }
    public int geel(int id){
        String naam = "";
        int punten = -1;
        int pos = -1;

        String [] klassement = getTable_3_col_6(id).split(",");

        for (int i = 0 ; i < klassement.length ; i ++){
            String [] cijfer = klassement[i].split("=");
            if (Integer.parseInt(cijfer[1]) > punten){

                punten = Integer.parseInt(cijfer[1]);
                naam = cijfer[0];
                pos = i;

            }
        }

        return pos;
    }

    //table 4
    public int IDMAKER_TABLE_4(){
        int uit = -1;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from " + DATABASE_table_4, null
        );
        if (cursor.getCount() == 0) {
            uit = 0;
        } else {
            Cursor cursor1 =
                    sqLiteDatabase.rawQuery("select max(" + Table_4_col_0 + " ) from " + DATABASE_table_4 + "", null);
            StringBuffer stringBuffer = new StringBuffer();
            if (cursor1.moveToFirst()) {
                stringBuffer.append(cursor1.getString(0));
                uit = Integer.parseInt(stringBuffer.toString()) + 1;
            }
        }
        return uit;
    }
    public void addToTabel4(String s1,int i1) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Table_4_col_0, IDMAKER_TABLE_4());
        contentValues.put(Table_4_col_1, datum_maker());
        contentValues.put(Table_4_col_2, s1);
        contentValues.put(Table_4_col_3, i1);

        sqLiteDatabase.insert(DATABASE_table_4, null, contentValues);
    }
    public int length_table_4(){
        int uit = 0;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from " + DATABASE_table_4, null
        );

        uit = cursor.getCount();
        return uit;
    }
    public String lastStatus_table_4(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_4_col_2 + " from " + DATABASE_table_4 + "", null);

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
    public int getTable_4_col_3(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =
                sqLiteDatabase.rawQuery("select " + Table_4_col_3 + " from " + DATABASE_table_4 + "", null);

        int uit = -1;
        for (int i = 0; i <= cursor.getCount(); i++) {
            if (cursor.moveToPosition(i)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cursor.getString(0));
                uit = Integer.parseInt(stringBuffer.toString());
            }
        }
        return uit;
    }
    public String datum_maker(){
        String uit = "";
        uit += Calendar.getInstance().getTime().toString();
        System.out.println(uit);
        return uit;
    }

}