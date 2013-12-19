package com.djtracksholder.djtracksholder;

import android.content.Context;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Вадим on 06.12.13.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String TRACK_TABLE_NAME = "track";
    private static final String AUTHOR_TABLE_NAME = "author";
    private static final String HOLDER_TABLE_NAME = "holder";

    public static final String TRACK_TRACKID = "trackid";
    public static final String TRACK_TITLE = "title";
    public static final String TRACK_AUTHORID = "authorid";

    public static final String AUTHOR_AUTHORID = "authorid";
    public static final String AUTHOR_NAME = "name";

    public static final String HOLDER_ID = "id";
    public static final String HOLDER_TRACKID = "trackid";
    public static final String HOLDER_CDNUMBER = "cdnumber";
    public static final String HOLDER_TRACKNUMBER = "tracknumber";

    private static final String TRACK_TABLE_CREATE = "create table " + TRACK_TABLE_NAME + " (" +
            "trackid integer primary key autoincrement, " +
            "title text, " +
            "authorid integer);";

    private static final String AUTHOR_TABLE_CREATE = "create table " + AUTHOR_TABLE_NAME + " (" +
            "authorid integer primary key autoincrement, " +
            "name text" + ");";

    private static final String HOLDER_TABLE_CREATE = "create table " + HOLDER_TABLE_NAME + " (" +
            "id integer primary key autoincrement, " +
            "trackid integer, " +
            "cdnumber integer, " +
            "tracknumber integer" + ");";


    public DBHelper(Context context) {
        super(context, "DJHolder", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TRACK_TABLE_CREATE);
        sqLiteDatabase.execSQL(AUTHOR_TABLE_CREATE);
        sqLiteDatabase.execSQL(HOLDER_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
