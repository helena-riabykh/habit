package com.example.android.habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class HabitActivity extends AppCompatActivity {
    public static final String HABIT_EXTRA = "Habit";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);
    }

    public void onRadioButtonClicked(View view){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id){
            case R.id.radio_useful:
            break;
            case R.id.radio_harmful:
            break;
        }
    }

    public void onClickReadily(View view){
        EditText nameView = (EditText)findViewById(R.id.name);
        EditText descriptionView = (EditText)findViewById(R.id.description);
        Spinner priorityView = (Spinner)findViewById(R.id.spinner);
        RadioGroup radioGroupView = (RadioGroup)findViewById(R.id.radio_group);
        EditText numberOfRunsView = (EditText)findViewById(R.id.numberOfRuns);
        EditText frequencyOfExecutionView = (EditText)findViewById(R.id.frequencyOfExecution);
        String name = nameView.getText().toString();
        String description = descriptionView.getText().toString();
        String priority = String.valueOf(priorityView.getSelectedItem());
        int id = radioGroupView.getCheckedRadioButtonId();
        RadioButton radioButtonView = (RadioButton)findViewById(id);
        String type = radioButtonView.getText().toString();
        String numberOfRuns = numberOfRunsView.getText().toString();
        String frequencyOfExecution = frequencyOfExecutionView.getText().toString();
        Habit habit = new Habit(name, description, priority, type, numberOfRuns,frequencyOfExecution);
        Intent intent = new Intent();
        intent.putExtra(HABIT_EXTRA, habit);
        setResult(RESULT_OK, intent);
        finish();
    }
}
