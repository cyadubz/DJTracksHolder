package com.djtracksholder.djtracksholder.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.TrackInfo;
import com.djtracksholder.djtracksholder.model.Author;
import com.djtracksholder.djtracksholder.model.Holder;
import com.djtracksholder.djtracksholder.model.Track;
import com.djtracksholder.djtracksholder.model.WaitList;
import com.djtracksholder.djtracksholder.orm.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 07.12.13.
 */
public class HolderProvider {
    private DBHelper dbOpen;
    private SQLiteDatabase db;
    private static HolderProvider instance;
    private DatabaseManager databaseManager;

    private HolderProvider(Context context) {
        this.dbOpen = DBHelper.getInstance(context);
        this.databaseManager = DatabaseManager.getInstance();
    }

    public static HolderProvider getInstance(Context context) {
        if (instance != null) {
            return instance;
        }
        else {
            return new HolderProvider(context);
        }
    }

    public List<TrackInfo> getAllTracks() {
        ArrayList<TrackInfo> tracks = new ArrayList<TrackInfo>();

        ArrayList<Holder> holder = databaseManager.getTracksFromHolder();
        for (Holder track : holder) {
            tracks.add(new TrackInfo(track));
        }

        return tracks;
    }

    public void addToWaitingList(long id) {
        Track track = databaseManager.getTrackById(id);
        WaitList waitList = new WaitList();
        waitList.setTrack(track);
        databaseManager.createOrUpdateWaitList(waitList);
    }

    public void removeTrackFromWaitingList(long id) {
        databaseManager.deleteFromWaitListById(id);
    }

    public ArrayList<TrackInfo> getTracksFromWaitList() {
        ArrayList<TrackInfo> tracks = new ArrayList<TrackInfo>();

        ArrayList<WaitList> waitList = databaseManager.getTracksFromWaitList();
        for (WaitList waitListTrack : waitList) {
            long trackId = waitListTrack.getTrack().getId();
            long waitListId = waitListTrack.getId();
            ArrayList<Holder> holder = databaseManager.getTracksFromHolderById(trackId);

            if (holder.size() > 1) {
                for (Holder track : holder) {
                    TrackInfo trackInfo = new TrackInfo(track);
                    trackInfo.setExtId(waitListId);
                    tracks.add(new TrackInfo(track));
                }
            }
            else {
                if (holder == null) {
                    continue;
                }
                Holder track = holder.get(0);
                TrackInfo trackInfo = new TrackInfo(track);
                trackInfo.setExtId(waitListId);
                tracks.add(trackInfo);
            }
        }

        return tracks;
    }

    public ArrayList<TrackInfo> getTracksFromCD(int cdNumber) {
        ArrayList<TrackInfo> tracks = new ArrayList<TrackInfo>();

        ArrayList<Holder> holder = databaseManager.getTracksFromHolder(cdNumber);
        for (Holder track : holder) {
            tracks.add(new TrackInfo(track));
        }

        return tracks;
    }

    public void addTrackToHolder(String authorName, String trackName, int cd, int n) {

        Author author = databaseManager.getAuthorByName(authorName);

        // Author creation
        if (author == null) {
            author = new Author();
            author.setName(authorName);
        }
        databaseManager.createOrUpdateAuthor(author);

        Track track = databaseManager.getTrackByName(trackName);

        if (track == null || !track.getAuthor().equals(authorName)) {
            track = new Track();
            track.setName(trackName);
            track.setAuthor(author);
        }
        databaseManager.createOrUpdateTrack(track);

        addTrackToHolder(cd, n, track);
    }

    public void addTrackToHolder(TrackInfo track) {
        addTrackToHolder(track.getAuthorName(), track.getTrackName(), track.getCdNumber(), track.getTrackNumber());
    }

    public void addTracksToHolder(List<TrackInfo> tracks, Callbacks callbacks) {
        for (TrackInfo track : tracks) {
            addTrackToHolder(track);
        }
        callbacks.onSuccess();
    }

    public void addTrackToHolder(int cd, int n, Track track) {
        Holder holder = new Holder();
        holder.setCdnumber(cd);
        holder.setTrackNumber(n);
        holder.setTrack(track);
        databaseManager.createOrUpdateHolder(holder);
    }

    public void deleteTracksFromCd(int cd) {
        databaseManager.deleteTracksFromCd(cd);
    }

    public int getCdCount() {
        return databaseManager.getHolderCdCount();
    }

    public DBHelper getDbOpen() {
        return dbOpen;
    }

    public void deleteData() {
        databaseManager.clearAllTables();
    }

    public interface Callbacks {
        public void onSuccess();
    }

    public interface HolderCallback<T> {
        public void onSuccess(T response);
    }

}
