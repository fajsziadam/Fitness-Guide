package com.example.fitnessguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    TextView alreadyHaveAccount;
    Button btnRegister;
    EditText edtTxtEmail,edtTxtPassword,edtTxtPassword2;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        showButtons();

        progressDialog= new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        alreadyHaveAccount.setOnClickListener(v -> onBackPressed());

        btnRegister.setOnClickListener(v -> PerforAuth());

    }

    private void PerforAuth() {
        String email = edtTxtEmail.getText().toString();
        String password = edtTxtPassword.getText().toString();
        String password2 = edtTxtPassword2.getText().toString();

        //Ellenőrizzük, hogy helyes e az email:
        if (!email.matches(emailPattern)){
            edtTxtEmail.setError("Adj meg egy érvényes e-mail-címet.");
        } else if (password.isEmpty() || password.length() < 6) {
            edtTxtPassword.setError("A jelszónak legalább 6 karakter hosszúságúnak kell lennie");
        } else if (!password.equals(password2)) {
            edtTxtPassword2.setError("Nem egyezik a jelszó mezővel.");
        }else {
            progressDialog.setMessage("Várjon, amíg a regisztráció véget ér...");
            progressDialog.setTitle("Regisztráció");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(RegisterActivity.this, "Sikeres regisztráció", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "A regisztráció sikertelen", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void showButtons() {

        alreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);
        btnRegister = findViewById(R.id.btnRegister);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        edtTxtPassword2 = findViewById(R.id.edtTxtPassword2);

    }

    private void sendUserToNextActivity(){
        Intent intent =new Intent(RegisterActivity.this, ChoseTrainingStyle.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);     //Ha sikeresen regisztráltunk akkor nem tudunk visszajönni ide
        startActivity(intent);
        finish();
    }
}