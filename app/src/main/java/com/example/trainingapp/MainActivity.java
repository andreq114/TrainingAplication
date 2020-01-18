package com.example.trainingapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    SharedPreferences.Editor editor;

    int actualDays = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        editor = shared.edit();

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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
            case R.id.locale:
                editor.putString("Language","pl");
                editor.apply();
                finish();
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            default:
                return super.onContextItemSelected(item);
        }
        return true;

    }

    public void newActivity(){
        Intent intent = new Intent(this,exercises_activity.class);
        startActivity(intent);
    }



    public void addDay(View view){

        final EditText inputName = new EditText(this);
        final Button button;
        switch(actualDays){
            case 0:
                button = findViewById(R.id.day1);
                actualDays++;
                break;
            case 1:
                button = findViewById(R.id.day2);
                actualDays++;
                break;
            case 2:
                button = findViewById(R.id.day3);
                actualDays++;
                break;
            case 3:
                button = findViewById(R.id.day4);
                actualDays++;
                break;
            case 4:
                button = findViewById(R.id.day5);
                actualDays++;
                break;
            case 5:
                button = findViewById(R.id.day6);
                actualDays++;
                break;
            case 6:
                button = findViewById(R.id.day7);
                actualDays++;
                break;
            default:
                button = findViewById(R.id.day1);
                actualDays++;

        }

                          //Dodawanie dni treningowych
        inputName.setInputType(InputType.TYPE_CLASS_TEXT);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Enter routine name:")
                .setCancelable(false)
                .setView(inputName)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        button.setText(inputName.getText());


                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alert.show();
    }

}
