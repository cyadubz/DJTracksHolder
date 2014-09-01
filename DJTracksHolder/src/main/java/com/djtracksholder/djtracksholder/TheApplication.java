package com.djtracksholder.djtracksholder;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.djtracksholder.djtracksholder.orm.DatabaseManager;
import com.djtracksholder.djtracksholder.provider.DBHelper;
import com.djtracksholder.djtracksholder.utils.TypefaceFactory;

/**
 * Created by Вадим on 21.08.2014.
 */
public class TheApplication extends Application {

    private static Context context;
    private static String appVersion="";
    private static String appName="";
    private static int  buildNumber=0;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        TypefaceFactory.init(this);

        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            appVersion = pInfo.versionName;
            buildNumber = pInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        DatabaseManager.getInstance();
    }

    public static Context getAppContext() {
        return context;
    }
    public static String getAppVersion() {
        return appVersion;
    }
    public static String getAppName() {
        return appName;
    }
    public static int getBuildNumber() {
        return buildNumber;
    }
}
