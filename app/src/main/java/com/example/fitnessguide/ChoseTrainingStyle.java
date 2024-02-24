package com.example.fitnessguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessguide.calorie.CaloriaCalculator;
import com.example.fitnessguide.gym.Gym;
import com.example.fitnessguide.plan.Plan;
import com.example.fitnessguide.workout.Workout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChoseTrainingStyle extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView emailTextview;
    String email;
    private Button btnCalorie, btnEdzesterv, btnGymm, Workoutt;
    private ImageView menu;
    private DrawerLayout drawerLayout;
    LinearLayout home, workout, gym, plan, calorie, about, logout, rateus, contactus;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_training_style);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        emailTextview = findViewById(R.id.emailTextview);

        if (firebaseUser == null) {
            Toast.makeText(this, "Hiba történt! Felhasználó adatai nem érhető el", Toast.LENGTH_SHORT).show();
        } else {
            email = firebaseUser.getEmail();
            emailTextview.setText(email);
        }

        showButtons();

        btnCalorie.setOnClickListener(v -> {
            Intent intent = new Intent(ChoseTrainingStyle.this, CaloriaCalculator.class);
            startActivity(intent);
        });

        Workoutt.setOnClickListener(v -> {
            Intent workout = new Intent(ChoseTrainingStyle.this, Workout.class);
            startActivity(workout);
        });

        btnGymm.setOnClickListener(v -> {
            Intent gym = new Intent(ChoseTrainingStyle.this, Gym.class);
            startActivity(gym);
        });

        btnEdzesterv.setOnClickListener(v -> {
            Intent intent = new Intent(ChoseTrainingStyle.this, Plan.class);
            startActivity(intent);
        });

        menu.setOnClickListener(v -> openDrawer(drawerLayout));

        home.setOnClickListener(v -> recreate());

        about.setOnClickListener(v -> {
            Intent intent = new Intent(ChoseTrainingStyle.this, About.class);
            startActivity(intent);
        });

        workout.setOnClickListener(v -> {
            Intent intent = new Intent(ChoseTrainingStyle.this, Workout.class);
            startActivity(intent);
        });

        gym.setOnClickListener(v -> {
            Intent intent = new Intent(ChoseTrainingStyle.this, Gym.class);
            startActivity(intent);
        });

        plan.setOnClickListener(v -> {
            Intent intent = new Intent(ChoseTrainingStyle.this, Plan.class);
            startActivity(intent);
        });

        calorie.setOnClickListener(v -> {
            Intent intent = new Intent(ChoseTrainingStyle.this, CaloriaCalculator.class);
            startActivity(intent);
        });

        rateus.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ChoseTrainingStyle.this);
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_rateus, null);
            RatingBar ratingBar = dialogView.findViewById(R.id.ratingBar);
            Button rateBtn = dialogView.findViewById(R.id.rateBtn);

            builder.setView(dialogView);
            AlertDialog dialog = builder.create();

            rateBtn.setOnClickListener(vv -> {
                float rating = ratingBar.getRating();
                String message = "Értékelésed: " + rating + "/5.\nKöszönjük az értékelésed!";
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            dialog.show();
        });

        logout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ChoseTrainingStyle.this);
            builder.setTitle("Kijelentkezés");
            builder.setMessage("Biztosan ki szeretne jelentkezni?");
            builder.setPositiveButton("Igen", (dialog, which) -> {
                mAuth.getInstance().signOut();
                Intent intent = new Intent(ChoseTrainingStyle.this, Login.class);
                startActivity(intent);
                Toast.makeText(ChoseTrainingStyle.this, "Kijelentkezés sikeres", Toast.LENGTH_SHORT).show();
                finish();
            });
            builder.setNegativeButton("Mégsem", (dialog, which) -> {
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Kilépés")
                .setMessage("Biztos ki szeretnél lépni?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ChoseTrainingStyle.super.onBackPressed();
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void showButtons() {
        btnCalorie = findViewById(R.id.btnCalorie);
        Workoutt = findViewById(R.id.Workoutt);
        btnGymm = findViewById(R.id.btnGymm);
        btnEdzesterv = findViewById(R.id.btnEdzesterv);

        menu = findViewById(R.id.menu);

        drawerLayout = findViewById(R.id.drawerLayout);

        home = findViewById(R.id.home);
        workout = findViewById(R.id.workout);
        gym = findViewById(R.id.gym);
        plan = findViewById(R.id.plan);
        calorie = findViewById(R.id.calorie);
        about = findViewById(R.id.about);
        logout = findViewById(R.id.logout);
        contactus = findViewById(R.id.contactus);
        rateus = findViewById(R.id.rateus);

        ratingBar = findViewById(R.id.ratingBar);

    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}