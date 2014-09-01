package com.djtracksholder.djtracksholder.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.djtracksholder.djtracksholder.R;
import com.djtracksholder.djtracksholder.com.djtracksholder.beans.TrackInfo;

import java.util.List;

/**
 * Created by Вадим on 21.08.2014.
 */
public class WaitListAdapter extends AbstractAdapter<TrackInfo, WaitListAdapter.WaitListTracksViewHolder> {

    public WaitListAdapter(Context context, List<TrackInfo> items) {
        super(context, R.layout.track_row_listing, items);
    }

    @Override
    protected void bindView(WaitListTracksViewHolder viewHolder, TrackInfo item) {
        viewHolder.authorName.setText(item.getAuthorName());
        viewHolder.trackTitle.setText(item.getTrackName());
        viewHolder.trackNumber.setText(String.valueOf(item.getTrackNumber()));
        viewHolder.cdNumber.setText(String.valueOf(item.getCdNumber()));
    }

    @Override
    protected WaitListTracksViewHolder createHolder(View view) {
        return new WaitListTracksViewHolder(view);
    }

    public static class WaitListTracksViewHolder extends AbstractAdapter.ViewHolder {
        private TextView authorName;
        private TextView trackTitle;
        private TextView trackNumber;
        private TextView cdNumber;

        public WaitListTracksViewHolder(View view) {
            super(view);
            authorName = get(R.id.authorName_WaitList);
            trackTitle = get(R.id.trackTitle_WaitList);
            trackNumber = get(R.id.trackNumber_WaitList);
            cdNumber = get(R.id.cdNumber_WaitList);
        }
    }
}
