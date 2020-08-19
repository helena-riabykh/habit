package com.example.android.habittracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HabitActivity extends AppCompatActivity {

    public static final String HABIT_EXTRA = "Habit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);
    }

    //public void onRadioButtonClicked(View view){
       // RadioGroup radioGroup = findViewById(R.id.radio_group);
        //int id = radioGroup.getCheckedRadioButtonId();
        //switch (id){
          //  case R.id.radio_useful:
            //break;
            //case R.id.radio_harmful:
            //break;
        //}
    }


