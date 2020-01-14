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
import android.widget.LinearLayout;

public class exercises_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_activity);
    }

    public void newActivity(){
        Intent intent2 = new Intent(this,ExDisp_activity.class);
        startActivity(intent2);
    }



    public void addExercise(View view){

        final Button button = new Button(this);
        final LinearLayout layout = findViewById(R.id.linearExercises);
        final EditText inputName = new EditText(this);
        button.setMinimumHeight(200);
        button.setTextSize(24);


        //Dodawanie nowych cwiczen
        inputName.setInputType(InputType.TYPE_CLASS_TEXT);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Enter exercise name:")
                .setCancelable(false)
                .setView(inputName)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        button.setText(inputName.getText());
                        layout.addView(button);
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

}
