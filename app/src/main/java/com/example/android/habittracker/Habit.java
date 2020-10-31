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