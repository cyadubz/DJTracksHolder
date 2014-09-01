package com.djtracksholder.djtracksholder.adapters;

import android.content.Context;
import android.view.View;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.djtracksholder.djtracksholder.R;
import com.djtracksholder.djtracksholder.com.djtracksholder.beans.TrackInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 21.08.2014.
 */
public class FilterAdapter extends AbstractAdapter<TrackInfo, FilterAdapter.FilterViewHolder> implements Filterable {

    private TracksFilter filter;
    private List<TrackInfo> filterTracks;

    public FilterAdapter(Context context, List<TrackInfo> items) {
        super(context, R.layout.track_row_listing, items);
        filterTracks = items;
    }

    @Override
    public void setData(List<TrackInfo> items) {
        super.setData(items);
        filterTracks = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return filterTracks.size();
    }

    @Override
    public TrackInfo getItem(int position) {
        return filterTracks.get(position);
    }

    @Override
    protected void bindView(FilterViewHolder viewHolder, TrackInfo item) {
        viewHolder.authorName.setText(item.getAuthorName());
        viewHolder.trackTitle.setText(item.getTrackName());
        viewHolder.trackNumber.setText(String.valueOf(item.getTrackNumber()));
        viewHolder.cdNumber.setText(String.valueOf(item.getCdNumber()));
    }

    @Override
    protected FilterViewHolder createHolder(View view) {
        return new FilterViewHolder(view);
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new TracksFilter();
        }
        return filter;
    }

    public static class FilterViewHolder extends AbstractAdapter.ViewHolder {
        private TextView authorName;
        private TextView trackTitle;
        private TextView trackNumber;
        private TextView cdNumber;

        public FilterViewHolder(View view) {
            super(view);
            authorName = get(R.id.authorName_WaitList);
            trackTitle = get(R.id.trackTitle_WaitList);
            trackNumber = get(R.id.trackNumber_WaitList);
            cdNumber = get(R.id.cdNumber_WaitList);
        }
    }

    private class TracksFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();

            if (constraint != null && constraint.toString().length() > 0) {
                ArrayList<TrackInfo> filteredList = new ArrayList<TrackInfo>();
                for (TrackInfo trackInfo : items) {
                    if (trackInfo.getTrackName().toLowerCase().contains(constraint)
                            || trackInfo.getAuthorName().toLowerCase().contains(constraint)) {
                        filteredList.add(trackInfo);
                    }
                }
                result.count = filteredList.size();
                result.values = filteredList;
            } else {
                if (items != null) {
                    result.count = items.size();
                    result.values = items;
                    filterTracks = items;
                } else {
                    result.count = getData().size();
                    result.values = getData();
                }
            }
            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filterTracks = (ArrayList<TrackInfo>) results.values;
            notifyDataSetChanged();
        }
    }
}
