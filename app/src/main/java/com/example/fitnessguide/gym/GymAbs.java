package com.example.fitnessguide.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class GymAbs extends AppCompatActivity {
    private CardView abs1,abs2,abs3,abs4;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_abs);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_gym_abs;
        showButtons();

        abs1.setOnClickListener(v -> {
                setContentView(R.layout.gym_abs1);
                currentLayoutId = R.layout.gym_abs1;
        });
        abs2.setOnClickListener(v -> {
                setContentView(R.layout.gym_abs2);
                currentLayoutId = R.layout.gym_abs2;
        });
        abs3.setOnClickListener(v -> {
                setContentView(R.layout.gym_abs3);
                currentLayoutId = R.layout.gym_abs3;
        });
        abs4.setOnClickListener(v -> {
                setContentView(R.layout.gym_abs4);
                currentLayoutId = R.layout.gym_abs4;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_gym_abs) {
            Intent abs = new Intent(GymAbs.this, GymAbs.class);
            currentLayoutId = R.layout.activity_gym_abs;
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