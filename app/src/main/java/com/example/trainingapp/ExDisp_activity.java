package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ExDisp_activity extends AppCompatActivity {

    DayData useddayData;
    DayData.ExerciseData exercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_disp_activity);
        String name = getIntent().getStringExtra("dayData_Excercises");
        useddayData = new Gson().fromJson(name, DayData.class);
        String ex_name = getIntent().getStringExtra("nazwa");
        TextView ex_view = findViewById(R.id.exercise_name);
        System.out.println(ex_name);
        ex_view.setText(ex_name);

        for (DayData.ExerciseData data : useddayData.exercises){
            if(ex_name.equals(data.name))
                exercise=data;
        }
    }



    public void editExercises(View view){
        EditText set1 = findViewById(R.id.set1);
        set1.setEnabled(true);
        set1.setTextColor(Color.BLACK);


        EditText set2 = findViewById(R.id.set2);
        set2.setEnabled(true);
        set2.setTextColor(Color.BLACK);

        EditText set3 = findViewById(R.id.set3);
        set3.setEnabled(true);
        set3.setTextColor(Color.BLACK);

        EditText set4 = findViewById(R.id.set4);
        set4.setEnabled(true);
        set4.setTextColor(Color.BLACK);


        EditText repeat1 = findViewById(R.id.repeat1);
        repeat1.setEnabled(true);
        repeat1.setTextColor(Color.BLACK);

        EditText repeat2 = findViewById(R.id.repeat2);
        repeat2.setEnabled(true);
        repeat2.setTextColor(Color.BLACK);

        EditText repeat3 = findViewById(R.id.repeat3);
        repeat3.setEnabled(true);
        repeat3.setTextColor(Color.BLACK);

        EditText repeat4 = findViewById(R.id.repeat4);
        repeat4.setEnabled(true);
        repeat4.setTextColor(Color.BLACK);


        EditText weight1 = findViewById(R.id.weight1);
        weight1.setEnabled(true);
        weight1.setTextColor(Color.BLACK);

        EditText weight2 = findViewById(R.id.weight2);
        weight2.setEnabled(true);
        weight2.setTextColor(Color.BLACK);

        EditText weight3 = findViewById(R.id.weight3);
        weight3.setEnabled(true);
        weight3.setTextColor(Color.BLACK);

        EditText weight4 = findViewById(R.id.weight4);
        weight4.setEnabled(true);
        weight4.setTextColor(Color.BLACK);


    }


    public void saveExercises(View view){
        EditText set1 = findViewById(R.id.set1);
        set1.setEnabled(false);
        set1.setTextColor(Color.BLACK);


        EditText set2 = findViewById(R.id.set2);
        set2.setEnabled(false);
        set2.setTextColor(Color.BLACK);

        EditText set3 = findViewById(R.id.set3);
        set3.setEnabled(false);
        set3.setTextColor(Color.BLACK);

        EditText set4 = findViewById(R.id.set4);
        set4.setEnabled(false);
        set4.setTextColor(Color.BLACK);


        EditText repeat1 = findViewById(R.id.repeat1);
        repeat1.setEnabled(false);
        repeat1.setTextColor(Color.BLACK);

        EditText repeat2 = findViewById(R.id.repeat2);
        repeat2.setEnabled(false);
        repeat2.setTextColor(Color.BLACK);

        EditText repeat3 = findViewById(R.id.repeat3);
        repeat3.setEnabled(false);
        repeat3.setTextColor(Color.BLACK);

        EditText repeat4 = findViewById(R.id.repeat4);
        repeat4.setEnabled(false);
        repeat4.setTextColor(Color.BLACK);


        EditText weight1 = findViewById(R.id.weight1);
        weight1.setEnabled(false);
        weight1.setTextColor(Color.BLACK);

        EditText weight2 = findViewById(R.id.weight2);
        weight2.setEnabled(false);
        weight2.setTextColor(Color.BLACK);

        EditText weight3 = findViewById(R.id.weight3);
        weight3.setEnabled(false);
        weight3.setTextColor(Color.BLACK);

        EditText weight4 = findViewById(R.id.weight4);
        weight4.setEnabled(false);
        weight4.setTextColor(Color.BLACK);



    }
    @Override
    protected void onResume() {
        super.onResume();
        TextView dayview = findViewById(R.id.day_name);
        TextView exview = findViewById(R.id.exercise_name);
        dayview.setText(useddayData.nameButton);
        System.out.println(useddayData.exercises);
        System.out.println("Wybrane cwiczenie " + useddayData.excercisesSet);
        //System.out.println(useddayData.excercisesSet);
        //System.out.println(useddayData.id);
        //System.out.println(useddayData.nameButton);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
