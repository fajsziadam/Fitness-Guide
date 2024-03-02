package com.example.fitnessguide.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class GymTriceps extends AppCompatActivity {
    private CardView triceps1,triceps2,triceps3,triceps4;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_triceps);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_gym_triceps;
        showButtons();

        triceps1.setOnClickListener(v -> {
                setContentView(R.layout.gym_triceps_letolaskotellel);
                currentLayoutId = R.layout.gym_triceps_letolaskotellel;
        });
        triceps2.setOnClickListener(v -> {
                setContentView(R.layout.gym_triceps_letolasruddal);
                currentLayoutId = R.layout.gym_triceps_letolasruddal;
        });
        triceps3.setOnClickListener(v -> {
                setContentView(R.layout.gym_triceps_tricepsznyujtasfekve);
                currentLayoutId = R.layout.gym_triceps_tricepsznyujtasfekve;
        });
        triceps4.setOnClickListener(v -> {
                setContentView(R.layout.gym_triceps_tricepsznyujtasallva);
                currentLayoutId = R.layout.gym_triceps_tricepsznyujtasallva;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_gym_triceps) {
            Intent triceps = new Intent(GymTriceps.this, GymTriceps.class);
            currentLayoutId = R.layout.activity_gym_triceps;
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