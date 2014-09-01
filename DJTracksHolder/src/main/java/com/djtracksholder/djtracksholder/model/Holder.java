package com.djtracksholder.djtracksholder.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Вадим on 21.08.2014.
 */
@DatabaseTable(tableName = "holder")
public class Holder {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField(foreign = true, canBeNull = false)
    private Track track;
    @DatabaseField
    private int cdnumber;
    @DatabaseField
    private int trackNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCdnumber() {
        return cdnumber;
    }

    public void setCdnumber(int cdnumber) {
        this.cdnumber = cdnumber;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
