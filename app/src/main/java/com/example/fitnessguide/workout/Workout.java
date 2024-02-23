package com.example.fitnessguide.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.fitnessguide.R;
import com.example.fitnessguide.plan.Plan;

public class Workout extends AppCompatActivity {
    private ImageButton btnChest, btnShoulder, btnBiceps, btnTriceps, btnBack, btnAbs, btnLeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        showButtons();

        btnChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chest = new Intent(Workout.this, WorkoutChest.class);
                startActivity(chest);
            }
        });

        btnShoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shoulder = new Intent(Workout.this, WorkoutShoulder.class);
                startActivity(shoulder);
            }
        });

        btnBiceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent biceps = new Intent(Workout.this, WorkoutBiceps.class);
                startActivity(biceps);
            }
        });

        btnTriceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent triceps = new Intent(Workout.this, WorkoutTriceps.class);
                startActivity(triceps);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Workout.this, WorkoutBack.class);
                startActivity(back);
            }
        });

        btnAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abs = new Intent(Workout.this, WorkoutAbs.class);
                startActivity(abs);
            }
        });

        btnLeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leg = new Intent(Workout.this, WorkoutLeg.class);
                startActivity(leg);
            }
        });

    }

    private void showButtons() {

        btnChest = findViewById(R.id.btnChest);
        btnShoulder = findViewById(R.id.btnShoulder);
        btnBiceps = findViewById(R.id.btnBiceps);
        btnTriceps = findViewById(R.id.btnTriceps);
        btnBack = findViewById(R.id.btnBack);
        btnAbs = findViewById(R.id.btnAbs);
        btnLeg = findViewById(R.id.btnLeg);



    }



}