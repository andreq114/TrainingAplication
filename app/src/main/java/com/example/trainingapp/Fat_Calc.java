package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Fat_Calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_calc);
    }
    public void calculateFat(View view) {
        TextView weightName = findViewById(R.id.fatWeight);
        TextView waistName = findViewById(R.id.fatWaist);
        Integer weight = Integer.parseInt(weightName.getText().toString());
        Integer waist = Integer.parseInt(waistName.getText().toString());
        Double fat = (( 1.634 * waist - 0.1804 * weight - 98.42 ) / 2.2 * weight) * 100;
        TextView result = findViewById(R.id.fatResult);
        result.setText(String.format("%.2f", fat));

    }
}
