package com.example.fitnessguide.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class GymLeg extends AppCompatActivity {
    private CardView leg1,leg2,leg3,leg4;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_leg);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_gym_leg;
        showButtons();

        leg1.setOnClickListener(v -> {
                setContentView(R.layout.gym_guggolas);
                currentLayoutId = R.layout.gym_guggolas;
        });
        leg2.setOnClickListener(v -> {
                setContentView(R.layout.gym_leg_labtolas);
                currentLayoutId = R.layout.gym_leg_labtolas;
        });
        leg3.setOnClickListener(v -> {
                setContentView(R.layout.gym_leg_nyujtas);
                currentLayoutId = R.layout.gym_leg_nyujtas;
        });
        leg4.setOnClickListener(v -> {
                setContentView(R.layout.gym_leg_vadli);
                currentLayoutId = R.layout.gym_leg_vadli;
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_gym_leg) {
            Intent leg = new Intent(GymLeg.this, GymLeg.class);
            currentLayoutId = R.layout.activity_gym_leg;
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