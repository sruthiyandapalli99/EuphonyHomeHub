package com.example.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    //public static final String DBNAME = "Login.db";
    //public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context,  "Login.db", null,  2);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
       MyDB.execSQL("Create Table  customers  (_ID INTEGER PRIMARY KEY AUTOINCREMENT,  EMAIL TEXT,  NAME TEXT,  FLATNUMBER INTEGER,  PROFESSION TEXT,  PASSWORD INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists customers");
        onCreate(MyDB);
    }

    public Boolean insertvalues( String emaill, String usernamee, String flatnum, String professionn, String passcode){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues customerdetails = new ContentValues();
        customerdetails.put("EMAIL", emaill);
        customerdetails.put("NAME", usernamee);
        customerdetails.put("FLATNUMBER", flatnum);
        customerdetails.put("PROFESSION", professionn);
        customerdetails.put("PASSWORD", passcode);
        long result =MyDB.insert("customers", null, customerdetails);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkemailid(String entermail){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.query("customers", new String[] {"EMAIL"}, null,null,null,null,null);
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean Checkuemailpassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
       // Cursor cursor = MyDB.rawQuery("Select * from customers ", new String[] {username, password});
        /*if(cursor.getCount()>0)
            return true;
        else
            return  false;*/
        Cursor cursor = MyDB.query("customers", new String[] {"EMAIL", "PASSWORD"}, null,null,null,null,null);
        if(cursor.getCount()>0)
            return true;
        else
            return  false;
    }



}
