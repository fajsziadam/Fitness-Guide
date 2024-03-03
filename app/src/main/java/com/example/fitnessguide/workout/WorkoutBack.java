package com.example.fitnessguide.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class WorkoutBack extends AppCompatActivity {
    private CardView back1,back2,back3;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_back);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_workout_back;
        showButtons();

        back1.setOnClickListener(v -> {
                setContentView(R.layout.workout_back_huzodzkodas);
                currentLayoutId = R.layout.workout_back_huzodzkodas;
        });
        back2.setOnClickListener(v -> {
                setContentView(R.layout.workout_back_dontotttorzsuevezes);
                currentLayoutId = R.layout.workout_back_dontotttorzsuevezes;
        });
        back3.setOnClickListener(v -> {
                setContentView(R.layout.workout_back_fekvotamasz);
                currentLayoutId = R.layout.workout_back_fekvotamasz;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_workout_back) {
            Intent back = new Intent(WorkoutBack.this, WorkoutBack.class);
            currentLayoutId = R.layout.activity_workout_back;
            startActivity(back);
            finish();
        } else {
            super.onBackPressed();
        }
    }

    private void showButtons() {
        back1 = findViewById(R.id.back1);
        back2 = findViewById(R.id.back2);
        back3 = findViewById(R.id.back3);
    }
}