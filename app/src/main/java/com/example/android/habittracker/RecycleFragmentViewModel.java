package com.example.android.habittracker;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

/**
 * Created by Anton on 23.06.2020.
 */
public class RecycleFragmentViewModel extends ViewModel {
    private Model model;
    private static final String TAG = "myLog";
    private String name;
    private final MutableLiveData<List<Habit>> mMutableLiveDataUseful = new MutableLiveData<>();
    private final MutableLiveData<List<Habit>> mMutableLiveDataHarmful = new MutableLiveData<>();

    public RecycleFragmentViewModel() {
        this.model = Model.getInstance();
    }

    public LiveData<List<Habit>> getHarmful() {
        model.getHabitsLiveData().observeForever(new Observer<List<Habit>>() {
            @Override
            public void onChanged(List<Habit> habits) {
                ArrayList<Habit> result = new ArrayList<>();
                for (Habit habit : habits) {
                    if (habit.getType().equals("Harmful")) {
                        result.add(habit);
                        Log.d(TAG, "стр. 64 RFVM");
                    }
                }
                mMutableLiveDataHarmful.setValue(result);
            }
        });
        return mMutableLiveDataHarmful;
    }

    public LiveData<List<Habit>> getUseful() {
        model.getHabitsLiveData().observeForever(new Observer<List<Habit>>() {
            @Override
            public void onChanged(List<Habit> habits) {
                ArrayList<Habit> result = new ArrayList<>();
                for (Habit habit : habits) {
                    if (habit.getType().equals("Useful")) {
                        result.add(habit);
                        Log.d(TAG, "стр. 64 RFVM");
                    }
                }
                mMutableLiveDataUseful.setValue(result);
            }
        });
        return mMutableLiveDataUseful;
    }


    public String getStringName() {
        return name;
    }

}