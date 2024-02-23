package com.example.fitnessguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private TextView emailTextview;
    private String email;
    private Button btnCalorie, btnEdzesterv, btnGymm, Workoutt;
    private ImageView menu;
    private DrawerLayout drawerLayout;
    private LinearLayout home, workout, gym, plan, calorie, settings, about, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_training_style);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        emailTextview = findViewById(R.id.emailTextview);

        if (firebaseUser == null){
            Toast.makeText(this, "Hiba történt! Felhasználó adatai nem érhető el", Toast.LENGTH_SHORT).show();
        }else {
            email = firebaseUser.getEmail();
            emailTextview.setText(email);
        }

        showButtons();

        btnCalorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoseTrainingStyle.this, CaloriaCalculator.class);
                startActivity(intent);
            }
        });

        Workoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent workout = new Intent(ChoseTrainingStyle.this, Workout.class);
                startActivity(workout);
            }
        });

        btnGymm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gym = new Intent(ChoseTrainingStyle.this, Gym.class);
                startActivity(gym);
            }
        });

        btnEdzesterv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoseTrainingStyle.this, Plan.class);
                startActivity(intent);
            }
        });


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recreate();
                }
            });

            settings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChoseTrainingStyle.this, Settings.class);
                    startActivity(intent);
                }
            });

            about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChoseTrainingStyle.this, About.class);
                    startActivity(intent);
                }
            });

            workout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChoseTrainingStyle.this, Workout.class);
                    startActivity(intent);
                }
            });

            gym.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChoseTrainingStyle.this, Gym.class);
                    startActivity(intent);
                }
            });

            plan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChoseTrainingStyle.this, Plan.class);
                    startActivity(intent);
                }
            });

            calorie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChoseTrainingStyle.this, CaloriaCalculator.class);
                    startActivity(intent);
                }
            });

            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAuth.getInstance().signOut();
                    Intent intent = new Intent(ChoseTrainingStyle.this, Login.class);
                    startActivity(intent);
                    Toast.makeText(ChoseTrainingStyle.this, "Kijelentkezés sikeres", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });

        }

    private void showUserProfile(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
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
        settings = findViewById(R.id.settings);
        about = findViewById(R.id.about);
        logout = findViewById(R.id.logout);

    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
        }
        public static void closeDrawer(DrawerLayout drawerLayout){
            if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.closeDrawer(GravityCompat.START);
            }
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}