package com.flobamora.flobamora.Tools;

import android.app.Application;

public class NightMode extends Application {
    private static NightMode singleton = null;
    private boolean isNightModeEnabled =false;

    public static NightMode getInstance(){
        if (singleton == null){
            singleton = new NightMode();
        }
        return singleton;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        singleton = this;
    }

    public boolean getisNightModeEnabled(){
        return isNightModeEnabled;
    }

    public void setNightModeEnabled(boolean n) {
        this.isNightModeEnabled = n;
    }
}