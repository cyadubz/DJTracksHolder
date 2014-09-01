package com.djtracksholder.djtracksholder.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.djtracksholder.djtracksholder.MockData;
import com.djtracksholder.djtracksholder.Parser;
import com.djtracksholder.djtracksholder.R;
import com.djtracksholder.djtracksholder.provider.DBHelper;
import com.djtracksholder.djtracksholder.provider.HolderProvider;

public class EditorActivity extends BaseActivity implements HolderProvider.Callbacks {

    HolderProvider holderProvider;
    private EditorActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_editor);
        Button btn_reload = (Button) findViewById(R.id.reload);
        btn_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWaitingDialog();

                holderProvider = HolderProvider.getInstance(EditorActivity.this);
                AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        holderProvider.deleteData();
                        holderProvider.addTracksToHolder(Parser.parseThisShit(MockData.DATA), mActivity);
                        return null;
                    }
                };
                task.execute(null, null, null);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.editor, menu);
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
    public void onSuccess() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dismissWaitingDialog();
            }
        });
    }
}
