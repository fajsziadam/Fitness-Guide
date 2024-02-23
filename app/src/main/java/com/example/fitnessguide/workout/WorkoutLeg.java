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

public class WorkoutLeg extends AppCompatActivity {

    private CardView leg1,leg2,leg3,leg4;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_leg);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_workout_leg;

        showButtons();

        leg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_leg1);
                currentLayoutId = R.layout.workout_leg1;
            }
        });
        leg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_leg2);
                currentLayoutId = R.layout.workout_leg2;
            }
        });
        leg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_leg3);
                currentLayoutId = R.layout.workout_leg3;
            }
        });
        leg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.workout_leg4);
                currentLayoutId = R.layout.workout_leg4;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_workout_leg) {
            Intent leg = new Intent(WorkoutLeg.this, WorkoutLeg.class);//Azért kellett ez a megoldás mert nem az edzésekhez,
            currentLayoutId = R.layout.activity_workout_leg;                         //hanem az izomcsoportokhoz ment vissza a vissza gombbal
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
        leg4 = findViewById(R.id.leg4);
    }
}