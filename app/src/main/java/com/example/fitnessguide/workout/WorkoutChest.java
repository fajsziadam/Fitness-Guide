package com.example.fitnessguide.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class WorkoutChest extends AppCompatActivity {
    private CardView chest1,chest2,chest3,chest4;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_chest);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_workout_chest;
        showButtons();

        chest1.setOnClickListener(v -> {
                setContentView(R.layout.workout_chest1);
                currentLayoutId = R.layout.workout_chest1;
        });
        chest2.setOnClickListener(v -> {
                setContentView(R.layout.workout_chest2);
                currentLayoutId = R.layout.workout_chest2;
        });
        chest3.setOnClickListener(v -> {
                setContentView(R.layout.workout_chest3);
                currentLayoutId = R.layout.workout_chest3;
        });
        chest4.setOnClickListener(v -> {
                setContentView(R.layout.workout_chest4);
                currentLayoutId = R.layout.workout_chest4;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_workout_chest) {
            Intent chest = new Intent(WorkoutChest.this, WorkoutChest.class);
            currentLayoutId = R.layout.activity_workout_chest;
            startActivity(chest);
            finish();
        } else {
            super.onBackPressed();
        }
    }

    private void showButtons() {
        chest1 = findViewById(R.id.chest1);
        chest2 = findViewById(R.id.chest2);
        chest3 = findViewById(R.id.chest3);
        chest4 = findViewById(R.id.chest4);
    }
}