package com.djtracksholder.djtracksholder;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadym_Vykhrystiuk on 12/6/13.
 */
public class BrowseTracks extends ListFragment {

    private List<Track> tracks;

    public BrowseTracks() {
        List<Track> tracks = new ArrayList<Track>();
        for (int i = 0; i < 10; i++) {
            Track track = new Track();
            track.setAuthorName("Author" + i);
            track.setTrackName("Track" + i);
            track.setRemixerName("Benga");
            track.setCdNumber(i);
            track.setTrackNumber(i);
            tracks.add(track);
        }
        this.tracks = tracks;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListAdapter listAdapter = new BrowseTracksAdapter(getActivity(), R.layout.track_row, tracks);

        setListAdapter(listAdapter);
    }
}