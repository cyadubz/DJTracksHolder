package com.djtracksholder.djtracksholder.widget;

import android.content.Context;
import android.database.Cursor;
import android.widget.AlphabetIndexer;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SectionIndexer;
import android.widget.SimpleCursorAdapter;

import com.djtracksholder.djtracksholder.provider.DBHelper;
import com.djtracksholder.djtracksholder.R;

/**
 * Created by Vadym_Vykhrystiuk on 12/19/13.
 */
public class AlphabetCursorAdapter extends SimpleCursorAdapter implements SectionIndexer {

    private static final String[] FROM = {DBHelper.AUTHOR_NAME, DBHelper.TRACK_TITLE, DBHelper.HOLDER_CDNUMBER, DBHelper.HOLDER_TRACKNUMBER};
    private static final int[] TO = {};

    AlphabetIndexer alphabetIndexer;


    public AlphabetCursorAdapter(Context context, Cursor c) {
        super(context, R.layout.track_row_listing, c, FROM, TO, 0);
    }

    @Override
    public Object[] getSections() {
        return alphabetIndexer.getSections();
    }

    @Override
    public int getPositionForSection(int i) {
        return alphabetIndexer.getPositionForSection(i);
    }

    @Override
    public int getSectionForPosition(int i) {
        int section = 0;
        try {
            section = alphabetIndexer.getSectionForPosition(i);
        }
        catch (Exception e) {
            return section;
        }
        return section;
    }

    public Cursor swapCursor(Cursor c) {
        if (c != null) {
            this.alphabetIndexer = new AlphabetIndexer(c, c.getColumnIndex("author.name"), " ABCDEFGHIJKLMNOPQRTSUVWXYZ");
            //this.alphabetIndexer.setCursor(c);
        }
        return super.swapCursor(c);
    }

}
