package com.example.fitnessguide.plan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.TextView;

import com.example.fitnessguide.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import com.google.firebase.Timestamp;


public class NoteDeatails extends AppCompatActivity {

    EditText plan_title, plan_muscle, plan_excercises, plan_repeate;
    ImageButton save_note_btn;
    TextView pageTitleTextView, deletePlanTextViewBtn;
    String title,muscle,excercises,repeate,docId;
    boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_deatails);

        plan_title = findViewById(R.id.plan_title);
        plan_muscle = findViewById(R.id.plan_muscle);
        plan_excercises = findViewById(R.id.plan_excercises);
        plan_repeate = findViewById(R.id.plan_repeate);

        pageTitleTextView = findViewById(R.id.page_title);

        deletePlanTextViewBtn = findViewById(R.id.deletePlanTextViewBtn);

        title = getIntent().getStringExtra("title");
        muscle = getIntent().getStringExtra("muscle");
        excercises = getIntent().getStringExtra("excercises");
        repeate = getIntent().getStringExtra("repeate");
        docId = getIntent().getStringExtra("docId");

        if(docId != null && !docId.isEmpty()){
            isEditMode = true;
        }

        plan_title.setText(title);
        plan_muscle.setText(muscle);
        plan_excercises.setText(excercises);
        plan_repeate.setText(repeate);
        if(isEditMode){
            pageTitleTextView.setText("Edzésterv szerkesztése");
            deletePlanTextViewBtn.setVisibility(View.VISIBLE);
        }

        save_note_btn = findViewById(R.id.save_note_btn);

        save_note_btn.setOnClickListener( (v) -> saveNote());

        deletePlanTextViewBtn.setOnClickListener( (v) -> deletePlanFromFirebase());

    }



    public void saveNote(){
        String planTitle = plan_title.getText().toString();
        String planMuscle = plan_muscle.getText().toString();
        String planExcercise = plan_excercises.getText().toString();
        String planRepeate = plan_repeate.getText().toString();
        if(planTitle.isEmpty()){
            plan_title.setError("Az edzéstípust kötelező megadni");
            return;
        }
        Note note = new Note();
        note.setTitle(planTitle);
        note.setMuscle(planMuscle);
        note.setExcercises(planExcercise);
        note.setRepeate(planRepeate);
        note.setTimestamp(Timestamp.now());

        saveNoteToFirebase(note);

    }

    public void saveNoteToFirebase(Note note){
        DocumentReference documentReference;
        if(isEditMode){
            documentReference = Utility.getCollectionReferenceForNotes().document(docId);
        }else {
            documentReference = Utility.getCollectionReferenceForNotes().document();
        }
        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    if (isEditMode){
                        Utility.showToast(NoteDeatails.this, "Edzésterv módosítva");
                        finish();
                    }else {
                        Utility.showToast(NoteDeatails.this, "Edzésterv létrehozva");
                        finish();
                    }}else {
                    Utility.showToast((NoteDeatails.this),"Nem sikerült létrehozni az edzéstervet!");
                }
            }
        });

    }

    public void deletePlanFromFirebase() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edzésterv törlése");
        builder.setMessage("Biztosan törölni szeretnéd az edzéstervet?");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "Igen",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        performDelete();
                    }
                });

        builder.setNegativeButton(
                "Nem",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void performDelete() {
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForNotes().document(docId);
        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Utility.showToast(NoteDeatails.this, "Edzésterv törölve");
                    finish();
                }else {
                    Utility.showToast((NoteDeatails.this),"Nem sikerült törölni az edzéstervet!");
                }
            }
        });

    }
}