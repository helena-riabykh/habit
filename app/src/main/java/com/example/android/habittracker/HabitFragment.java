package com.example.android.habittracker;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HabitFragment extends Fragment {
    static final String HABIT_EXTRA = "Habit";
    static final int INT_EXTRA = 1;
    private Habit habit;
    private EditText nameView;
    private EditText descriptionView;
    private Spinner priorityView;
    private RadioGroup radioGroupView;
    private EditText numberOfRunsView;
    private EditText frequencyOfExecutionView;
    private RadioButton radioButtonView;
    private static final String TAG = "my log";
    private HabitFragmentViewModel mHabitFragmentViewModel;
    private int positItem = -1;
    private int init = 0;
    private int index = -2;


    static HabitFragment newInstance(Habit habit) {
        HabitFragment habitFragment = new HabitFragment();
        Bundle args = new Bundle();
        args.putSerializable(HABIT_EXTRA, habit);
        habitFragment.setArguments(args);
        return habitFragment;
    }
    static HabitFragment newInstance(Habit habit, int posit) {
        HabitFragment habitFragment = new HabitFragment();
        Bundle args = new Bundle();
        args.putSerializable(HABIT_EXTRA, habit);
        args.putInt(String.valueOf(INT_EXTRA), posit);
        habitFragment.setArguments(args);
        return habitFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_habit, container, false);
          nameView = view.findViewById(R.id.name);
          descriptionView = view.findViewById(R.id.description);
          priorityView = view.findViewById(R.id.spinner);
          radioGroupView = view.findViewById(R.id.radio_group);
          numberOfRunsView = view.findViewById(R.id.numberOfRuns);
          frequencyOfExecutionView = view.findViewById(R.id.frequencyOfExecution);
         if (getArguments() != null) {
             Model model = Model.getInstance();
             habit = (Habit) getArguments().getSerializable(HABIT_EXTRA);
             //находим индекс объекта habit в MyHabitArrayList:
             index = model.getMyHabitArrayList().indexOf(habit);
             positItem = getArguments().getInt(String.valueOf(INT_EXTRA));
             assert habit != null;
             nameView.setText(habit.getName());
             descriptionView.setText(habit.getDescription());
             switch (habit.getPriority()) {
                 case "paramount":
                     priorityView.setSelection(0);
                     break;
                 case "secondary":
                     priorityView.setSelection(1);
                     break;
                 case "minor":
                     priorityView.setSelection(2);
                     break;
             }
             switch (habit.getType()){
                 case "Useful":
                     radioGroupView.check(R.id.radio_useful);
                     init = 1;
                     break;
                 case "Harmful":
                     radioGroupView.check(R.id.radio_harmful);
                     init = 2;
                     break;
             }
             numberOfRunsView.setText(habit.getNumberOfRuns());
             frequencyOfExecutionView.setText(habit.getFrequencyOfExecution());
         }
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameView.getText().toString();
                String description = descriptionView.getText().toString();
                String priority = String.valueOf(priorityView.getSelectedItem());
                int id = radioGroupView.getCheckedRadioButtonId();
                radioButtonView = radioGroupView.findViewById(id);
                String type = radioButtonView.getText().toString();
                String numberOfRuns = numberOfRunsView.getText().toString();
                String frequencyOfExecution = frequencyOfExecutionView.getText().toString();
                habit = new Habit(name, description, priority, type, numberOfRuns, frequencyOfExecution);
 //               ((MainActivity)requireActivity()).notify(habit);
                mHabitFragmentViewModel = new HabitFragmentViewModel();
                if (init == 1 && type.equals("Harmful") || init == 2 && type.equals("Useful")){
                    init = 3;
                }
                Log.d(TAG, "стр. 104 HabitFragment");
                mHabitFragmentViewModel.notify(habit, positItem, init, index);
//                sendResult(habit);
                requireActivity().onBackPressed();
            }
        });
        return view;
    }
}
