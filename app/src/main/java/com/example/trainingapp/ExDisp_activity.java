package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExDisp_activity extends AppCompatActivity {

    DayData useddayData;
    DayData.ExerciseData exercise;
    EditText nset1;
    EditText nset2;
    EditText nset3;
    EditText nset4;
    EditText nrepeat1;
    EditText nrepeat2;
    EditText nrepeat3;
    EditText nrepeat4;
    EditText nweight1;
    EditText nweight2;
    EditText nweight3;
    EditText nweight4;

    String exerciseName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_disp_activity);
        String name = getIntent().getStringExtra("dayData_Excercises");
        useddayData = new Gson().fromJson(name, DayData.class);
        exerciseName = getIntent().getStringExtra("nazwa");
        TextView ex_view = findViewById(R.id.exercise_name);

        System.out.println(exerciseName);
        ex_view.setText(exerciseName);

        for (DayData.ExerciseData data : useddayData.exercises){
            if(exerciseName.equals(data.name)) {
                exercise = data;
            }
        }

        nset1 = findViewById(R.id.set1);
        nset2 = findViewById(R.id.set2);
        nset3 = findViewById(R.id.set3);
        nset4 = findViewById(R.id.set4);
        nrepeat1 = findViewById(R.id.repeat1);
        nrepeat2 = findViewById(R.id.repeat2);
        nrepeat3 = findViewById(R.id.repeat3);
        nrepeat4 = findViewById(R.id.repeat4);
        nweight1 = findViewById(R.id.weight1);
        nweight2 = findViewById(R.id.weight2);
        nweight3 = findViewById(R.id.weight3);
        nweight4 = findViewById(R.id.weight4);
    }

    public void deleteExercise(View view){
        DayData.ExerciseData chosed = null;
        for (DayData.ExerciseData data : useddayData.exercises) {
            if (exerciseName.equals(data.name)){
                chosed = data;
                break;
            }
        }
        useddayData.exercises.remove(chosed);
        SharedPreferences sharedPref = this.getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        String txt = sharedPref.getString("dayData", "");
        if(txt.isEmpty()){
            return;}
        List<DayData> text = Arrays.asList(gson.fromJson(txt, DayData[].class));
        ArrayList<DayData> lista = new ArrayList<>();
        lista.addAll(text);
        ArrayList<DayData> dayData;
        dayData = lista;
        for (DayData day : dayData) {
            if (day.id==useddayData.id) {
                day.exercises=useddayData.exercises;
                break;
            }
        }
        List<DayData> lista1 = new ArrayList<DayData>();
        lista1.addAll(dayData);
        String json = new Gson().toJson(lista1);
        editor.putString("dayData",json);
        editor.apply();

        Intent intent2 = new Intent(this,exercises_activity.class);
        json = new Gson().toJson(useddayData);
        intent2.putExtra("Chosed", json);
        finish();
        //startActivity(intent2);

    }

    public void editExercises(View view){

        nset1.setEnabled(true);
        nset2.setEnabled(true);
        nset3.setEnabled(true);
        nset4.setEnabled(true);
        nrepeat1.setEnabled(true);
        nrepeat2.setEnabled(true);
        nrepeat3.setEnabled(true);
        nrepeat4.setEnabled(true);
        nweight1.setEnabled(true);
        nweight2.setEnabled(true);
        nweight3.setEnabled(true);
        nweight4.setEnabled(true);


    }


    public void saveExercises(View view){
        nset1.setEnabled(false);
        nset2.setEnabled(false);
        nset3.setEnabled(false);
        nset4.setEnabled(false);
        nrepeat1.setEnabled(false);
        nrepeat2.setEnabled(false);
        nrepeat3.setEnabled(false);
        nrepeat4.setEnabled(false);
        nweight1.setEnabled(false);
        nweight2.setEnabled(false);
        nweight3.setEnabled(false);
        nweight4.setEnabled(false);

    }

    public void addRow(View view){
        if(nset1.isEnabled()) {
            //System.out.println("PIERWSZA PETLA");
            //System.out.println(nset2.getText().toString());
            //System.out.println("empty");
            if (nset2.getText().toString().equals("empty")) {
                //System.out.println("PIERWSZY IF");
                nset2.setText("");
                nset2.setVisibility(View.VISIBLE);
                nrepeat2.setText("");
                nrepeat2.setVisibility(View.VISIBLE);
                nweight2.setText("");
                nweight2.setVisibility(View.VISIBLE);
            } else if (nset3.getText().toString().equals("empty")) {
                nset3.setText("");
                nset3.setVisibility(View.VISIBLE);
                nrepeat3.setText("");
                nrepeat3.setVisibility(View.VISIBLE);
                nweight3.setText("");
                nweight3.setVisibility(View.VISIBLE);
            } else if (nset4.getText().toString().equals("empty")) {
                nset4.setText("");
                nset4.setVisibility(View.VISIBLE);
                nrepeat4.setText("");
                nrepeat4.setVisibility(View.VISIBLE);
                nweight4.setText("");
                nweight4.setVisibility(View.VISIBLE);
            }
        }
    }

    public void hideRow(View view){

        if(nset1.isEnabled()) {
            if (nset4.getVisibility() == View.VISIBLE) {
                nset4.setText("empty");
                nset4.setVisibility(View.INVISIBLE);
                nrepeat4.setText("empty");
                nrepeat4.setVisibility(View.INVISIBLE);
                nweight4.setText("empty");
                nweight4.setVisibility(View.INVISIBLE);
            } else if (nset3.getVisibility() == View.VISIBLE) {
                nset3.setText("empty");
                nset3.setVisibility(View.INVISIBLE);
                nrepeat3.setText("empty");
                nrepeat3.setVisibility(View.INVISIBLE);
                nweight3.setText("empty");
                nweight3.setVisibility(View.INVISIBLE);
            } else if (nset2.getVisibility() == View.VISIBLE) {
                nset2.setText("empty");
                nset2.setVisibility(View.INVISIBLE);
                nrepeat2.setText("empty");
                nrepeat2.setVisibility(View.INVISIBLE);
                nweight2.setText("empty");
                nweight2.setVisibility(View.INVISIBLE);
            }
        }
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
