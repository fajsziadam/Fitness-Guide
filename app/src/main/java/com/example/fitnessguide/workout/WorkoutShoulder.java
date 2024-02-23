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

        shoulder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_shoulder1);
                currentLayoutId = R.layout.workout_shoulder1;
            }
        });
        shoulder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_shoulder2);
                currentLayoutId = R.layout.workout_shoulder2;
            }
        });
        shoulder3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_shoulder3);
                currentLayoutId = R.layout.workout_shoulder3;
            }
        });
        shoulder4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_shoulder4);
                currentLayoutId = R.layout.workout_shoulder4;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_workout_shoulder) {
            Intent shoulder = new Intent(WorkoutShoulder.this, WorkoutShoulder.class);//Azért kellett ez a megoldás mert nem az edzésekhez,
            currentLayoutId = R.layout.activity_workout_shoulder;                         //hanem az izomcsoportokhoz ment vissza a vissza gombbal
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