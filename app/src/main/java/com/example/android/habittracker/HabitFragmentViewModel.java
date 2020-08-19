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
    public void notify(Habit habit, int position, int init, int index){
        if (position == -1 ) {
            model.addHabit(habit);
        } else if(position > 0 || position == 0){
            model.editingHabit(position, habit, init, index);
            Log.d(TAG, "стр. 25 HFVM" + position);
        }
    }

}
