package com.example.noteapp;

import static com.example.noteapp.R.id.exit_button;
import static com.example.noteapp.R.id.new_button;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {


    private RecyclerView recyclerView;
    private NoteAdapter notesAdapter;

    private dbHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Button newNote = findViewById(new_button);
        Button logOut = findViewById(exit_button);
        RecyclerView recyclerView  = findViewById(R.id.recyclerView);
        databaseHelper = new dbHelper(this);
        UserSessionManager userSessionManager = new UserSessionManager(this);
        System.out.println(userSessionManager.getUserId());
        List<Note> notesList = new ArrayList<>();


        notesList = databaseHelper.getNotesByUserId(userSessionManager.getUserId());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesAdapter = new NoteAdapter(this, notesList);
        recyclerView.setAdapter(notesAdapter);




        newNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPage.this,NewNote.class));

            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSessionManager.logout();
                startActivity(new Intent(MainPage.this,MainActivity.class));

            }
        });
    }






}