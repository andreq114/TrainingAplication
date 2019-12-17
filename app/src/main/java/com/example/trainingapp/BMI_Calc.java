package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Math.pow;

public class BMI_Calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__calc);
    }

    public void calculateBMI(View view){
        TextView weight = findViewById(R.id.bmiWeight);
        TextView growth = findViewById(R.id.bmiGrowth);
        Integer a = Integer.parseInt(weight.getText().toString());
        Double b = Double.parseDouble(growth.getText().toString());
        Double bmi = a/pow(b/100,2);
        TextView result = findViewById(R.id.bmiResult);
        result.setText(bmi.toString());


    }
}
