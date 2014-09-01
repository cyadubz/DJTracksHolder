package com.djtracksholder.djtracksholder.ui;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.djtracksholder.djtracksholder.R;
import com.djtracksholder.djtracksholder.adapters.AddingAdapter;
import com.djtracksholder.djtracksholder.com.djtracksholder.beans.TrackInfo;
import com.djtracksholder.djtracksholder.provider.HolderProvider;

import java.util.ArrayList;
import java.util.List;

public class AddNewCd extends BaseActivity implements View.OnClickListener {

    private List<TrackInfo> tracks;
    private AddingAdapter adapter;
    private ListView listView;
    private boolean isEdit;
    private TrackInfo editable;
    private int cd;

    private EditText authorEdit;
    private EditText trackEdit;
    private Button addTrackButton;
    private Button addCdButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_cd);
        tracks = new ArrayList<TrackInfo>();

        cd = getIntent().getIntExtra("cd", HolderProvider.getInstance(this).getCdCount()) + 1;
        tracks = HolderProvider.getInstance(this).getTracksFromCD(cd);

        adapter = new AddingAdapter(this, tracks);
        initActivityViews();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                isEdit = true;
                TrackInfo track = adapter.getItem(position);
                editable = track;
                authorEdit.setText(track.getAuthorName());
                trackEdit.setText(track.getTrackName());
                addTrackButton.setText(getString(R.string.add_edit));
            }
        });
    }

    private void initActivityViews() {
        authorEdit = (EditText)findViewById(R.id.editAuthor_AddCd);
        trackEdit = (EditText)findViewById(R.id.editTrack_AddCd);
        addTrackButton = (Button)findViewById(R.id.buttonTrack_AddCd);
        addCdButton = (Button)findViewById(R.id.buttonConfirm_AddCd);
        listView = (ListView)findViewById(R.id.listView_AddCd);

        addTrackButton.setOnClickListener(this);
        addCdButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_new_cd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonTrack_AddCd:
                if (isEdit && editable != null) {
                    editTrack(editable, authorEdit.getText().toString(), trackEdit.getText().toString());
                    authorEdit.setText("");
                    addTrackButton.setText(getString(R.string.add_add));
                    isEdit = false;
                }
                else {
                    addTrack(authorEdit.getText().toString(), trackEdit.getText().toString());
                }
                trackEdit.setText("");
                break;
            case R.id.buttonConfirm_AddCd:
                addCdToDataBase();
                break;
        }
    }

    private void addTrack(String authorName, String trackName) {
        TrackInfo track = new TrackInfo();
        track.setAuthorName(authorName);
        track.setTrackName(trackName);
        track.setTrackNumber(tracks.size() + 1);
        tracks.add(track);
        adapter.setData(tracks);
    }

    private void editTrack(TrackInfo track, String authorName, String trackName) {
        track.setAuthorName(authorName);
        track.setTrackName(trackName);
        track.setTrackNumber(track.getTrackNumber());
        adapter.setData(tracks);
    }

    private void addCdToDataBase() {
        if (tracks != null) {
            for (TrackInfo trackInfo : tracks) {
                trackInfo.setCdNumber(cd);
            }
            HolderProvider.getInstance(this).deleteTracksFromCd(cd);
            HolderProvider.getInstance(this).addTracksToHolder(tracks, new HolderProvider.Callbacks() {
                @Override
                public void onSuccess() {
                    Toast.makeText(AddNewCd.this, "Success", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
