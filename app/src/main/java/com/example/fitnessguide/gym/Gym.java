package com.example.fitnessguide.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.fitnessguide.R;

public class Gym extends AppCompatActivity {
        private ImageButton btnChestGym, btnShoulderGym, btnBicepsGym, btnTricepsGym, btnBackGym, btnAbsGym, btnLegGym;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        showButtons();

        btnChestGym.setOnClickListener( v -> {
            Intent chest = new Intent(Gym.this, GymChest.class);
            startActivity(chest);
        });

        btnShoulderGym.setOnClickListener( v -> {
            Intent shoulder = new Intent(Gym.this, GymShoulder.class);
            startActivity(shoulder);
        });
        btnBicepsGym.setOnClickListener(v -> {
                Intent biceps = new Intent(Gym.this, GymBiceps.class);
                startActivity(biceps);
        });

        btnTricepsGym.setOnClickListener( v -> {
                Intent triceps = new Intent(Gym.this, GymTriceps.class);
                startActivity(triceps);
        });

        btnBackGym.setOnClickListener(v -> {
                Intent back = new Intent(Gym.this, GymBack.class);
                startActivity(back);
        });

        btnAbsGym.setOnClickListener(v -> {
                Intent abs = new Intent(Gym.this, GymAbs.class);
                startActivity(abs);
        });

        btnLegGym.setOnClickListener(v -> {
                Intent leg = new Intent(Gym.this, GymLeg.class);
                startActivity(leg);
        });
    }
    private void showButtons() {

        btnChestGym = findViewById(R.id.btnChestGym);
        btnShoulderGym = findViewById(R.id.btnShoulderGym);
        btnBicepsGym = findViewById(R.id.btnBicepsGym);
        btnTricepsGym = findViewById(R.id.btnTricepsGym);
        btnBackGym = findViewById(R.id.btnBackGym);
        btnAbsGym = findViewById(R.id.btnAbsGym);
        btnLegGym = findViewById(R.id.btnLegGym);
    }
}