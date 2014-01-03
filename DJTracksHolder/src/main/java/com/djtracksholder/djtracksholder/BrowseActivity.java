package com.djtracksholder.djtracksholder;

import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.Track;

public class BrowseActivity extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    int cdCount = 0;
    DBHelper dbOpen;
    SQLiteDatabase db;
    HolderProvider holderProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_layout);



        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        dbOpen = new DBHelper(this);
        db = dbOpen.getWritableDatabase();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.browse, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_alphabet:
                Intent intent = new Intent(this, AlphabetActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1, dbOpen);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return MockData.getCdCount();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {
        private List<Track> tracks;
        private HolderProvider holderProvider;
        private DBHelper dbOpen;
        private int number;
        private Cursor cursor;
        private SimpleCursorAdapter simpleCursorAdapter;

        private static final String[] FROM = {DBHelper.AUTHOR_NAME, DBHelper.TRACK_TITLE, DBHelper.HOLDER_TRACKNUMBER};
        private static final int[] TO = {R.id.authorName, R.id.trackTitle, R.id.trackNumber};

        private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                holderProvider.addToWaitingList(l);
                getLoaderManager().getLoader(0).forceLoad();
            }
        };

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber, DBHelper dbOpen) {
            PlaceholderFragment fragment = new PlaceholderFragment(sectionNumber, dbOpen);
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment(int sectionNumber, DBHelper dbOpen) {
            this.dbOpen = dbOpen;
            this.holderProvider = new HolderProvider(dbOpen);
            this.number = sectionNumber;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            simpleCursorAdapter = new SimpleCursorAdapter(getActivity(), R.layout.track_row, cursor, FROM, TO, 0);
            setListAdapter(simpleCursorAdapter);
            Bundle bndl = new Bundle();
            bndl.putInt("number", number);
            getLoaderManager().initLoader(0, bndl, this);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_browse, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(MockData.ok);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)) + " CD");
            return rootView;
        }

        @Override
        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            return new TracksLoader(getActivity(), dbOpen, bundle);
        }

        @Override
        public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
            simpleCursorAdapter.swapCursor(cursor);
            getListView().setOnItemClickListener(itemClickListener);
        }

        @Override
        public void onLoaderReset(Loader<Cursor> cursorLoader) {

        }
    }

}
