package com.example.android.habittracker;

import java.io.Serializable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Anton on 21.03.2020.
 */
@Entity
public class Habit implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private String description;
    private String priority;
    private String type;
    private String numberOfRuns;
    private String frequencyOfExecution;


    public Habit(int id, String name, String description, String priority, String type, String numberOfRuns,
                 String frequencyOfExecution){
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.type = type;
        this.numberOfRuns = numberOfRuns;
        this.frequencyOfExecution = frequencyOfExecution;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setNumberOfRuns(String numberOfRuns){
        this.numberOfRuns = numberOfRuns;
    }
    public void setFrequencyOfExecution(String frequencyOfExecution){
        this.frequencyOfExecution = frequencyOfExecution;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getPriority(){
        return priority;
    }
    public String getType(){
        return type;
    }
    public String getNumberOfRuns(){
        return numberOfRuns;
    }
    public String getFrequencyOfExecution(){
        return frequencyOfExecution;
    }

}
//from 31
//private static final String EXTRA_INSTANCE_HABIT = "habit";
//public static RecycleFragment getInstance() {
//  RecycleFragment recycleFragment = new RecycleFragment();
//return recycleFragment;
//from 41
// Bundle bundle = this.getArguments();
//  if (bundle != null && savedInstanceState == null) {
//     Habit habit = (Habit) bundle.getSerializable(HabitFragment.HABIT_EXTRA);
//     myHabitArrayList.add(habit);
//  adapter.notifyDataSetChanged();
// }
//from 53
//adapter.setListener(new HabitAdapter.Listener() {
//  @Override
//public void onClick(int position) {
//  posit = position;
//fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
//fragmentTransaction = fragmentManager
//      .beginTransaction();
// замещаем фрагмент
//HabitFragment habitFragment = new HabitFragment();
//fragmentTransaction.replace(R.id.container, habitFragment);
//fragmentTransaction.commit();
//}
//});
//}
//from 72 HabitFragment
//bundle.putSerializable(HABIT_EXTRA, habit);
//recycleFragment.setArguments(bundle);
//from 47
//int id = radioGroupView.getCheckedRadioButtonId();
//radioButtonView = view.findViewById(id);

//RecycleFragment from 45
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // Get back arguments
//        myHabitArrayList  = (ArrayList<Habit>) getArguments().getSerializable("ArrayList");
//    }