package com.example.android.habittracker;

import java.io.Serializable;

/**
 * Created by Anton on 21.03.2020.
 */
public class Habit implements Serializable {
    private String name;
    private String description;
    private String priority;
    private String type;
    private String numberOfRuns;
    private String frequencyOfExecution;


    public Habit(String name, String description, String priority, String type, String numberOfRuns,
                 String frequencyOfExecution){
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
