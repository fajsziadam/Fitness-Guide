package com.example.fitnessguide.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fitnessguide.R;

public class GymChest extends AppCompatActivity {
    private CardView chest1,chest2,chest3,chest4,chest5;
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_chest);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        currentLayoutId = R.layout.activity_gym_chest;
        showButtons();

        chest1.setOnClickListener(v -> {
                setContentView(R.layout.gym_chest_fekvenyomas);
                currentLayoutId = R.layout.gym_chest_fekvenyomas;
        });
        chest2.setOnClickListener(v -> {
                setContentView(R.layout.gym_chest_fekvenyomasegykezessel);
                currentLayoutId = R.layout.gym_chest_fekvenyomasegykezessel;
        });
        chest3.setOnClickListener(v -> {
                setContentView(R.layout.gym_chest_ferdepados);
                currentLayoutId = R.layout.gym_chest_ferdepados;
        });
        chest4.setOnClickListener(v -> {
                setContentView(R.layout.gym_chest_tarogatasegykezessel);
                currentLayoutId = R.layout.gym_chest_tarogatasegykezessel;
        });
        chest5.setOnClickListener(v -> {
            setContentView(R.layout.gym_chest_pecdeck);
            currentLayoutId = R.layout.gym_chest_pecdeck;
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
        chest5 = findViewById(R.id.chest5);
    }
}