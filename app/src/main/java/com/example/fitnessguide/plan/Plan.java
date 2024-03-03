package com.example.fitnessguide.plan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;


import com.example.fitnessguide.R;

public class Plan extends AppCompatActivity {

    Button btn2DayWorkout, btnAllDayWorkout, btn3DayGym, btn5DayGym, ownPlan;
    ImageView plan3DayGym, plan5DayGym, planAllDayWorkout, plan2DayWorkout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn2DayWorkout = findViewById(R.id.btn2DayWorkout);
        btnAllDayWorkout = findViewById(R.id.btnAllDayWorkout);
        btn3DayGym = findViewById(R.id.btn3DayGym);
        btn5DayGym = findViewById(R.id.btn5DayGym);

        plan3DayGym = findViewById(R.id.plan3DayGym);
        plan5DayGym = findViewById(R.id.plan5DayGym);
        planAllDayWorkout = findViewById(R.id.planAllDayWorkout);
        plan2DayWorkout = findViewById(R.id.plan2DayWorkout);

        ownPlan = findViewById(R.id.ownPlan);


        //Gym plans:
        btn3DayGym.setOnClickListener(v -> is_visible(plan3DayGym));
        btn5DayGym.setOnClickListener(v -> is_visible(plan5DayGym));

        //Workout plans:
        btn2DayWorkout.setOnClickListener(v -> is_visible(plan2DayWorkout));
        btnAllDayWorkout.setOnClickListener(v -> is_visible(planAllDayWorkout));

        ownPlan.setOnClickListener(v -> {
            Intent intent = new Intent(Plan.this, OwnPlan.class);
            startActivity(intent);
        });

    }

    public void is_visible(View a) {
        if (a.getVisibility() == View.VISIBLE) {
            a.setVisibility(View.GONE);
        } else {
            a.setVisibility(View.VISIBLE);
        }
    }
}