package com.example.android.habittracker;

//import java.util.List;
//
///**
// * Created by Anton on 29.10.2020.
// */
//public class MyAsyncTaskTwo extends AsyncTask <Habit, Void, Void> {
//    AppDatabase db = App.getInstance().getAppDatabaseInstance();
//    HabitDao mHabitDao = db.getHabitDao();
//    private List<Habit> list;
//    @Override
//    protected Void doInBackground(Habit... habits) {
////        AppDatabase db = App.getInstance().getAppDatabaseInstance();
////        HabitDao mHabitDao = db.getHabitDao();
//        Habit habit = habits[0];
//        mHabitDao.update(habit);
//        return null;
//    }
//    protected void onPostExecute(Void result){
//        //       List<Habit> list = new ArrayList<>();
//        list = mHabitDao.getAll();
//    }
//    public List<Habit> getList(){
//        return list;
//    }
//}
