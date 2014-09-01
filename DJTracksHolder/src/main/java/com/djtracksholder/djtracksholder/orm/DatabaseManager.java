package com.djtracksholder.djtracksholder.orm;

import com.djtracksholder.djtracksholder.TheApplication;
import com.djtracksholder.djtracksholder.model.Author;
import com.djtracksholder.djtracksholder.model.Holder;
import com.djtracksholder.djtracksholder.model.Track;
import com.djtracksholder.djtracksholder.model.WaitList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 21.08.2014.
 */
public class DatabaseManager {
    static private DatabaseManager instance;

    private DatabaseHelper helper;

    public DatabaseManager() {
    }

    static public DatabaseManager getInstance() {
        if (null == instance) {
            instance = new DatabaseManager();
            instance.helper = new DatabaseHelper(TheApplication.getAppContext());
        }
        return instance;
    }

    public void createOrUpdateAuthor(Author author) {
        try {
            helper.getAuthorsListDao().createOrUpdate(author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Author getAuthorById(long id) {
        Author author = null;
        try {
            author = helper.getAuthorsListDao().queryBuilder().where().eq("id", id).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    public Author getAuthorByName(String name) {
        Author author = null;
        try {
            author = helper.getAuthorsListDao().queryBuilder().where().eq("name", name).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    public void createOrUpdateTrack(Track track) {
        try {
            helper.getTracksListDao().createOrUpdate(track);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Track getTrackById(long id) {
        Track track = null;
        try {
            track = helper.getTracksListDao().queryBuilder().where().eq("id", id).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return track;
    }

    public Track getTrackByName(String name) {
        Track track = null;
        try {
            track = helper.getTracksListDao().queryBuilder().where().eq("name", name).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return track;
    }

    public void createOrUpdateHolder(Holder holder) {
        try {
            helper.getHoldersListDao().createOrUpdate(holder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createOrUpdateWaitList(WaitList waitList) {
        try {
            helper.getWaitListDao().createOrUpdate(waitList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromWaitListById(long id) {
        try {
            helper.getWaitListDao().deleteById((int) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Holder> getTracksFromHolder() {
        ArrayList<Holder> tracks = new ArrayList<Holder>();
        try {
            tracks.addAll(helper.getHoldersListDao().queryForAll());
            for (Holder track : tracks) {
                helper.getTracksListDao().refresh(track.getTrack());
                helper.getAuthorsListDao().refresh(track.getTrack().getAuthor());
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return tracks;
    }

    public ArrayList<Holder> getTracksFromHolder(int cdNumber) {
        ArrayList<Holder> tracks = new ArrayList<Holder>();
        try {
            tracks.addAll(helper.getHoldersListDao().queryBuilder().where().eq("cdnumber", cdNumber).query());
            for (Holder track : tracks) {
                helper.getTracksListDao().refresh(track.getTrack());
                helper.getAuthorsListDao().refresh(track.getTrack().getAuthor());
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return tracks;
    }

    public ArrayList<Holder> getTracksFromHolderById(long id) {
        ArrayList<Holder> tracks = new ArrayList<Holder>();
        try {
            tracks.addAll(helper.getHoldersListDao().queryBuilder().where().eq("track_id", id).query());
            for (Holder track : tracks) {
                helper.getTracksListDao().refresh(track.getTrack());
                helper.getAuthorsListDao().refresh(track.getTrack().getAuthor());
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return tracks;
    }

    public ArrayList<WaitList> getTracksFromWaitList() {
        ArrayList<WaitList> tracks = new ArrayList<WaitList>();
        try {
            tracks.addAll(helper.getWaitListDao().queryForAll());
            for (WaitList track : tracks) {
                helper.getTracksListDao().refresh(track.getTrack());
                helper.getAuthorsListDao().refresh(track.getTrack().getAuthor());
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return tracks;
    }

    public void deleteTracksFromCd(int cd) {
        try {
            List<Holder> holder = helper.getHoldersListDao().queryBuilder().where().eq("cdnumber", cd).query();
            helper.getHoldersListDao().delete(holder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getHolderCdCount() {
        int cdCount = 0;
        try {
            cdCount = helper.getHoldersListDao().queryBuilder().orderBy("cdnumber", false).limit(1L).queryForFirst().getCdnumber();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return cdCount;
    }

    public void clearAllTables() {
        helper.clearTableAllTables();
    }
}
