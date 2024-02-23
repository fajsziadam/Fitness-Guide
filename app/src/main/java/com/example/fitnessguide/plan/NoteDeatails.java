package com.example.fitnessguide.plan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessguide.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import com.google.firebase.Timestamp;


public class NoteDeatails extends AppCompatActivity {

    EditText plan_title, plan_muscle, plan_excercises, plan_repeate;
    ImageButton save_note_btn;
    TextView pageTitleTextView;
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

        //recive data
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
            pageTitleTextView.setText("Szerkesztés");
        }

        save_note_btn = findViewById(R.id.save_note_btn);

        save_note_btn.setOnClickListener( (v) -> saveNote());

    }

    public void saveNote(){
        String planTitle = plan_title.getText().toString();
        String planMuscle = plan_muscle.getText().toString();
        String planExcercise = plan_excercises.getText().toString();
        String planRepeate = plan_repeate.getText().toString();
        if(planTitle == null || planTitle.isEmpty()){
            plan_title.setError("Az edzéstípust kötelező megadni");
            return;
        }
        Note note = new Note();
        note.setTitle(planTitle);
        note.setMuscle(planMuscle);
        note.setContent(planExcercise);
        note.setRepeate(planRepeate);
        note.setTimestamp(Timestamp.now());

        saveNoteToFirebase(note);

    }

    public void saveNoteToFirebase(Note note){
        DocumentReference documentReference;
        if(isEditMode){
            //update the note
            documentReference = Utility.getCollectionReferenceForNotes().document(docId);
        }else {
            //create new note
            documentReference = Utility.getCollectionReferenceForNotes().document();
        }
        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Utility.showToast(NoteDeatails.this, "Note added succesfully");
                    finish();
                }else {
                    Utility.showToast((NoteDeatails.this),"Failed while adding note");
                }
            }
        });

    }

}