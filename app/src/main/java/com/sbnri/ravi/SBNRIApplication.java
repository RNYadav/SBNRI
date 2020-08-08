package com.sbnri.ravi;

import android.app.Application;

import com.sbnri.ravi.network.RefreshHandler;

public class SBNRIApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread( () -> RefreshHandler.refreshDatabase(this)).start();
    }
}
