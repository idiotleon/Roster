package com.leontheprofessional.roster.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Leon on 7/6/2016.
 */
public class PlayersContentProvider extends ContentProvider {
    public static final String PROVIDER_NAME = "com.leontheprofessional.roster.provider";
    public static final String PLAYER_LIST_URL = "content://" + PROVIDER_NAME + "/lists";
    public static final String PLAYER_WAITING_LIST_URL = "content://" + PROVIDER_NAME + "/waiting_lists";
    public static final Uri PLAYER_CONTENT_URI = Uri.parse(PLAYER_LIST_URL);
    public static final Uri PLAYER_WAITING_LIST_CONTENT_URI = Uri.parse(PLAYER_WAITING_LIST_URL);
    public static final String[] PROJECTION_FOR_ALL = {DBContract.COLUMN_PLAYER_ID, DBContract.COLUMN_PLAYER_UUID, DBContract.COLUMN_PLAYER_NAME};

    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static final int PLAYERS_LIST = 0;
    public static final int PLAYER_LIST = 1;
    public static final int PLAYERS_WAITING_LIST = 2;
    public static final int PLAYER_WAITING_LIST = 3;

    public static final String PLAYERS_LIST_TYPE = "vnd.android.cursor.dir/vnd.leontheprofessional.players";
    public static final String PLAYER_LIST_TYPE = "vnd.android.cursor.item/vnd.leontheprofessional.players";
    public static final String PLAYERS_WAITING_LIST_TYPE = "vnd.android.cursor.dir/vnd.leontheprofessional.waitinglist.players";
    public static final String PLAYER_WAITING_LIST_TYPE = "vnd.android.cursor.item/vnd.leontheprofessional.waitinglist.players";

    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "list", PLAYERS_LIST);
        uriMatcher.addURI(PROVIDER_NAME, "list/#", PLAYER_LIST);
        uriMatcher.addURI(PROVIDER_NAME, "waiting_list", PLAYERS_WAITING_LIST);
        uriMatcher.addURI(PROVIDER_NAME, "waiting_list/#", PLAYER_WAITING_LIST);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext());
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return (sqLiteDatabase == null) ? false : true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (uriMatcher.match(uri)) {
            case PLAYERS_LIST:
                sqLiteQueryBuilder.setTables(DBContract.TABLE_PLAYER_LIST);
                return sqLiteQueryBuilder.query(sqLiteDatabase, PROJECTION_FOR_ALL, null, null, null, null, null);
            case PLAYER_LIST:
                sqLiteQueryBuilder.setTables(DBContract.TABLE_PLAYER_LIST);
                selectionArgs[0] = uri.getPathSegments().get(1);
                return sqLiteQueryBuilder.query(sqLiteDatabase, PROJECTION_FOR_ALL, DBContract.COLUMN_PLAYER_ID, selectionArgs, null, null, null);
            case PLAYERS_WAITING_LIST:
                sqLiteQueryBuilder.setTables(DBContract.TABLE_PLAYER_WAITING_LIST);
                return sqLiteQueryBuilder.query(sqLiteDatabase, PROJECTION_FOR_ALL, null, null, null, null, null);
            case PLAYER_WAITING_LIST:
                sqLiteQueryBuilder.setTables(DBContract.TABLE_PLAYER_WAITING_LIST);
                selectionArgs[0] = uri.getPathSegments().get(1);
                return sqLiteQueryBuilder.query(sqLiteDatabase, PROJECTION_FOR_ALL, DBContract.COLUMN_PLAYER_ID, selectionArgs, null, null, null);
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case PLAYERS_LIST:
                return PLAYERS_LIST_TYPE;
            case PLAYER_LIST:
                return PLAYER_LIST_TYPE;
            case PLAYERS_WAITING_LIST:
                return PLAYERS_WAITING_LIST_TYPE;
            case PLAYER_WAITING_LIST:
                return PLAYER_WAITING_LIST_TYPE;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long insertedRowNumber = 0L;
        Uri _uri = null;
        switch (uriMatcher.match(uri)) {
            case PLAYERS_LIST:
                insertedRowNumber = sqLiteDatabase.insert(DBContract.TABLE_PLAYER_LIST, null, values);
                if (insertedRowNumber > 0) {
                    _uri = ContentUris.withAppendedId(PLAYER_CONTENT_URI, insertedRowNumber);
                    getContext().getContentResolver().notifyChange(_uri, null);
                    return _uri;
                }
            case PLAYERS_WAITING_LIST:
                insertedRowNumber = sqLiteDatabase.insert(DBContract.TABLE_PLAYER_WAITING_LIST, null, values);
                if (insertedRowNumber > 0) {
                    _uri = ContentUris.withAppendedId(PLAYER_WAITING_LIST_CONTENT_URI, insertedRowNumber);
                    getContext().getContentResolver().notifyChange(_uri, null);
                    return _uri;
                }
            default:
                throw new SQLException("Failed to add a record info: " + _uri);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
