package com.djtracksholder.djtracksholder;

import android.content.SharedPreferences;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.TrackInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadym_Vykhrystiuk on 12/18/13.
 */
public class Parser {

    public static List<TrackInfo> parseThisShit(String data) {
        SharedPreferences settings = TheApplication.getAppContext().getSharedPreferences("Main", 0);

        String[] result = data.split(";");
        int currentCd = 0;
        List<TrackInfo> tracks = new ArrayList<TrackInfo>();
        for (String row : result) {
            if (row.contains("[CD]")) {
                String[] cdRow = row.split(":");
                currentCd = Integer.parseInt(cdRow[1]);
                continue;
            }

            if (currentCd == 0) {
                break;
            }

            TrackInfo track = new TrackInfo();
            track.setCdNumber(currentCd);
            String[] trackRow = row.split(":");
            track.setTrackNumber(Integer.parseInt(trackRow[0].trim()));
            String trackDetails[] = trackRow[1].split("-");
            track.setAuthorName(trackDetails[0].trim());
            String title = trackDetails[1].trim();
            track.setTrackName(title);
            tracks.add(track);
        }

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("CDCount", tracks.get(tracks.size() - 1).getCdNumber());
        // Commit the edits!
        editor.commit();

        // MockData.cdCount = tracks.get(tracks.size() - 1).getCdNumber();

        return tracks;
    }
}
