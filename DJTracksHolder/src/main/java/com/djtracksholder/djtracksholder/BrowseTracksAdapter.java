package com.djtracksholder.djtracksholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.Track;

import java.util.List;

/**
 * Created by Vadym_Vykhrystiuk on 12/6/13.
 */
public class BrowseTracksAdapter extends ArrayAdapter<Track> {

    private List<Track> tracks;

    public BrowseTracksAdapter(Context context, int resource, List<Track> objects) {
        super(context, resource, objects);
        this.tracks = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.track_row, null);
        }

        Track track = tracks.get(position);

        if (track != null) {

            TextView authorName = (TextView)v.findViewById(R.id.authorName);
            TextView trackTitle = (TextView)v.findViewById(R.id.trackTitle);
            TextView cdNumber   = (TextView)v.findViewById(R.id.cdNumber);
            TextView trackNumber= (TextView)v.findViewById(R.id.trackNumber);

            authorName.setText(track.getAuthorName());
            trackTitle.setText(track.getTrackName());
            cdNumber.setText(String.valueOf(track.getCdNumber()));
            trackNumber.setText(String.valueOf(track.getTrackNumber()));
        }

        return v;
    }

}
