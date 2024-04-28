package com.example.fitnessguide.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class WorkoutLeg extends AppCompatActivity {
    private CardView leg1,leg2,leg3;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_leg);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_workout_leg;
        showButtons();

        leg1.setOnClickListener(v -> {
                setContentView(R.layout.workout_leg_guggolas);
                currentLayoutId = R.layout.workout_leg_guggolas;
        });
        leg2.setOnClickListener(v -> {
                setContentView(R.layout.workout_leg_kitores);
                currentLayoutId = R.layout.workout_leg_kitores;
        });
        leg3.setOnClickListener(v -> {
                setContentView(R.layout.workout_leg_allovadli);
                currentLayoutId = R.layout.workout_leg_allovadli;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_workout_leg) {
            Intent leg = new Intent(WorkoutLeg.this, WorkoutLeg.class);
            currentLayoutId = R.layout.activity_workout_leg;
            startActivity(leg);
            finish();
        } else {
            super.onBackPressed();
        }
    }

    private void showButtons() {
        leg1 = findViewById(R.id.leg1);
        leg2 = findViewById(R.id.leg2);
        leg3 = findViewById(R.id.leg3);
    }
}