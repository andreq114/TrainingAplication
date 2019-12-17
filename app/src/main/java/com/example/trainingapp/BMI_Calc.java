package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
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

    private String[] weightDescription =
            {"Underweight", "Normal weight", "Overweight", "Obese", "Morbidly Obese"};

    public void calculateBMI(View view) {
        TextView weight = findViewById(R.id.bmiWeight);
        TextView growth = findViewById(R.id.bmiGrowth);
        Integer a = Integer.parseInt(weight.getText().toString());
        Double b = Double.parseDouble(growth.getText().toString());
        Double bmi = a / pow(b / 100, 2);
        TextView result = findViewById(R.id.bmiResult);
        result.setText(String.format("%.2f",bmi));


        TextView desc = findViewById(R.id.weightDesc);
        desc.setText(chooseDecription(bmi));


    }

    private String chooseDecription(Double bmi) {           //Wybieranie opisu i koloru na podstawie bmi
        String description;
        TextView desc = findViewById(R.id.weightDesc);
        if (bmi < 18.5) {
            description = weightDescription[0];
            desc.setTextColor(Color.RED);
        } else if (bmi >= 18.5 && bmi < 25) {
            description = weightDescription[1];
            desc.setTextColor(Color.BLUE);
        } else if (bmi >= 25 && bmi < 30) {
            description = weightDescription[2];
            desc.setTextColor(Color.GREEN);
        } else if (bmi >= 30 && bmi < 40) {
            description = weightDescription[3];
            desc.setTextColor(Color.YELLOW);
        } else {
            description = weightDescription[4];
            desc.setTextColor(Color.RED);
        }
        return description;
    }
}
