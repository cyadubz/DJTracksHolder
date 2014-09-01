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
public class AddingAdapter extends AbstractAdapter<TrackInfo, AddingAdapter.AddCdHolder> {

    public AddingAdapter(Context context, List<TrackInfo> items) {
        super(context, R.layout.track_item_add, items);
    }

    @Override
    protected void bindView(AddCdHolder viewHolder, TrackInfo item) {
        viewHolder.authorName.setText(item.getAuthorName());
        viewHolder.trackTitle.setText(item.getTrackName());
        viewHolder.trackNumber.setText(String.valueOf(item.getTrackNumber()));
    }

    @Override
    protected AddCdHolder createHolder(View view) {
        return new AddCdHolder(view);
    }

    public static class AddCdHolder extends AbstractAdapter.ViewHolder {
        private TextView authorName;
        private TextView trackTitle;
        private TextView trackNumber;

        public AddCdHolder(View view) {
            super(view);
            authorName = get(R.id.textAuthor_addItem);
            trackTitle = get(R.id.textTrack_addItem);
            trackNumber = get(R.id.textNumber_addItem);
        }
    }
}
