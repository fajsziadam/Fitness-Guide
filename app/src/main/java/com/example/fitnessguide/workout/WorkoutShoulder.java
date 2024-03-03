package com.example.fitnessguide.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class WorkoutShoulder extends AppCompatActivity {
    private CardView shoulder1,shoulder2,shoulder3,shoulder4;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_shoulder);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_workout_shoulder;
        showButtons();

        shoulder1.setOnClickListener(v -> {
                setContentView(R.layout.workout_shoulder_bicskafekvotamasz);
                currentLayoutId = R.layout.workout_shoulder_bicskafekvotamasz;
        });
        shoulder2.setOnClickListener(v -> {
                setContentView(R.layout.workout_shoulder_bicskafekvoemeltlabak);
                currentLayoutId = R.layout.workout_shoulder_bicskafekvoemeltlabak;
        });
        shoulder3.setOnClickListener(v -> {
                setContentView(R.layout.workout_shoulder_oldalplank);
                currentLayoutId = R.layout.workout_shoulder_oldalplank;
        });
        shoulder4.setOnClickListener(v -> {
                setContentView(R.layout.workout_shoulder_fekvotamasz);
                currentLayoutId = R.layout.workout_shoulder_fekvotamasz;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_workout_shoulder) {
            Intent shoulder = new Intent(WorkoutShoulder.this, WorkoutShoulder.class);
            currentLayoutId = R.layout.activity_workout_shoulder;
            startActivity(shoulder);
            finish();
        } else {
            super.onBackPressed();
        }
    }

    private void showButtons() {
        shoulder1 = findViewById(R.id.shoulder1);
        shoulder2 = findViewById(R.id.shoulder2);
        shoulder3 = findViewById(R.id.shoulder3);
        shoulder4 = findViewById(R.id.shoulder4);
    }
}