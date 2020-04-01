package com.example.android.habittracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Anton on 23.03.2020.
 */
 class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.ViewHolder> implements Serializable {

    public ArrayList<Habit> myHabitArrayList;
    private Listener listener;

    interface Listener{
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;

        public ViewHolder(CardView v){
            super(v);
            cardView =v;
        }
    }

    public  HabitAdapter(ArrayList<Habit> myHabitArrayList){
        this.myHabitArrayList = myHabitArrayList;
    }

    @Override
    public int getItemCount(){
       return myHabitArrayList.size();
    }

    public void  setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public HabitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,
                parent, false);
        return new ViewHolder(cv);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        Habit habit = myHabitArrayList.get(position);
        CardView cardView = holder.cardView;
        TextView name = (TextView)cardView.findViewById(R.id.name);
        name.setText(habit.getName());
        TextView description = (TextView)cardView.findViewById(R.id.description);
        description.setText(habit.getDescription());
        TextView priority = (TextView)cardView.findViewById(R.id.priority);
        priority.setText(habit.getPriority());
        TextView type = (TextView)cardView.findViewById(R.id.type);
        type.setText(habit.getType());
        TextView numberOfRuns = (TextView)cardView.findViewById(R.id.numberOfRuns);
        numberOfRuns.setText(habit.getNumberOfRuns());
        TextView frequencyOfExecution = (TextView)cardView.findViewById(R.id.frequencyOfExecution);
        frequencyOfExecution.setText(habit.getFrequencyOfExecution());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(position);
                }
            }
        });
    }

}
