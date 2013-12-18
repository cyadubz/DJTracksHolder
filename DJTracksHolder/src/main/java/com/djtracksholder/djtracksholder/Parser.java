package com.djtracksholder.djtracksholder;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadym_Vykhrystiuk on 12/18/13.
 */
public class Parser {

    public static List<Track> parseThisShit(String data) {
        String[] result = data.split(";");
        int currentCd = 0;
        List<Track> tracks = new ArrayList<Track>();
        for (String row : result) {
            if (row.contains("[CD]")) {
                String[] cdRow = row.split(":");
                currentCd = Integer.parseInt(cdRow[1]);
                continue;
            }

            if (currentCd == 0) {
                break;
            }

            Track track = new Track();
            track.setCdNumber(currentCd);
            String[] trackRow = row.split(":");
            track.setTrackNumber(Integer.parseInt(trackRow[0].trim()));
            String trackDetails[] = trackRow[1].split("-");
            track.setAuthorName(trackDetails[0].trim());
            String title = trackDetails[1].trim();
            track.setTrackName(title);
            tracks.add(track);
        }

        return tracks;
    }
}
