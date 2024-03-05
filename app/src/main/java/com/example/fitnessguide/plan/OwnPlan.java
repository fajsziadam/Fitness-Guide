package com.example.fitnessguide.plan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.example.fitnessguide.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class OwnPlan extends AppCompatActivity {
    Button addNewnotebtn;
    RecyclerView recyclerView;
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_plan);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        addNewnotebtn = findViewById(R.id.addNewnotebtn);
        recyclerView = findViewById(R.id.recyler_view);

        addNewnotebtn.setOnClickListener((v) ->
                startActivity(new Intent(OwnPlan.this,
                        NoteDeatails.class)));

        setupRecyclerView();
    }

    void setupRecyclerView(){
        Query query = Utility.getCollectionReferenceForNotes().orderBy("timestamp", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query, Note.class).build();
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        noteAdapter = new NoteAdapter(options, this);
        recyclerView.setAdapter(noteAdapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
        noteAdapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        noteAdapter.stopListening();
    }

    @Override
    protected void onResume(){
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }

}