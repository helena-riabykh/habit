package com.example.android.habittracker;

import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by Anton on 22.06.2020.
 */
public class Model {
    private static Model instance;
    private final MutableLiveData<List<Habit>> mMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "myLog";
    private AppDatabase db;
    private HabitDao mHabitDao;
    public MyAsyncTask mMyAsyncTask;
    public MyAsyncTaskTwo mMyAsyncTaskTwo;

    private Model() {
        db = App.getInstance().getAppDatabaseInstance();
        mHabitDao = db.getHabitDao();
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public void addHabit(Habit habit) {
        mMyAsyncTask = new MyAsyncTask();
        mMyAsyncTask.execute(habit);
    }

    public void editingHabit(int posit, Habit habit) {
        mMyAsyncTaskTwo = new MyAsyncTaskTwo();
        mMyAsyncTaskTwo.execute(habit);
    }

    public void filterName(String name) {
        mMutableLiveData.setValue(mHabitDao.getAllWithNameLike(name));
    }

    public LiveData<List<Habit>> getHabitsLiveData() {
        return mMutableLiveData;
    }



    private class MyAsyncTask extends AsyncTask<Habit, Void, Void> {
        @Override
        protected Void doInBackground(Habit... habits) {
            Habit habit = habits[0];
            mHabitDao.insert(habit);
            return null;
        }
        protected void onPostExecute(Void result){
            mMutableLiveData.setValue(mHabitDao.getAll());
        }
    }
    private class MyAsyncTaskTwo extends AsyncTask <Habit, Void, Void> {
        @Override
        protected Void doInBackground(Habit... habits) {
            Habit habit = habits[0];
            mHabitDao.update(habit);
            return null;
        }
        protected void onPostExecute(Void result){
            mMutableLiveData.setValue(mHabitDao.getAll());
        }
    }
}