package com.jorge.nossoscursos;

import android.app.Application;

import com.jorge.nossoscursos.data.CursosOnlineDatabase;

public class NossosCursosApplication extends Application {
    static CursosOnlineDatabase database;

    @Override
    public void onCreate() {
        database = CursosOnlineDatabase.build(getApplicationContext());
        super.onCreate();
    }
}
