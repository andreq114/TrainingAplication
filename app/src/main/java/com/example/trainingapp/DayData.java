package com.example.trainingapp;

import java.util.ArrayList;

public class DayData {

    public enum Status {COMPLETE,UNCOMPLETE,NEW}

    public static Integer licznikId = 0;
    public Integer id;
    public String nameButton = null;
    public ArrayList<ExerciseData> exercises;
    public Integer excercisesSet=0;
    public ArrayList<String> sets ;
    public ArrayList<String> repeats;
    public ArrayList<String> weight;

    DayData(){
        exercises = new ArrayList<>();
        sets = new ArrayList<>();
        repeats = new ArrayList<>();
        weight = new ArrayList<>();
    }
    DayData(boolean bol){
        exercises = new ArrayList<>();
        sets = new ArrayList<>();
        repeats = new ArrayList<>();
        weight = new ArrayList<>();
        if(bol)
        id =( ++licznikId);
        System.out.println("Nowe ID:"+ id);
    }

    public class ExerciseData {

        public Status status = Status.NEW;
        public String name;

        ExerciseData(String name){
            this.name = name;
        }
    }

    public static Integer getLicznikId() {
        return licznikId;
    }

    public static void setLicznikId(Integer licznikId) {
        DayData.licznikId = licznikId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExcercisesSet() {
        return excercisesSet;
    }

    public void setExcercisesSet(Integer excercisesSet) {
        this.excercisesSet = excercisesSet;
    }

    public String getNameButton() {
        return nameButton;
    }

    public void setNameButton(String nameButton) {
        this.nameButton = nameButton;
    }

    public ArrayList<ExerciseData> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<ExerciseData> exercises) {
        this.exercises = exercises;
    }

    public ArrayList<String> getSets() {
        return sets;
    }

    public void setSets(ArrayList<String> sets) {
        this.sets = sets;
    }

    public ArrayList<String> getRepeats() {
        return repeats;
    }

    public void setRepeats(ArrayList<String> repeats) {
        this.repeats = repeats;
    }

    public ArrayList<String> getWeight() {
        return weight;
    }

    public void setWeight(ArrayList<String> weight) {
        this.weight = weight;
    }
}
