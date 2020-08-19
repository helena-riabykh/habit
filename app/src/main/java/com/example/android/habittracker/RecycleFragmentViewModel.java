package com.example.android.habittracker;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * Created by Anton on 23.06.2020.
 */
public class RecycleFragmentViewModel extends ViewModel {
    private Model model;
    private static final String TAG = "myLog";

    public RecycleFragmentViewModel(){
        this.model = Model.getInstance();
    }

    public LiveData<List<Habit>> getHarmful() {
        return Transformations.map(model.getHabitsLiveData(),
                new Function<List<Habit>, List<Habit>>() {
                    @Override
                    public ArrayList<Habit> apply(List<Habit> input) {
                        ArrayList<Habit> result = new ArrayList<>();
                        for (Habit habit : input){
                            if (habit.getType().equals("Harmful")){
                                result.add(habit);
                            }
                        }
                        return result;
                    }
                });
    }

    public LiveData<List<Habit>> getUseful() {
        return Transformations.map(model.getHabitsLiveData(),
                new Function<List<Habit>, List<Habit>>() {
                    @Override
                    public List<Habit> apply(List<Habit> input) {
                        ArrayList<Habit> result = new ArrayList<>();
                        for (Habit habit : input){
                            if (habit.getType().equals("Useful")){
                                result.add(habit);
                                Log.d(TAG, "стр. 64 RFVM");
                            }
                        }
                        return result;
                    }
                });
    }
}
