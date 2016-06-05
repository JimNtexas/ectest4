package com.grayraven.ectest4.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

public class ElectionSummaryProvider extends ContentProvider {

    private static final String TAG = "Provider";
    private static final String PROVIDER_NAME = "com.grayraven.provider";
    private static final String URL = "content://" + PROVIDER_NAME + "/summary";
    public static final Uri CONTENT_URI = Uri.parse(URL);
    private SQLiteDatabase db;

    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
            + "/capstone";
    public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
            + "/capstone";



    static final int SUMMARY = 1;
    static final int SUMMARY_ID = 2;

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "summary", SUMMARY);
        uriMatcher.addURI(PROVIDER_NAME, "summary/#", SUMMARY_ID);
    }

    public ElectionSummaryProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        ElectionSummaryDb dbHelper = new ElectionSummaryDb(context);
        db = dbHelper.getWritableDatabase();
        return (db == null) ? false : true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(ElectionSummaryDb.TABLE_NAME);
        int uriType = uriMatcher.match(uri);
        Log.d(TAG, "Uri type: " + uriType);
        switch (uriType) {
            case SUMMARY_ID :
             //   queryBuilder.appendWhere();
        }





        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

