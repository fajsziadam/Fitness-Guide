package com.example.fitnessguide.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class GymBack extends AppCompatActivity {
    private CardView back1,back2,back3,back4,back5;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_back);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_gym_back;
        showButtons();

        back1.setOnClickListener(v -> {
                setContentView(R.layout.gym_back_mellhezhuzas);
                currentLayoutId = R.layout.gym_back_mellhezhuzas;
        });
        back2.setOnClickListener(v -> {
                setContentView(R.layout.gym_back_trudas);
                currentLayoutId = R.layout.gym_back_trudas;
        });
        back3.setOnClickListener(v -> {
                setContentView(R.layout.gym_back_kabelesevezes);
                currentLayoutId = R.layout.gym_back_kabelesevezes;
        });
        back4.setOnClickListener(v -> {
                setContentView(R.layout.gym_back_egykezesevezes);
                currentLayoutId = R.layout.gym_back_egykezesevezes;
        });
        back5.setOnClickListener(v -> {
            setContentView(R.layout.gym_back_vallvonogatas);
            currentLayoutId = R.layout.gym_back_vallvonogatas;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_gym_back) {
            Intent back = new Intent(GymBack.this, GymBack.class);
            currentLayoutId = R.layout.activity_gym_back;
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
        back4 = findViewById(R.id.back4);
        back5 = findViewById(R.id.back5);
    }
}