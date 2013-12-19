package com.djtracksholder.djtracksholder.com.djtracksholder.utils;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.Track;

import java.util.Comparator;

/**
 * Created by Vadym_Vykhrystiuk on 12/19/13.
 */
public class CompByAuthor implements Comparator<Track> {

    @Override
    public int compare(Track track, Track track2) {
        String str1 = track.getAuthorName();
        String str2 = track.getAuthorName();
        return str1.compareTo(str2);
    }
}
