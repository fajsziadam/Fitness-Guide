package com.example.fitnessguide.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ViewSwitcher;

import com.example.fitnessguide.R;

public class WorkoutTriceps extends AppCompatActivity {

    private CardView triceps1,triceps2,triceps3,triceps4;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_triceps);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_workout_triceps;

        showButtons();

        triceps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_triceps1);
                currentLayoutId = R.layout.workout_triceps1;
            }
        });
        triceps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_triceps2);
                currentLayoutId = R.layout.workout_triceps2;
            }
        });
        triceps3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_triceps3);
                currentLayoutId = R.layout.workout_triceps3;
            }
        });
        triceps4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_triceps4);
                currentLayoutId = R.layout.workout_triceps4;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_workout_triceps) {
            Intent triceps = new Intent(WorkoutTriceps.this, WorkoutTriceps.class);//Azért kellett ez a megoldás mert nem az edzésekhez,
            currentLayoutId = R.layout.activity_workout_triceps;                         //hanem az izomcsoportokhoz ment vissza a vissza gombbal
            startActivity(triceps);
            finish();
        } else {
            super.onBackPressed();
        }
    }
    private void showButtons() {
        triceps1 = findViewById(R.id.triceps1);
        triceps2 = findViewById(R.id.triceps2);
        triceps3 = findViewById(R.id.triceps3);
        triceps4 = findViewById(R.id.triceps4);
    }
}