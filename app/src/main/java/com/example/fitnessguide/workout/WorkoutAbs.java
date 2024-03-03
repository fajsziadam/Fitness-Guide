package com.example.fitnessguide.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class WorkoutAbs extends AppCompatActivity {
    private CardView abs1,abs2,abs3,abs4;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_abs);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_workout_abs;
        showButtons();

        abs1.setOnClickListener(v -> {
                setContentView(R.layout.workout_abs_felules);
                currentLayoutId = R.layout.workout_abs_felules;
        });
        abs2.setOnClickListener(v -> {
                setContentView(R.layout.workout_abs_labemeles);
                currentLayoutId = R.layout.workout_abs_labemeles;
        });
        abs3.setOnClickListener(v -> {
                setContentView(R.layout.workout_abs_haspres);
                currentLayoutId = R.layout.workout_abs_haspres;
        });
        abs4.setOnClickListener(v -> {
                setContentView(R.layout.workout_abs_plank);
                currentLayoutId = R.layout.workout_abs_plank;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_workout_abs) {
            Intent abs = new Intent(WorkoutAbs.this, WorkoutAbs.class);
            currentLayoutId = R.layout.activity_workout_abs;
            startActivity(abs);
            finish();
        } else {
            super.onBackPressed();
        }
    }

    private void showButtons() {
        abs1 = findViewById(R.id.abs1);
        abs2 = findViewById(R.id.abs2);
        abs3 = findViewById(R.id.abs3);
        abs4 = findViewById(R.id.abs4);
    }
}