package com.leontheprofessional.roster.database;

/**
 * Created by Leon on 7/6/2016.
 */
public class DBContract {
    public static final String DATABASE_NAME = "players_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_PLAYER_LIST = "players_list";
    public static final String TABLE_PLAYER_WAITING_LIST = "players_waiting_list";
    public static final String TYPE_INT = " INTEGER ";
    public static final String TYPE_TEXT = " TEXT ";
    public static final String TYPE_BLOB = " BLOB ";
    public static final String PRIMARY_KEY = " PRIMARY KEY ";
    public static final String COMMA_SEPARATOR = ", ";
    public static final String NOT_NULL = " NOT NULL ";

    public static final String COLUMN_PLAYER_ID = "_id";
    public static final String COLUMN_PLAYER_NAME = "player_name";
    public static final String COLUMN_PLAYER_UUID = "player_uuid";
    public static final String PLAYERS_LIST_TABLE_CREATION_QUERY = "CREATE TABLE " + TABLE_PLAYER_LIST +
            "( " + COLUMN_PLAYER_ID + TYPE_INT + PRIMARY_KEY + COMMA_SEPARATOR +
            COLUMN_PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
            COLUMN_PLAYER_NAME + TYPE_TEXT + NOT_NULL + ")";
    public static final String PLAYERS_WAITING_LIST_TABLE_CREATION_QUERY = "CREATE TABLE " + TABLE_PLAYER_WAITING_LIST +
            "( " + COLUMN_PLAYER_ID + TYPE_INT + PRIMARY_KEY + COMMA_SEPARATOR +
            COLUMN_PLAYER_UUID + TYPE_BLOB + COMMA_SEPARATOR +
            COLUMN_PLAYER_NAME + TYPE_TEXT + NOT_NULL + ")";
    public static final String PLAYERS_LIST_TABLE_DROP_QUERY = "DROP TABLE " + TABLE_PLAYER_LIST + " IF EXISTS";
    public static final String PLAYERS_WAITING_LIST_TABLE_DROP_QUERY = "DROP TABLE " + TABLE_PLAYER_WAITING_LIST + " IF EXISTS";
}
