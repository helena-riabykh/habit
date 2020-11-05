package com.example.android.habittracker;

import android.util.Log;

import androidx.lifecycle.ViewModel;

/**
 * Created by Anton on 23.06.2020.
 */
public class HabitFragmentViewModel extends ViewModel {

    private Model model;
    private static final String TAG = "myLog";

    public HabitFragmentViewModel(){
        this.model = Model.getInstance();
    }

    //этот метод вызывается из HabitFragment
    public void notify(Habit habit, int position){
        if (position == -1 ) {
            model.addHabit(habit);
        } else if(position > 0 || position == 0){
            model.editingHabit(position, habit);
            Log.d(TAG, "стр. 25 HFVM" + position);
        }
    }
    //этот метод вызывается из FilterFragment
    public void notifyName(String name){
        model.filterName(name);
    }

}
