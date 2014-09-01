package com.djtracksholder.djtracksholder.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Вадим on 02.06.2014.
 */
public class BaseActivity extends FragmentActivity {

    ProgressDialog progressDialog;

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences settings = getSharedPreferences("Main", 0);
    }

    public void showWaitingDialog(String waitingMessage, boolean cancelable) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setCancelable(cancelable);
        if (waitingMessage != null) {
            progressDialog.setMessage(waitingMessage);
        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    public void showWaitingDialog(String waitingMessage) {
        showWaitingDialog(waitingMessage, false);
    }

    public void showWaitingDialog() {
        showWaitingDialog("Please wait ...");
    }

    public void dismissWaitingDialog() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
