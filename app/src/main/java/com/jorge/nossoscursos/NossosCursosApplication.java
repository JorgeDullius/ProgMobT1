package com.jorge.nossoscursos;

import android.app.Application;

import androidx.room.Room;

import com.jorge.nossoscursos.data.CursosOnlineDatabase;

public class NossosCursosApplication extends Application {
    static CursosOnlineDatabase database;

    @Override
    public void onCreate() {
        database = Room.databaseBuilder(
            getApplicationContext(),
            CursosOnlineDatabase.class, "cursosonline.db").build();
        super.onCreate();
    }
}
