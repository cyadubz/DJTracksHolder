package com.djtracksholder.djtracksholder.orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.djtracksholder.djtracksholder.model.Author;
import com.djtracksholder.djtracksholder.model.Holder;
import com.djtracksholder.djtracksholder.model.Track;
import com.djtracksholder.djtracksholder.model.WaitList;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.File;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by Вадим on 21.08.2014.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "DJHolder.db";

    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // the DAO object we use to access the SimpleData table

    private Dao<Track, Integer> track = null;
    private Dao<Author, Integer> author = null;
    private Dao<Holder, Integer> holder = null;
    private Dao<WaitList, Integer> waitList = null;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Track.class);
            TableUtils.createTable(connectionSource, Author.class);
            TableUtils.createTable(connectionSource, Holder.class);
            TableUtils.createTable(connectionSource, WaitList.class);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        try {
            TableUtils.dropTable(connectionSource, Track.class, true);
            TableUtils.dropTable(connectionSource, Author.class, true);
            TableUtils.dropTable(connectionSource, Holder.class, true);
            TableUtils.dropTable(connectionSource, WaitList.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Dao<Track, Integer> getTracksListDao() {
        if (null == track) {
            try {
                track = getDao(Track.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return track;
    }

    public Dao<Author, Integer> getAuthorsListDao() {
        if (null == author) {
            try {
                author = getDao(Author.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return author;
    }

    public Dao<Holder, Integer> getHoldersListDao() {
        if (null == holder) {
            try {
                holder = getDao(Holder.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return holder;
    }

    public Dao<WaitList, Integer> getWaitListDao() {
        if (null == waitList) {
            try {
                waitList = getDao(WaitList.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return waitList;
    }

    public void clearTable(Class<?> c) {
        try {
            TableUtils.clearTable(getConnectionSource(), c);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public void clearTableAllTables() {
        clearTable(Author.class);
        clearTable(Track.class);
        clearTable(Holder.class);
        clearTable(WaitList.class);
    }
}
