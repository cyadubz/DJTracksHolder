package com.djtracksholder.djtracksholder.utils;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.TrackInfo;

import java.util.Comparator;

/**
 * Created by Vadym_Vykhrystiuk on 12/19/13.
 */
public class CompByAuthor implements Comparator<TrackInfo> {

    @Override
    public int compare(TrackInfo track, TrackInfo track2) {
        String str1 = track.getAuthorName();
        String str2 = track2.getAuthorName();
        return str1.compareTo(str2);
    }
}
