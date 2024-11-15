package com.example.fitnessguide.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

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

        triceps1.setOnClickListener(v -> {
                setContentView(R.layout.workout_triceps_tolodzkodas);
                currentLayoutId = R.layout.workout_triceps_tolodzkodas;
        });
        triceps2.setOnClickListener(v -> {
                setContentView(R.layout.workout_triceps_szukfekvo);
                currentLayoutId = R.layout.workout_triceps_szukfekvo;
        });
        triceps3.setOnClickListener(v -> {
                setContentView(R.layout.workout_triceps_hatsotolodzkodo);
                currentLayoutId = R.layout.workout_triceps_hatsotolodzkodo;
        });
        triceps4.setOnClickListener(v -> {
                setContentView(R.layout.workout_triceps_fekvotamasz);
                currentLayoutId = R.layout.workout_triceps_fekvotamasz;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_workout_triceps) {
            Intent triceps = new Intent(WorkoutTriceps.this, WorkoutTriceps.class);
            currentLayoutId = R.layout.activity_workout_triceps;
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