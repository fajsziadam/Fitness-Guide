package com.example.fitnessguide.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class WorkoutBiceps extends AppCompatActivity {
    private CardView biceps1,biceps2,biceps3;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_biceps);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_workout_biceps;
        showButtons();

        biceps1.setOnClickListener(v -> {
                setContentView(R.layout.workout_biceps_huzodzkodas);
                currentLayoutId = R.layout.workout_biceps_huzodzkodas;
        });
        biceps2.setOnClickListener(v -> {
                setContentView(R.layout.workout_biceps_dontotttorzsuevezes);
                currentLayoutId = R.layout.workout_biceps_dontotttorzsuevezes;
        });
        biceps3.setOnClickListener(v -> {
                setContentView(R.layout.workout_biceps_forditotttenyerfekvo);
                currentLayoutId = R.layout.workout_biceps_forditotttenyerfekvo;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_workout_biceps) {
            Intent biceps = new Intent(WorkoutBiceps.this, WorkoutBiceps.class);
            currentLayoutId = R.layout.activity_workout_biceps;
            startActivity(biceps);
            finish();
        } else {
            super.onBackPressed();
        }
    }

    private void showButtons() {
        biceps1 = findViewById(R.id.biceps1);
        biceps2 = findViewById(R.id.biceps2);
        biceps3 = findViewById(R.id.biceps3);
    }
}