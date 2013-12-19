package com.djtracksholder.djtracksholder;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by Vadym_Vykhrystiuk on 12/19/13.
 */
public class MainCursorAdapter extends SimpleCursorAdapter {

    private String[] from = {DBHelper.AUTHOR_NAME, DBHelper.TRACK_TITLE, DBHelper.HOLDER_CDNUMBER, DBHelper.HOLDER_TRACKNUMBER};

    public MainCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (getCursor().moveToPosition(position)) {
            View view = convertView;

            TextView authorName = (TextView)view.findViewById(R.id.authorName);
            TextView trackTitle = (TextView)view.findViewById(R.id.trackTitle);
            TextView cdNumber   = (TextView)view.findViewById(R.id.cdNumber);
            TextView trackNumber= (TextView)view.findViewById(R.id.trackNumber);

            int nameIndex = getCursor().getColumnIndex(from[0]);
            int titleIndex = getCursor().getColumnIndex(from[1]);
            int cdNumberIndex = getCursor().getColumnIndex(from[2]);
            int trackNumberIndex = getCursor().getColumnIndex(from[3]);

            authorName.setText(getCursor().getString(nameIndex));
            trackTitle.setText(getCursor().getString(titleIndex));
            cdNumber.setText(String.valueOf(getCursor().getString(cdNumberIndex)));
            trackNumber.setText(String.valueOf(getCursor().getString(trackNumberIndex)));
            return view;
        }
        return convertView;
    }
}
