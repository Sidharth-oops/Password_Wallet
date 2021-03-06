package com.anand.android.passwordwallet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EntryHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SyncToDrive" ;
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_ENTRIES = "entries";
    private static final String ENTRIES_ID = "id";
    private static final String ENTRIES_NAME = "name";
    private static final String ENTRIES_USER = "username";
    private static final String ENTRIES_PASSWORD = "password";
    private static final String TAG = "EntryHelper";
    private final Context context;

    public EntryHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_WEBSITES = "CREATE TABLE " + TABLE_ENTRIES + "("+ ENTRIES_ID +" INTEGER PRIMARY KEY, "+
        ENTRIES_NAME + " TEXT, "+ ENTRIES_USER + " TEXT, "+ ENTRIES_PASSWORD + " TEXT);";
        sqLiteDatabase.execSQL(CREATE_TABLE_WEBSITES);
        Log.i(TAG, "onCreate: TABLE CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists TABLE_ENTRIES");
    }
}
