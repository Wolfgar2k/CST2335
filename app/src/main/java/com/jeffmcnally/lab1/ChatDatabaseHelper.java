package com.jeffmcnally.lab1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jeff McNally on 2016-11-24.
 */

public class ChatDatabaseHelper extends SQLiteOpenHelper {
    protected static final String ACTIVITY_NAME = "ChatDatabaseHelper";
    protected static final String DATABASE_NAME = "chtDatabase";
    protected static int VERSION_NUM = 2;
    protected static final String KEY_ID = "Chat_ID";
    protected static final String KEY_MESSAGE = "Text_Messages";
    protected static final String TABLE_NAME = "Chat_Messages";



    public ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +KEY_ID +" INTEGER PRIMARY KEY, " +KEY_MESSAGE+ " TEXT);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }

    public void insertData(String msg){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_MESSAGE, msg);
        long insertResult = db.insert(TABLE_NAME, null, contentValues);
    }

}
