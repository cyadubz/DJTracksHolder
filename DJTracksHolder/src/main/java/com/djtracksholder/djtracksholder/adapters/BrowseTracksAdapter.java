package com.djtracksholder.djtracksholder.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.djtracksholder.djtracksholder.R;
import com.djtracksholder.djtracksholder.com.djtracksholder.beans.TrackInfo;
import com.djtracksholder.djtracksholder.utils.TypefaceFactory;

import java.util.List;

/**
 * Created by Вадим on 21.08.2014.
 */
public class BrowseTracksAdapter extends AbstractAdapter<TrackInfo, BrowseTracksAdapter.TracksViewHolder> {
    private Typeface typeface;

    public BrowseTracksAdapter(Context context, List<TrackInfo> items) {
        super(context, R.layout.track_row, items);
        typeface = TypefaceFactory.getRalewayRegular();
    }

    @Override
    protected void bindView(TracksViewHolder viewHolder, TrackInfo item) {
        viewHolder.authorName.setText(item.getAuthorName());
        viewHolder.trackTitle.setText(item.getTrackName());
        viewHolder.trackNumber.setText(String.valueOf(item.getTrackNumber()));

        viewHolder.authorName.setTypeface(typeface);
        viewHolder.trackTitle.setTypeface(typeface);
        viewHolder.trackNumber.setTypeface(typeface);
    }

    @Override
    protected TracksViewHolder createHolder(View view) {
        return new TracksViewHolder(view);
    }

    public static class TracksViewHolder extends AbstractAdapter.ViewHolder {
        private TextView authorName;
        private TextView trackTitle;
        private TextView trackNumber;

        public TracksViewHolder(View view) {
            super(view);
            authorName = get(R.id.authorName_TrackRow);
            trackTitle = get(R.id.trackTitle_TrackRow);
            trackNumber = get(R.id.trackNumber_TrackRow);
        }
    }
}
