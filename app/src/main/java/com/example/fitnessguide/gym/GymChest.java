package com.example.fitnessguide.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class GymChest extends AppCompatActivity {

    private CardView chest1,chest2,chest3,chest4;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_chest);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_gym_chest;

        showButtons();

        chest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.gym_chest1);
                currentLayoutId = R.layout.gym_chest1;
            }
        });
        chest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.gym_chest2);
                currentLayoutId = R.layout.gym_chest2;
            }
        });
        chest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.gym_chest3);
                currentLayoutId = R.layout.gym_chest3;
            }
        });
        chest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.gym_chest4);
                currentLayoutId = R.layout.gym_chest4;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (currentLayoutId != R.layout.activity_gym_chest) {
            Intent chest = new Intent(GymChest.this, GymChest.class);//Azért kellett ez a megoldás mert nem az edzésekhez,
            currentLayoutId = R.layout.activity_gym_chest;                         //hanem az izomcsoportokhoz ment vissza a vissza gombbal
            startActivity(chest);
            finish();
        } else {
            super.onBackPressed();
        }
    }
    private void showButtons() {
        chest1 = findViewById(R.id.chest1);
        chest2 = findViewById(R.id.chest2);
        chest3 = findViewById(R.id.chest3);
        chest4 = findViewById(R.id.chest4);
    }
}