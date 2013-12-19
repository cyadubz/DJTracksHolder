package com.djtracksholder.djtracksholder.com.djtracksholder.beans;

/**
 * Created by Vadym_Vykhrystiuk on 12/6/13.
 */
public class Track implements Comparable<Track> {

    private String authorName;
    private String trackName;
    private int cdNumber;
    private int trackNumber;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getCdNumber() {
        return cdNumber;
    }

    public void setCdNumber(int cdNumber) {
        this.cdNumber = cdNumber;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    @Override
    public int compareTo(Track track) {
        return this.getAuthorName().compareTo(track.getAuthorName());
    }
}
