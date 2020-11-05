package com.example.android.habittracker;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Created by Anton on 14.10.2020.
 */
@Dao
public interface HabitDao {
    @Query("SELECT * FROM Habit")
    List<Habit> getAll();

    @Query("SELECT * FROM Habit")
    LiveData<List<Habit>> getAllHabit();

    @Query("DELETE from Habit WHERE id =:id")
    void deleteById(int id);

    @Query("SELECT * FROM Habit WHERE name LIKE :name")
    List<Habit> getAllWithNameLike(String name);

    @Insert
    void insert(Habit habit);

    @Update
    void update(Habit habit);

    @Delete
    void delete(Habit habit);

}
