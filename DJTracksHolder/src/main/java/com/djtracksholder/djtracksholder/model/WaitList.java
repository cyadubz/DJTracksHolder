package com.djtracksholder.djtracksholder.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Вадим on 21.08.2014.
 */
@DatabaseTable(tableName = "waitlist")
public class WaitList {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField(foreign = true, canBeNull = false)
    private Track track;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
