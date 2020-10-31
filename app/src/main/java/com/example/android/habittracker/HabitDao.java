package com.example.android.habittracker;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
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
//for  model.editingHabit str.47
    @Query("DELETE from Habit WHERE id IN (:id)")
    void deleteById(int id);
//for model.editingHabit str.43
//    @Query("INSERT INTO Habit WHERE id =:id")
//    void updateHabitById(int id, Habit habit);
// for model.filterName
    @Query("SELECT * FROM Habit WHERE name LIKE :name")
    List<Habit> getAllWithNameLike(String name);
//for  model.editingHabit str.48 and model.addHabit str.35
 //   @Query("UPDATE habit  WHERE id = :id")
//   @Insert(onConflict = OnConflictStrategy.REPLACE)
//   void insertHabit(Habit habit);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHabit(Habit habit);
   @Insert
    void insert(Habit habit);

    @Update
    void update(Habit habit);

    @Delete
    void delete(Habit habit);

}
