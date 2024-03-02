package com.example.fitnessguide.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class GymShoulder extends AppCompatActivity {
    private CardView shoulder1,shoulder2,shoulder3,shoulder4, shoulder5;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_shoulder);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_gym_shoulder;
        showButtons();

        shoulder1.setOnClickListener(v -> {
                setContentView(R.layout.gym_shoulder_vallbolnyomas);
                currentLayoutId = R.layout.gym_shoulder_vallbolnyomas;
        });
        shoulder2.setOnClickListener(v -> {
                setContentView(R.layout.gym_shoulder_oldalraemeles);
                currentLayoutId = R.layout.gym_shoulder_oldalraemeles;
        });
        shoulder3.setOnClickListener(v -> {
                setContentView(R.layout.gym_shoulder_eloreemeles);
                currentLayoutId = R.layout.gym_shoulder_eloreemeles;
        });
        shoulder4.setOnClickListener(v -> {
                setContentView(R.layout.gym_shoulder_allighuzas);
                currentLayoutId = R.layout.gym_shoulder_allighuzas;
        });
        shoulder5.setOnClickListener(v -> {
            setContentView(R.layout.gym_shoulder_vallvonogatas);
            currentLayoutId = R.layout.gym_shoulder_vallvonogatas;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_gym_shoulder) {
            Intent shoulder = new Intent(GymShoulder.this, GymShoulder.class);
            currentLayoutId = R.layout.activity_gym_shoulder;
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
        shoulder5 = findViewById(R.id.shoulder5);
    }
}