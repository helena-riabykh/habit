package com.example.android.habittracker;

//import android.os.AsyncTask;
//
//import java.util.List;
//
///**
// * Created by Anton on 26.10.2020.
// */
//public class MyAsyncTask extends AsyncTask<Habit, Void, Void> {
//    AppDatabase db = App.getInstance().getAppDatabaseInstance();
//    HabitDao mHabitDao = db.getHabitDao();
//    private  List<Habit> list;
//
//
//    @Override
//    protected Void doInBackground(Habit... habits) {
////        AppDatabase db = App.getInstance().getAppDatabaseInstance();
////        HabitDao mHabitDao = db.getHabitDao();
//        Habit habit = habits[0];
//        mHabitDao.insert(habit);
//        return null;
//    }
//    protected void onPostExecute(Void result){
// //       List<Habit> list = new ArrayList<>();
//        list = mHabitDao.getAll();
//    }
//    public List<Habit> getList(){
//        return list;
//    }
//}
