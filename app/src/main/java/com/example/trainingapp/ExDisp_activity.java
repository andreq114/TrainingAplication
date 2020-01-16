package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ExDisp_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_disp_activity);
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

        EditText set5 = findViewById(R.id.set5);
        set5.setEnabled(true);
        set5.setTextColor(Color.BLACK);

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

        EditText repeat5= findViewById(R.id.repeat5);
        repeat5.setEnabled(true);
        repeat5.setTextColor(Color.BLACK);

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

        EditText weight5 = findViewById(R.id.weight5);
        weight5.setEnabled(true);
        weight5.setTextColor(Color.BLACK);

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

        EditText set5 = findViewById(R.id.set5);
        set5.setEnabled(false);
        set5.setTextColor(Color.BLACK);

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

        EditText repeat5 = findViewById(R.id.repeat5);
        repeat5.setEnabled(false);
        repeat5.setTextColor(Color.BLACK);

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

        EditText weight5 = findViewById(R.id.weight5);
        weight5.setEnabled(false);
        weight5.setTextColor(Color.BLACK);



    }
}
