package com.djtracksholder.djtracksholder;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 07.12.13.
 */
public class HolderProvider {
    private DBHelper dbOpen;
    private SQLiteDatabase db;

    public HolderProvider(DBHelper dbOpen) {
        this.dbOpen = dbOpen;
    }

    public List<Track> getAllTracks() {
        List<Track> tracks = new ArrayList<Track>();
        String query = "select author.name, " +
                "track.title, " +
                "holder.cdnumber, " +
                "holder.tracknumber " +
                "FROM " +
                "author, track, holder " +
                "WHERE " +
                "author.authorId = track.authorId AND " +
                "holder.trackid = track.trackid;";

        db = getDbOpen().getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int nameIndex = cursor.getColumnIndex("name");
            int titleIndex = cursor.getColumnIndex("title");
            int cdNumberIndex = cursor.getColumnIndex("cdnumber");
            int trackNumberIndex = cursor.getColumnIndex("tracknumber");

            Track track = new Track();
            track.setAuthorName(cursor.getString(nameIndex));
            track.setTrackName(cursor.getString(titleIndex));
            track.setCdNumber(cursor.getInt(cdNumberIndex));
            track.setTrackNumber(cursor.getInt(trackNumberIndex));
            tracks.add(track);
        }
        db.close();
        return tracks;
    }

    public void addTrackToHolder(String authorName, String trackName, String remixAuthor, int cd, int n) {
        int authorId = getAuthorId(authorName);
        if (authorId == 0) {
            addAuthor(authorName);
            authorId = getAuthorId(authorName);
        }
        db.close();

        int trackId = getTrackId(trackName, authorId);
        if (trackId == 0) {
            addTrack(trackName, authorId);
            trackId = getTrackId(trackName, authorId);
        }
        db.close();

        addTrackToHolder(cd, n, trackId);
        db.close();
    }

    public void addTrackToHolder(int cd, int n, int trackId) {
        db = getDbOpen().getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cdnumber", cd);
        cv.put("tracknumber", n);
        cv.put("trackId", trackId);
        db.insert("holder", null, cv);
        db.close();
    }

    private void addTrack(String trackName, int authorId) {
        db = getDbOpen().getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", trackName);
        cv.put("authorId", authorId);
        db.insert("track", null, cv);
        db.close();
    }

    private int getTrackId(String trackName, int authorId) {
        db = getDbOpen().getReadableDatabase();
        String query = "select trackId from track where title ='" + trackName +
                "' " +
                "and authorId ='" + authorId + "';";

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) return cursor.getInt(0);
        return 0;
    }

    private void addAuthor(String authorName) {
        db = getDbOpen().getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", authorName);
        db.insert("author", null, cv);
        db.close();
    }

    public DBHelper getDbOpen() {
        return dbOpen;
    }

    public void setDbOpen(DBHelper dbOpen) {
        this.dbOpen = dbOpen;
    }

    private int getAuthorId(String authorName) {
        db = getDbOpen().getReadableDatabase();
        String query = "select authorId from author where name='" + authorName +
                "';";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) return cursor.getInt(0);
        return 0;
    }
}
