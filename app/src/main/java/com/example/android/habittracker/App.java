package com.example.android.habittracker;

import android.app.Application;

import androidx.room.Room;

/**
 * Created by Anton on 16.10.2020.
 */
public class App extends Application {

    private static App instance;
    private AppDatabase db;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getAppDatabaseInstance() {
        return db;
    }
}
