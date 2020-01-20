package com.example.trainingapp;

import java.util.ArrayList;

public class DayData {
    public String getNameButton() {
        return nameButton;
    }

    public void setNameButton(String nameButton) {
        this.nameButton = nameButton;
    }

    public ArrayList<String> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<String> exercises) {
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

    public String nameButton = null;
    public ArrayList<String> exercises = null;
    public ArrayList<String> sets = null;
    public ArrayList<String> repeats = null;
    public ArrayList<String> weight = null;
}
