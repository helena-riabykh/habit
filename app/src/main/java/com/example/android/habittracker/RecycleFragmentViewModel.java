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
//    private final MutableLiveData<String> mLiveData = new MutableLiveData<>();

    public RecycleFragmentViewModel() {
        this.model = Model.getInstance();
    }

//    public void setName(String name) {
//        //вызывается из FilterFragment после того, как введено слово для фильтра
//        this.name = name;
//    }


    //    public LiveData<List<Habit>> getHarmful() {
//        return Transformations.map(model.getHabitsLiveData(),
//                new Function<List<Habit>, List<Habit>>() {
//                    @Override
//                    public ArrayList<Habit> apply(List<Habit> input) {
//                        ArrayList<Habit> result = new ArrayList<>();
//                        for (Habit habit : input){
//                            if (habit.getType().equals("Harmful")){
//                                result.add(habit);
//                            }
//                        }
//                        if (name != null) {
//                            for (Habit habit : result) {
//                                if (habit.getName().contains(name)) {
//                                    result.add(habit);
//                                } else {
//                                    result.remove(habit);
//                                }
//                            }
//                        }
//                        return result;
//                    }
//                });
//    }
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
//                if (name != null) {
//                    for (Habit habit : result) {
//                        if (habit.getName().contains(name)) {
//                            result.add(habit);
//                        } else {
//                            result.remove(habit);
//                        }
//                    }
//                }
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
                //              for (Habit habit : result) {
//                if (name != null) {
//                    for (Habit habit : result) {
//                        if (habit.getName().contains(name)) {
//                            result.add(habit);
//                        } else {
//                            result.remove(habit);
//                        }
//                    }
//                }
                mMutableLiveDataUseful.setValue(result);
            }
        });
        return mMutableLiveDataUseful;
    }
//
//        public LiveData<List<Habit>> getHarmful() {
//            model.getHabitsLiveData().observeForever(new Observer<List<Habit>>() {
//                @Override
//                public void onChanged(List<Habit> habits) {
//                    ArrayList<Habit> result = new ArrayList<>();
//                    for (Habit habit : habits) {
//                        if (habit.getType().equals("Harmful")) {
//                            result.add(habit);
//                            Log.d(TAG, "стр. 64 RFVM");
//                        }
//                    }
//                    if (name != null) {
//                        for (Habit habit : result) {
//                            if (habit.getName().contains(name)) {
//                                result.add(habit);
//                            } else {
//                                result.remove(habit);
//                            }
//                        }
//                    }
//                    mMutableLiveData.setValue(result);
//                }
//            });
//            return mMutableLiveData;
//        }


    //   public LiveData<List<Habit>> getHabitsLiveData() {
//        return mMutableLiveData;
//    }
//    public LiveData<List<Habit>> getUseful() {
//        return Transformations.map(model.getHabitsLiveData(),
//                new Function<List<Habit>, List<Habit>>() {
//                    @Override
//                    public ArrayList<Habit> apply(List<Habit> input) {
//                        ArrayList<Habit> result = new ArrayList<>();
//                        for (Habit habit : input) {
//                            if (habit.getType().equals("Useful")) {
//                                result.add(habit);
//                                Log.d(TAG, "стр. 64 RFVM");
//                            }
//                        }
//                        if (name != null) {
//                            for (Habit habit : result) {
//                                if (habit.getName().contains(name)) {
//                                    result.add(habit);
//                                } else {
//                                    result.remove(habit);
//                                }
//                            }
//                        }
//                        return result;
//                    }
//                });
//    }
    public String getStringName() {
        return name;
    }

//    public LiveData<List<Habit>> getName() {
//        model.getLiveData().observeForever(new Observer<String>() {
//            //           private String name;
//
//            @Override
//            public void onChanged(String name) {
//                //                this.name = name;
//                mLiveData.setValue(name);
//
//            }
////        return Transformations.map(model.getHabitsLiveData(),
////                new Function<List<Habit>, List<Habit>>() {
////                    @Override
////                    public ArrayList<Habit> apply(List<Habit> input) {
////                        ArrayList<Habit> result = new ArrayList<>();
////                        for (Habit habit : input){
////                            if (habit.getName().contains(name)){
////                                result.add(habit);
////
////                            }
////                        }
////                        return result;
//        });
//        return mLiveData;
//    }
}