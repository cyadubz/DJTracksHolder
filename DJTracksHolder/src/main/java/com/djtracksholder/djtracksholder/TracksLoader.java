package com.djtracksholder.djtracksholder;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vadym_Vykhrystiuk on 1/2/14.
 */
public class TracksLoader extends CursorLoader {
    private HolderProvider provider;
    private int number = 0;
    private int section = 0;

    public TracksLoader(Context context, DBHelper dbOpen, Bundle bundle) {
        super(context);
        this.provider = new HolderProvider(dbOpen);
        if (bundle != null) {
            this.number = bundle.getInt("number");
            this.section = bundle.getInt("section");
        }
    }

    @Override
    public Cursor loadInBackground() {
        Cursor cursor;
        if (section == 1) {
            cursor = provider.getTracksFromWaitList();
        }
        else if (number != 0) {
            cursor = provider.getTracksFromCD(number);
        }

        else {
            cursor = provider.getAllTracksCursor();
        }

        return cursor;
    }
}
