package com.flobamora.flobamora.Tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Destination_User.db";
    public static final String TABLE_NAME = "Destination_User_Table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Place_Name";
    public static final String COL_3 = "Place_Image";
    public static final String COL_4 = "Place_Desc";

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Place_Name TEXT, Place_Image TEXT, Place_Desc TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean insertData(String Place_Name, String Place_Image, String Place_Desc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, Place_Name);
        contentValues.put(COL_3, Place_Image);
        contentValues.put(COL_4, Place_Desc);

        long result = db.insert(TABLE_NAME,null,contentValues);
        db.close();
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + TABLE_NAME,null);
        return res;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_NAME,"ID=?",new String[]{id});
        return i;
    }

}
