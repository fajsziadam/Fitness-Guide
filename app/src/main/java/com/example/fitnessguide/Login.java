package com.example.fitnessguide;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private Button btnLogin;
    private TextView createNewAccount, forgottPassword;
    private ImageView btnGoogle;
    EditText edtTxtEmail,edtTxtPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        showButtons();

        progressDialog= new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        //onclick metódus létrehozása --> Ha megnyomjuk a gombot, akkor végrehajtja a parancsot
        //Intent-el tudjuk egy activityről a másikra átállítani

        btnLogin.setOnClickListener(v -> PerforLogin());

        createNewAccount.setOnClickListener(v -> {
                Intent register = new Intent(Login.this, RegisterActivity.class);
                startActivity(register);
        });
        forgottPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot, null);
                EditText emailbox = dialogView.findViewById(R.id.emailBox);

                builder.setView(dialogView);
                AlertDialog dialog = builder.create();

                dialogView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String userEmail = emailbox.getText().toString();

                        if(TextUtils.isEmpty(userEmail) && !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                            Toast.makeText(Login.this, "Add meg az email-t amivel regisztráltál", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Login.this, "Ellenőrizd az emailed", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }else{
                                    Toast.makeText(Login.this, "Nem sikerült elküldeni, sikertelen", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                dialogView.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                if (dialog.getWindow() != null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }
                dialog.show();
            }
        });

    }

    private void PerforLogin() {
        String email = edtTxtEmail.getText().toString();
        String password = edtTxtPassword.getText().toString();

        //Ellenőrizzük, hogy helyes e az email:
        if (!email.matches(emailPattern)){
            edtTxtEmail.setError("Adj meg egy érvényes e-mail-címet.");
        } else if (password.isEmpty() || password.length() < 6) {
            edtTxtPassword.setError("A jelszó nem megfelelő.");
        } else {
            progressDialog.setMessage("Egy pillanat...");
            progressDialog.setTitle("Bejelentkezés");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Login.this, "Sikeres bejelentkezés", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, "Bejelentkezés sikertelen", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void showButtons() {

        btnLogin = findViewById(R.id.btnLogin);
        createNewAccount = findViewById(R.id.createNewAccount);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        forgottPassword = findViewById(R.id.forgottPassword);
    }
    private void sendUserToNextActivity(){
        Intent intent =new Intent(Login.this, ChoseTrainingStyle.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);     //Ha sikeresen regisztráltunk akkor nem tudunk visszajönni ide
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Kilépés")
                .setMessage("Biztos ki szeretnél lépni?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Login.super.onBackPressed();
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

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null){
            Intent intent =new Intent(Login.this, ChoseTrainingStyle.class);
            startActivity(intent);
            finish();
        }
    }

}