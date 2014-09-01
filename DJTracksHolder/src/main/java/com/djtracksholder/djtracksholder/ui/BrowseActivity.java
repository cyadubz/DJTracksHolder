package com.djtracksholder.djtracksholder.ui;

import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.LogRecord;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.djtracksholder.djtracksholder.adapters.BrowseTracksAdapter;
import com.djtracksholder.djtracksholder.com.djtracksholder.beans.TrackInfo;
import com.djtracksholder.djtracksholder.provider.HolderProvider;
import com.djtracksholder.djtracksholder.MockData;
import com.djtracksholder.djtracksholder.R;

public class BrowseActivity extends BaseActivity {
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_layout);
        int position = MockData.getPosition();
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras() != null) {
            position = getIntent().getExtras().getInt("cd") - 1;
        }

        mViewPager.setCurrentItem(position);
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
            case R.id.action_add:
                Intent intent = new Intent(this, AddNewCd.class);
                startActivity(intent);
                break;
            case R.id.action_edit:
                startEditorActivity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startEditorActivity() {
        int cd = mViewPager.getCurrentItem();
        Intent intent = new Intent(this, AddNewCd.class);
        intent.putExtra("cd", cd);
        startActivity(intent);
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
            MockData.setPosition(position - 1);
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return HolderProvider.getInstance(BrowseActivity.this).getCdCount();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            return Integer.toString(position + 1) + " CD";
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends ListFragment {

        private HolderProvider holderProvider;
        private int number;
        private BrowseTracksAdapter adapter;
        ArrayList<TrackInfo> tracks;

        private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TrackInfo trackInfo = tracks.get(i);
                holderProvider.addToWaitingList(trackInfo.getId());
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
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            number = getArguments().getInt(ARG_SECTION_NUMBER);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_browse, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            EditText filterText = (EditText)rootView.findViewById(R.id.editFilter);
            filterText.setVisibility(View.GONE);

            return rootView;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            this.holderProvider = HolderProvider.getInstance(getActivity());

            tracks = holderProvider.getTracksFromCD(number);

            adapter = new BrowseTracksAdapter(getActivity(), tracks);
            getListView().setOnItemClickListener(itemClickListener);
            getListView().setAdapter(adapter);
        }
    }

}
