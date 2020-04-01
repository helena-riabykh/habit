package com.example.android.habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Habit> myHabitArrayList = new ArrayList<Habit>();
    private HabitAdapter adapter ;
    public int posit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            posit = savedInstanceState.getInt("posit");
            myHabitArrayList = (ArrayList<Habit>)savedInstanceState.getSerializable("ArrayList");

        }
            RecyclerView habitRecycler = findViewById(R.id.recycle);
            adapter = new HabitAdapter(myHabitArrayList);
            habitRecycler.setAdapter(adapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            habitRecycler.setLayoutManager(layoutManager);

            adapter.setListener(new HabitAdapter.Listener() {
                @Override
                public void onClick(int position) {
                    Intent intent = new Intent(MainActivity.this, HabitActivity.class);
                    posit = position;
                    startActivityForResult(intent, 2);
                }
            });
    }

    public void onClickDone(View view){
        Intent intent = new Intent(this, HabitActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        Habit habit = (Habit) data.getSerializableExtra(HabitActivity.HABIT_EXTRA);
        if (requestCode == 1) {
            myHabitArrayList.add(habit);
            adapter.notifyDataSetChanged();
        } else if(requestCode == 2){
           myHabitArrayList.set(posit, habit);
           adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
         super.onSaveInstanceState(savedInstanceState);
         savedInstanceState.putInt("posit", posit);
         savedInstanceState.putSerializable("ArrayList",  myHabitArrayList);
    }
}
