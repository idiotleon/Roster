package com.leontheprofessional.roster.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Leon on 7/6/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        sqLiteDatabase.execSQL(DBContract.PLAYERS_LIST_TABLE_CREATION_QUERY);
        sqLiteDatabase.execSQL(DBContract.PLAYERS_WAITING_LIST_TABLE_CREATION_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBContract.PLAYERS_LIST_TABLE_DROP_QUERY);
        db.execSQL(DBContract.PLAYERS_WAITING_LIST_TABLE_DROP_QUERY);
        onCreate(db);
    }
}
