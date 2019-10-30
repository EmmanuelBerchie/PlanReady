package com.example.berchie.planready;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class db_create extends SQLiteOpenHelper {
    public db_create(Context context)
    {
        super(context, "MyData.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db)
    {
        String query = String.format("CREATE TABLE %s ("
                + "%s INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "%s TEXT, "
                + "%s INTEGER, "
                + "%s TEXT, "
                + "%s TEXT, "
                + "%s INTEGER, "
                + "%s TEXT );", "myTable", "_id", "plan", "studytime", "dayOfWeek", "insertDay", "totalDay", "alarmTime");
        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if(oldVersion!=2)
        {
            onCreate(db);
        }
    }
}
