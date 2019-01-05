package net.androidbootcamp.mycruiseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MyDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Company.db";

    public MyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableDefinitions.SQL_CREATE_DEPT);
        db.execSQL(TableDefinitions.SQL_CREATE_EMP);
        db.execSQL(TableDefinitions.SQL_CREATE_ACT);
        Log.d("MyDB","onCreate");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "Updating table from " + oldVersion + " to " + newVersion);
        try {
            //db.execSQL(TableDefinitions.SQL_DELETE_EMP);
            //db.execSQL(TableDefinitions.SQL_DELETE_ACT);
            db.execSQL(TableDefinitions.SQL_DELETE_DEPT);
            Log.d("MyDB","OnUpgrade");
            onCreate(db);
        } catch (Exception exception) {
            Log.e(TAG, "Exception running upgrade script:", exception);
        }

    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("MyDB","onDowngrade");
        onUpgrade(db, oldVersion, newVersion);
    }
}
