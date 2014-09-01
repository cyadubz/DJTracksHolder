package com.djtracksholder.djtracksholder.com.djtracksholder.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.djtracksholder.djtracksholder.interfaces.TrackCreator;
import com.djtracksholder.djtracksholder.model.Holder;

/**
 * Created by Vadym_Vykhrystiuk on 12/6/13.
 */
public class TrackInfo<T> extends AbstractItem implements Parcelable {

    private String authorName;
    private String trackName;
    private int cdNumber;
    private int trackNumber;
    private TrackCreator trackCreator;
    private long extId;

    public TrackInfo() {

    }

    public TrackInfo(T object) {
        if (object instanceof Holder) {
            this.trackCreator = new TrackInfoFromDB(new Holder());
        }
        else {
            this.trackCreator = new TrackInfoFromDB(new Holder());
        }

        this.trackCreator.createTrack(object);
    }

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

    public long getExtId() {
        return extId;
    }

    public void setExtId(long extId) {
        this.extId = extId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.trackName);
        dest.writeString(this.authorName);
        dest.writeInt(this.cdNumber);
        dest.writeInt(this.trackNumber);
        dest.writeLong(this.getId());
        dest.writeLong(this.getExtId());
    }

    private TrackInfo(Parcel in) {
        this.trackName = in.readString();
        this.authorName = in.readString();
        this.cdNumber = in.readInt();
        this.trackNumber = in.readInt();
        this.setId(in.readLong());
        this.setExtId(in.readLong());
    }

    public static Creator<TrackInfo> CREATOR = new Creator<TrackInfo>() {
        @Override
        public TrackInfo createFromParcel(Parcel source) {
            return new TrackInfo(source);
        }

        @Override
        public TrackInfo[] newArray(int size) {
            return new TrackInfo[size];
        }
    };

    public class TrackInfoFromDB implements TrackCreator<Holder> {

        Holder holder;

        public TrackInfoFromDB(Holder holder) {
            this.holder = holder;
        }

        @Override
        public void createTrack(Holder holder) {
            setTrackNumber(holder.getTrackNumber());
            setAuthorName(holder.getTrack().getAuthor().getName());
            setCdNumber(holder.getCdnumber());
            setTrackName(holder.getTrack().getName());
            setId(holder.getTrack().getId());
        }
    }
}
