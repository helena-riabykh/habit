package com.example.android.habittracker;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by Anton on 22.06.2020.
 */
public class Model {
    private static Model instance;
    private List<Habit> myHabitArrayList;
    private final MutableLiveData<List<Habit>> mMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "myLog";

    private Model() {
        myHabitArrayList =  new ArrayList<Habit>();
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }
    public List<Habit> getMyHabitArrayList(){
        return myHabitArrayList;
    }
    public void addHabit(Habit habit){
        myHabitArrayList.add(habit);
        Log.d(TAG, "стр. 35 Model + habit" + habit);
        mMutableLiveData.setValue(myHabitArrayList);
        Log.d(TAG, "стр. 30 Model");
    }

    public void editingHabit(int posit, Habit habit, int init, int index){
        if (init < 3 && init > 0) {
            myHabitArrayList.set(posit, habit);
            //это случай, когда не меняем Useful на Harmful или наоборот
        }else if(init == 3) {
           // int index = myHabitArrayList.indexOf(habit);
            myHabitArrayList.remove(index);
            myHabitArrayList.add(habit);
            //это случай, когда меняем Useful на Harmful или наоборот
        }
        mMutableLiveData.setValue(myHabitArrayList);
        Log.d(TAG, "стр. 33 Model" + posit);
    }

    public LiveData<List<Habit>> getHabitsLiveData() {
        return mMutableLiveData;
    }
}
