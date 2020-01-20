package com.example.trainingapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Button> buttons;
    ArrayList<DayData> dayData;
    int setDays = 0;
    int choosedDay = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dayData = new ArrayList<DayData>();
        buttons = new ArrayList<>();
        buttons.add((Button)findViewById(R.id.day1));
        buttons.add((Button)findViewById(R.id.day2));
        buttons.add((Button)findViewById(R.id.day3));
        buttons.add((Button)findViewById(R.id.day4));
        buttons.add((Button)findViewById(R.id.day5));
        buttons.add((Button)findViewById(R.id.day6));
        buttons.add((Button)findViewById(R.id.day7));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent intent;
        switch (item.getItemId()) {
            case R.id.kalkulator_BMI:
                intent = new Intent(this,BMI_Calc.class);
                startActivity(intent);
                break;
            case R.id.kalkulator_BMR:
                intent = new Intent(this,BMR_Calc.class);
                startActivity(intent);
                break;
            case R.id.kalkulator_tluszcz:
                intent = new Intent(this,Fat_Calc.class);
                startActivity(intent);
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;

    }

    public void newActivity(int choosed){
        Intent intent = new Intent(this,exercises_activity.class);
        intent.putExtra("Chosed",choosed);
        startActivity(intent);
    }

    void addDayName(Button button){
        final EditText inputName = new EditText(this);
        final Button button1 = button;
        final DayData day = new DayData();
        inputName.setInputType(InputType.TYPE_CLASS_TEXT);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Enter routine name:")
                .setCancelable(false)
                .setView(inputName)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        button1.setText(inputName.getText());
                        button1.setVisibility(View.VISIBLE);
                        day.nameButton = inputName.getText().toString();
                        dayData.add(day);
                        newActivity(choosedDay);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alert.show();
    }


    public void addDay(View view){

        final Button button;
        switch(setDays){
            case 0:
                button = findViewById(R.id.day1);
                setDays++;
                choosedDay = 0;
                addDayName(button);
                break;
            case 1:
                button = findViewById(R.id.day2);
                setDays++;
                choosedDay = 1;
                addDayName(button);
                break;
            case 2:
                button = findViewById(R.id.day3);
                setDays++;
                choosedDay = 2;
                addDayName(button);
                break;
            case 3:
                button = findViewById(R.id.day4);
                setDays++;
                choosedDay = 3;
                addDayName(button);
                break;
            case 4:
                button = findViewById(R.id.day5);
                setDays++;
                choosedDay = 4;
                addDayName(button);
                break;
            case 5:
                button = findViewById(R.id.day6);
                setDays++;
                choosedDay = 5;
                addDayName(button);
                break;
            case 6:
                button = findViewById(R.id.day7);
                setDays++;
                choosedDay = 6;
                addDayName(button);
                break;
            default:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("Osiągnięto maksymalną liczbe dni treningowych.")
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                alert.show();

        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        List<DayData> lista = new ArrayList<DayData>();
        lista.addAll(dayData);
        String json = new Gson().toJson(lista);
        editor.putString("dayData",json);
        editor.putInt("actualSetDays", setDays);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String txt = sharedPref.getString("dayData", "");
        if(txt.isEmpty())
            return;
        List<DayData> text = Arrays.asList(gson.fromJson(txt, DayData[].class));
        ArrayList<DayData> lista = new ArrayList<>();
        lista.addAll(text);
        Short i = 0;
        for(Button button : buttons) {
            try {
                button.setText(lista.get(i).nameButton);
                button.setVisibility(View.VISIBLE);
                i++;
            }catch(Exception ex){
                break;
            }
        }
        setDays = sharedPref.getInt("actualSetDays", 0);
    }
}
