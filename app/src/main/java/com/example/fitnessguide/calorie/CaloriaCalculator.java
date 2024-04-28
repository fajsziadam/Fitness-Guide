package com.example.fitnessguide.calorie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.fitnessguide.R;

public class CaloriaCalculator extends AppCompatActivity {
    private Button btnCalculate, btnReset;
    private RadioGroup rgActivity, rgGender, rgGoal;
    private RadioButton rb0, rb12, rb35, rb67, rbMale, rbFemale, rbLess, rbSame, rbMore;
    private EditText edtTxtAge, edtTxtHeight, edtTxtWeight;
    private TextView txtWarnAge, txtWarnHeight, txtWarnWeight,txtWarnGender , txtWarnActivity, txtWarnGoal, txtShow,txtKeplet;

    ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloria_calculator);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initViews();

        btnCalculate.setOnClickListener(v -> Calculate());

        btnReset.setOnClickListener(v -> {
            edtTxtAge.setText("");
            edtTxtHeight.setText("");
            edtTxtWeight.setText("");
            txtShow.setText("");
            rgGender.clearCheck();
            rgActivity.clearCheck();
            rgGoal.clearCheck();
            txtWarnAge.setVisibility(View.GONE);
            txtWarnHeight.setVisibility(View.GONE);
            txtWarnWeight.setVisibility(View.GONE);
            txtWarnGender.setVisibility(View.GONE);
            txtWarnActivity.setVisibility(View.GONE);
            txtWarnGoal.setVisibility(View.GONE);
            txtKeplet.setVisibility(View.GONE);
        });

    }

    private void Calculate(){
    if (validateData()){

        int ageValue = Integer.parseInt(edtTxtAge.getText().toString());
        int heightValue = Integer.parseInt(edtTxtHeight.getText().toString());
        int weightValue = Integer.parseInt(edtTxtWeight.getText().toString());

        double Calories;

        if(rgGender.getCheckedRadioButtonId() == rbMale.getId()){
            Calories = (10 * weightValue) + (6.25 * heightValue) - (5 * ageValue) + 5;

            if (rgActivity.getCheckedRadioButtonId() == rb0.getId()){
                Calories = Calories * 1.2;
                if (rgGoal.getCheckedRadioButtonId() == rbSame.getId()) {
                }
                if (rgGoal.getCheckedRadioButtonId() == rbLess.getId()){
                    Calories = Calories - 500;
                }
                if (rgGoal.getCheckedRadioButtonId() == rbMore.getId()){
                    Calories = Calories + 500;
                }
            }

            if (rgActivity.getCheckedRadioButtonId() == rb12.getId()){
                Calories = Calories * 1.375;
                if (rgGoal.getCheckedRadioButtonId() == rbSame.getId()) {
                }
                if (rgGoal.getCheckedRadioButtonId() == rbLess.getId()){
                    Calories = Calories - 500;
                }
                if (rgGoal.getCheckedRadioButtonId() == rbMore.getId()){
                    Calories = Calories + 500;
                }
            }

            if (rgActivity.getCheckedRadioButtonId() == rb35.getId()){
                Calories = Calories * 1.55;
                if (rgGoal.getCheckedRadioButtonId() == rbSame.getId()) {
                }
                if (rgGoal.getCheckedRadioButtonId() == rbLess.getId()){
                    Calories = Calories - 500;
                }
                if (rgGoal.getCheckedRadioButtonId() == rbMore.getId()){
                    Calories = Calories + 500;
                }
            }

            if (rgActivity.getCheckedRadioButtonId() == rb67.getId()){
                Calories = Calories * 1.725;
                if (rgGoal.getCheckedRadioButtonId() == rbSame.getId()) {
                }
                if (rgGoal.getCheckedRadioButtonId() == rbLess.getId()){
                    Calories = Calories - 500;
                }
                if (rgGoal.getCheckedRadioButtonId() == rbMore.getId()){
                    Calories = Calories + 500;
                }
            }

            txtShow.setText(String.format("A napi kalória szükségleted: " + "%.2f" , Calories) + " Kalória.");
            txtKeplet.setVisibility(View.VISIBLE);
            txtKeplet.setText(String.format("*A számítás a Mifflin-St. Jeor egyenlet alapján történik."));

        } if (rgGender.getCheckedRadioButtonId() == rbFemale.getId()){
            Calories = (10 * weightValue) + (6.25 * heightValue) - (5 * ageValue) - 161 ;

            if (rgActivity.getCheckedRadioButtonId() == rb0.getId()){
                Calories = Calories * 1.2;
                if (rgGoal.getCheckedRadioButtonId() == rbSame.getId()) {
                }
                if (rgGoal.getCheckedRadioButtonId() == rbLess.getId()){
                    Calories = Calories - 500;
                }
                if (rgGoal.getCheckedRadioButtonId() == rbMore.getId()){
                    Calories = Calories + 500;
                }
            }

            if (rgActivity.getCheckedRadioButtonId() == rb12.getId()){
                Calories = Calories * 1.375;
                if (rgGoal.getCheckedRadioButtonId() == rbSame.getId()) {
                }
                if (rgGoal.getCheckedRadioButtonId() == rbLess.getId()){
                    Calories = Calories - 500;
                }
                if (rgGoal.getCheckedRadioButtonId() == rbMore.getId()){
                    Calories = Calories + 500;
                }
            }

            if (rgActivity.getCheckedRadioButtonId() == rb35.getId()){
                Calories = Calories * 1.55;
                if (rgGoal.getCheckedRadioButtonId() == rbSame.getId()) {
                }
                if (rgGoal.getCheckedRadioButtonId() == rbLess.getId()){
                    Calories = Calories - 500;
                }
                if (rgGoal.getCheckedRadioButtonId() == rbMore.getId()){
                    Calories = Calories + 500;
                }
            }

            if (rgActivity.getCheckedRadioButtonId() == rb67.getId()){
                Calories = Calories * 1.725;
                if (rgGoal.getCheckedRadioButtonId() == rbSame.getId()) {
                }
                if (rgGoal.getCheckedRadioButtonId() == rbLess.getId()){
                    Calories = Calories - 500;
                }
                if (rgGoal.getCheckedRadioButtonId() == rbMore.getId()){
                    Calories = Calories + 500;
                }
            }

            txtShow.setText(String.format("A napi kalória szükségleted: " + "%.2f" , Calories) + " Kalória.\n\n");
            txtKeplet.setVisibility(View.VISIBLE);
            txtKeplet.setText(String.format("*A számítás a Mifflin-St. Jeor egyenlet alapján történik."));
        }


    }
}
    private boolean validateData(){
        if (edtTxtAge.getText().toString().equals("")){
            txtWarnAge.setVisibility(View.VISIBLE);
            txtWarnAge.setText("Kérlek add meg az életkorod");
            return false;
        }else {
            txtWarnAge.setVisibility(View.GONE);
            txtWarnAge.setText(""); // Hibaüzenet eltüntetése, ha nincs hiba
        }

        if (edtTxtHeight.getText().toString().equals("")){
            txtWarnHeight.setVisibility(View.VISIBLE);
            txtWarnHeight.setText("Kérlek add meg a magasságod");
            return false;
        }else {
            txtWarnHeight.setVisibility(View.GONE);
            txtWarnHeight.setText("");
        }

        if (edtTxtWeight.getText().toString().equals("")){
            txtWarnWeight.setVisibility(View.VISIBLE);
            txtWarnWeight.setText("Kérlek add meg a súlyod");
            return false;
        }else {
            txtWarnWeight.setVisibility(View.GONE);
            txtWarnWeight.setText("");
        }

        if (rgActivity.getCheckedRadioButtonId() == -1){
            txtWarnActivity.setVisibility(View.VISIBLE);
            txtWarnActivity.setText("Kérlek válassz aktivitást!");
            return false;
        }else {
            txtWarnActivity.setVisibility(View.GONE);
            txtWarnActivity.setText("");
        }

        if (rgGender.getCheckedRadioButtonId() == -1) {
            txtWarnGender.setVisibility(View.VISIBLE);
            txtWarnGender.setText("Kérlek válassz nemet!");
            return false;
        }else {
            txtWarnGender.setVisibility(View.GONE);
            txtWarnGender.setText("");
        }

        if (rgGoal.getCheckedRadioButtonId() == -1){
            txtWarnGoal.setVisibility(View.VISIBLE);
            txtWarnGoal.setText("Kérlek add meg mi a célod!");
            return false;
        }else {
            txtWarnGoal.setVisibility(View.GONE);
            txtWarnGoal.setText("");
        }

        return true;
    }

    private void initViews(){

        edtTxtAge = findViewById(R.id.edtTxtAge);
        edtTxtHeight = findViewById(R.id.edtTxtHeight);
        edtTxtWeight = findViewById(R.id.edtTxtWeight);

        btnCalculate = findViewById(R.id.btnCalculate);
        btnReset = findViewById(R.id.btnReset);

        rgActivity = findViewById(R.id.rgActivity);
        rgGender = findViewById(R.id.rgGender);
        rgGoal = findViewById(R.id.rgGoal);

        rb0 = findViewById(R.id.rb0);
        rb12 = findViewById(R.id.rb12);
        rb35 = findViewById(R.id.rb35);
        rb67 = findViewById(R.id.rb67);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbLess = findViewById(R.id.rbLess);
        rbSame = findViewById(R.id.rbSame);
        rbMore = findViewById(R.id.rbMore);

        txtShow = findViewById(R.id.txtShow);
        txtWarnAge = findViewById(R.id.txtWarnAge);
        txtWarnHeight = findViewById(R.id.txtWarnHeight);
        txtWarnWeight = findViewById(R.id.txtWarnWeight);
        txtWarnGender = findViewById(R.id.txtWarnGender);
        txtWarnActivity = findViewById(R.id.txtWarnActivity);
        txtWarnGoal = findViewById(R.id.txtWarnGoal);
        txtKeplet = findViewById(R.id.txtKeplet);

        parent = findViewById(R.id.parent);
    }
}