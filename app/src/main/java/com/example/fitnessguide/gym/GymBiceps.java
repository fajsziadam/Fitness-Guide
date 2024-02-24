package com.example.fitnessguide.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class GymBiceps extends AppCompatActivity {
    private CardView biceps1,biceps2,biceps3,biceps4;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_biceps);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_gym_biceps;
        showButtons();

        biceps1.setOnClickListener(v -> {
                setContentView(R.layout.gym_biceps1);
                currentLayoutId = R.layout.gym_biceps1;
        });
        biceps2.setOnClickListener(v -> {
                setContentView(R.layout.gym_biceps2);
                currentLayoutId = R.layout.gym_biceps2;
        });
        biceps3.setOnClickListener(v -> {
                setContentView(R.layout.gym_biceps3);
                currentLayoutId = R.layout.gym_biceps3;
        });
        biceps4.setOnClickListener(v -> {
                setContentView(R.layout.gym_biceps4);
                currentLayoutId = R.layout.gym_biceps4;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_gym_biceps) {
            Intent biceps = new Intent(GymBiceps.this, GymBiceps.class);
            currentLayoutId = R.layout.activity_gym_biceps;
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
        biceps4 = findViewById(R.id.biceps4);
    }
}