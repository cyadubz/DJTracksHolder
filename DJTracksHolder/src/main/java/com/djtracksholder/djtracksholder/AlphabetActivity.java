package com.djtracksholder.djtracksholder;

import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.Track;
import java.util.List;

public class AlphabetActivity extends Activity {

    DBHelper dbOpen;
    SQLiteDatabase db;
    HolderProvider holderProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        dbOpen = new DBHelper(this);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment(dbOpen))
                    .commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.alphabet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_alphabet:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {
        //public static List<Track> allTracks;
        private List<Track> tracks;
        private HolderProvider holderProvider;
        private DBHelper dbOpen;
        private int number;
        private Cursor cursor;
        private AlphabetCursorAdapter alphabetCursorAdapter;

        private OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                holderProvider.addToWaitingList(l);
                getLoaderManager().getLoader(0).forceLoad();
            }
        };

        public PlaceholderFragment(DBHelper dbOpen) {
            this.dbOpen = dbOpen;
            this.holderProvider = new HolderProvider(dbOpen);
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            alphabetCursorAdapter = new AlphabetCursorAdapter(getActivity(), cursor);
            setListAdapter(alphabetCursorAdapter);
            getLoaderManager().initLoader(0, null, this);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_browse, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }

        @Override
        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            return new TracksLoader(getActivity(), dbOpen, null);
        }

        @Override
        public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
            alphabetCursorAdapter.swapCursor(cursor);
            getListView().setFastScrollEnabled(true);
            getListView().setScrollingCacheEnabled(true);
            getListView().setOnItemClickListener(itemClickListener);
        }

        @Override
        public void onLoaderReset(Loader<Cursor> cursorLoader) {

        }
    }

}
