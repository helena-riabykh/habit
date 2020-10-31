package com.example.android.habittracker;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by Anton on 14.10.2020.
 */
@Database(entities = {Habit.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract HabitDao getHabitDao();
}

