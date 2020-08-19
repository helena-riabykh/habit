package com.example.android.habittracker;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Anton on 23.03.2020.
 */
class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.ViewHolder> implements Serializable {

    private List<Habit> myHabitArrayList;
    private Listener listener;
    private static final String TAG = "myLog";

    interface Listener {
        void onClick(int position);
    }

    public void setMyHabitArrayList(List<Habit> myHabitArrayList){
        this.myHabitArrayList = myHabitArrayList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        private ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    HabitAdapter(List<Habit> myHabitArrayList) {
        this.myHabitArrayList = myHabitArrayList;
        Log.d(TAG, "конструктор нmyHabitArrayList в адаптере");
    }

    @Override
    public int getItemCount() {
       //   Log.d(TAG, "Определен размер myHabitArrayList в адаптере");
        return myHabitArrayList.size();
    }

    void setListener(Listener listener) {
        this.listener = listener;
    }

   @NonNull
    @Override
    public HabitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,
                parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Habit habit = myHabitArrayList.get(position);
        Log.d(TAG, "начало метода onBindViewHolder в адаптере");
        CardView cardView = holder.cardView;
        TextView name = cardView.findViewById(R.id.name);
        name.setText(habit.getName());
        TextView description = cardView.findViewById(R.id.description);
        description.setText(habit.getDescription());
        TextView priority = cardView.findViewById(R.id.priority);
        priority.setText(habit.getPriority());
        TextView type = cardView.findViewById(R.id.type);
        type.setText(habit.getType());
        TextView numberOfRuns = cardView.findViewById(R.id.numberOfRuns);
        numberOfRuns.setText(habit.getNumberOfRuns());
        TextView frequencyOfExecution = cardView.findViewById(R.id.frequencyOfExecution);
        frequencyOfExecution.setText(habit.getFrequencyOfExecution());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
        Log.d(TAG, "конец метода onBindViewHolder в адаптере");
    }

}
