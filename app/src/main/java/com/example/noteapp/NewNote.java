package com.example.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewNote extends AppCompatActivity {
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        dbHelper DbHelper = new dbHelper(getApplicationContext());
        EditText noteHead = findViewById(R.id.note_head);
        EditText noteBody = findViewById(R.id.note_body);
        submit = findViewById(R.id.submit);
        UserSessionManager userSessionManager = new UserSessionManager(getApplicationContext());


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo: add data to the tree
                DbHelper.addNote(noteHead.getText().toString(),noteBody.getText().toString(),userSessionManager.getUserId());
                startActivity(new Intent(NewNote.this, MainPage.class));
                finish();


            }
        });

    }
}