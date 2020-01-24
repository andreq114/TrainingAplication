package com.example.trainingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exercises_activity extends AppCompatActivity {

    int setExercises = 0;
    ArrayList<Button> buttons;
    DayData useddayData;
    ArrayList<DayData> dayData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_activity);
        String name = getIntent().getStringExtra("Chosed");
        useddayData = new Gson().fromJson(name, DayData.class);


        buttons = new ArrayList<>();
        buttons.add((Button)findViewById(R.id.ex1));
        buttons.add((Button)findViewById(R.id.ex2));
        buttons.add((Button)findViewById(R.id.ex3));
        buttons.add((Button)findViewById(R.id.ex4));
        buttons.add((Button)findViewById(R.id.ex5));
        buttons.add((Button)findViewById(R.id.ex6));
        buttons.add((Button)findViewById(R.id.ex7));
        buttons.add((Button)findViewById(R.id.ex8));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setExercises= useddayData.excercisesSet;
        TextView label = findViewById(R.id.exerciseLabel);
        label.setText(useddayData.nameButton);
        final Intent intent2 = new Intent(this,ExDisp_activity.class);
        Short i = 0;
        ArrayList<String> lista = useddayData.exercises;
        for(final Button button : buttons) {
            try {
                System.out.println("Poszlo");
                button.setOnClickListener(null);
                button.setVisibility(View.INVISIBLE);
                String excercise = lista.get(i);
                button.setText(excercise);
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Add your code in here!
                        newActivity(useddayData,button.getText().toString());
                    }
                });
                i++;

            }catch(Exception ex){
                break;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPref = this.getSharedPreferences("myPreferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        useddayData.excercisesSet=setExercises;
        Gson gson = new Gson();
        String txt = sharedPref.getString("dayData", "");
        if(txt.isEmpty()){
            System.out.println("winowajca2");return;}

        List<DayData> text = Arrays.asList(gson.fromJson(txt, DayData[].class));
        ArrayList<DayData> lista = new ArrayList<>();
        lista.addAll(text);
        dayData = lista;
        for (DayData day : dayData) {
            System.out.println(day.id+" uzywane; "+useddayData.id);
            if (day.id==useddayData.id) {
                day.exercises=useddayData.exercises;
                System.out.println(" znalazl "+day.exercises);
                break;
            }
        }
        List<DayData> lista1 = new ArrayList<DayData>();
        lista1.addAll(dayData);
        String json = new Gson().toJson(lista1);
        editor.putString("dayData",json);
        editor.apply();
    }

    public void newActivity(DayData dayData,String name){
        Intent intent2 = new Intent(this,ExDisp_activity.class);
        String json = new Gson().toJson(dayData);
        intent2.putExtra("dayData_Excercises", json);
        intent2.putExtra("nazwa",name);
        startActivity(intent2);
    }

    public void deleteDay(View view){
        final Intent intent = new Intent(this,MainActivity.class);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(getResources().getString(R.string.deleteAlert))
                .setCancelable(false)
                .setPositiveButton(getResources().getString(R.string.confirmDialog), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String json = new Gson().toJson(useddayData);
                        intent.putExtra("Deleted", json);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(getResources().getString(R.string.cancelDialog), new DialogInterface.OnClickListener() {
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
        alert.setMessage(getResources().getString(R.string.enterName))
                .setCancelable(false)
                .setView(inputName)
                .setPositiveButton(getResources().getString(R.string.confirmDialog), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        button.setText(inputName.getText());
                        button.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                newActivity(useddayData,button.getText().toString());
                            }
                        });
                        setExercises++;
                        useddayData.exercises.add(inputName.getText().toString());
                        newActivity(useddayData,button.getText().toString());

                    }
                })
                .setNegativeButton(getResources().getString(R.string.cancelDialog), new DialogInterface.OnClickListener() {
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

                addExercise(button);
                break;
            case 1:
                button = findViewById(R.id.ex2);
                addExercise(button);
                break;
            case 2:
                button = findViewById(R.id.ex3);
                addExercise(button);
                break;
            case 3:
                button = findViewById(R.id.ex4);
                addExercise(button);
                break;
            case 4:
                button = findViewById(R.id.ex5);
                addExercise(button);
                break;
            case 5:
                button = findViewById(R.id.ex6);
                addExercise(button);
                break;
            case 6:
                button = findViewById(R.id.ex7);
                addExercise(button);
                break;
            case 7:
                button = findViewById(R.id.ex8);
                addExercise(button);
                break;
            default:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage(getResources().getString(R.string.maxExercisesAlert))
                        .setNegativeButton(getResources().getString(R.string.confirmDialog), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                alert.show();

        }


    }
}
