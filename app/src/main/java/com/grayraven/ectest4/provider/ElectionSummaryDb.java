package com.grayraven.ectest4.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

import java.util.ArrayList;

/**
 * Created by Jim on 6/4/2016.
 */
public class ElectionSummaryDb extends SQLiteOpenHelper {

    private static final String TAG = "ElectionSummaryDb";
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "election_summary";
    public static final String TABLE_NAME = "summaries";
    public static final String ELECTION_YEAR = "year";
    public static final String ELECTION_TEXT = "text";

    private SQLiteDatabase db;

    private static final String CREATE_DB_TABLE =
            " CREATE TABLE " + TABLE_NAME +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " year TEXT NOT NULL, " +
                    " text TEXT NOT NULL);";

    public ElectionSummaryDb(Context context) {
        super(context,DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME);
        onCreate(db);

    }

    public boolean insertElection (String year, String text){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ELECTION_YEAR, year);
        contentValues.put(ELECTION_TEXT, text);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public ArrayList<Pair<String,String>> getAll()
    {
        ArrayList<Pair<String,String>> array_list = new ArrayList<Pair<String,String>>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from " + TABLE_NAME, null );
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false){
            String year = cursor.getString(cursor.getColumnIndex(ELECTION_YEAR));
            String text = cursor.getColumnName(cursor.getColumnIndex(ELECTION_TEXT));
            Pair<String,String> pair = new Pair<String,String>(year,text);
            array_list.add(pair);
            cursor.moveToNext();
        }
        return array_list;
    }


    /*public Integer deleteElection (String year)
    {
        // get row id
        String whereClause = ELECTION_YEAR+"=?";
        Cursor cursor = this.getReadableDatabase().query(TABLE_NAME, new String[] { "ROWID", year }, whereClause, null, null, null, null);
        long rowId = cursor.getLong(0);
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,
                "id = ? ",
                new String[] { Integer.toString((int) rowId) });
    }*/
}
