package com.example.trainingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class exercises_activity extends AppCompatActivity {

    int setExercises = 0;
    int chosedExercises = 0;
    DayData dayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_activity);
        String name = getIntent().getStringExtra("Chosed");
        dayData = new Gson().fromJson(name, DayData.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void newActivity(){
        Intent intent2 = new Intent(this,ExDisp_activity.class);
        startActivity(intent2);
    }

    public void deleteDay(View view){
        final Intent intent = new Intent(this,MainActivity.class);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Do you really want to delete this day?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String json = new Gson().toJson(dayData);
                        intent.putExtra("Deleted", json);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alert.show();
    }

    public void addExercise(final Button button){

        final EditText inputName = new EditText(this);
        //Dodawanie nowych cwiczen
        inputName.setInputType(InputType.TYPE_CLASS_TEXT);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Enter exercise name:")
                .setCancelable(false)
                .setView(inputName)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        button.setText(inputName.getText());
                        button.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                newActivity();
                            }
                        });

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alert.show();
    }
    public void addExcercise(View view){

        final Button button;
        switch(setExercises){
            case 0:
                button = findViewById(R.id.ex1);
                setExercises++;
                chosedExercises = 0;
                addExercise(button);
                break;
            case 1:
                button = findViewById(R.id.ex2);
                setExercises++;
                chosedExercises = 1;
                addExercise(button);
                break;
            case 2:
                button = findViewById(R.id.ex3);
                setExercises++;
                chosedExercises = 2;
                addExercise(button);
                break;
            case 3:
                button = findViewById(R.id.ex4);
                setExercises++;
                chosedExercises = 3;
                addExercise(button);
                break;
            case 4:
                button = findViewById(R.id.ex5);
                setExercises++;
                chosedExercises = 4;
                addExercise(button);
                break;
            case 5:
                button = findViewById(R.id.ex6);
                setExercises++;
                chosedExercises = 5;
                addExercise(button);
                break;
            case 6:
                button = findViewById(R.id.ex7);
                setExercises++;
                chosedExercises = 6;
                addExercise(button);
                break;
            case 7:
                button = findViewById(R.id.ex8);
                setExercises++;
                chosedExercises = 7;
                addExercise(button);
                break;
            default:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("Osiągnięto maksymalną liczbe cwiczen.")
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                alert.show();

        }


    }
}
