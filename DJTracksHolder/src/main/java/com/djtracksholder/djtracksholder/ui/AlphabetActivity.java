package com.djtracksholder.djtracksholder.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;

import com.djtracksholder.djtracksholder.adapters.FilterAdapter;
import com.djtracksholder.djtracksholder.com.djtracksholder.beans.TrackInfo;
import com.djtracksholder.djtracksholder.utils.CompByAuthor;
import com.djtracksholder.djtracksholder.widget.AlphabetCursorAdapter;
import com.djtracksholder.djtracksholder.provider.HolderProvider;
import com.djtracksholder.djtracksholder.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AlphabetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
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
    public static class PlaceholderFragment extends ListFragment {

        private HolderProvider holderProvider;
        private FilterAdapter adapter;
        List<TrackInfo> tracks;

        private TextWatcher filterWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s.toString());
            }
        };

        private EditText filterText;

        private OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TrackInfo trackInfo = adapter.getItem(i);
                holderProvider.addToWaitingList(trackInfo.getId());
            }
        };

        public PlaceholderFragment() {
            this.holderProvider = HolderProvider.getInstance(getActivity());
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_browse, container, false);
            initFragmentViews(rootView);
            return rootView;
        }

        private void initFragmentViews(View view) {
            filterText = (EditText)view.findViewById(R.id.editFilter);
            filterText.addTextChangedListener(filterWatcher);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            tracks = holderProvider.getAllTracks();
            Collections.sort(tracks, new CompByAuthor());
            adapter = new FilterAdapter(getActivity(), tracks);
            getListView().setFastScrollEnabled(true);
            getListView().setScrollingCacheEnabled(true);
            getListView().setOnItemClickListener(itemClickListener);
            setListAdapter(adapter);
        }
    }

}
