package com.example.noteapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class CreateUser extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        Button submitButton;
        submitButton = findViewById(R.id.submit_button);
        EditText mail = findViewById(R.id.email_address);
        EditText pass = findViewById(R.id.password);
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                    String mailText = mail.getText().toString();
                    String passText = pass.getText().toString();
                if(isValid(mailText,"^(.+)@(.+)$") && pass.length()>5){
                    new dbHelper(getApplicationContext()).createUser(mailText,passText);
                    startActivity(new Intent(CreateUser.this, MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(CreateUser.this, "lutfen e-mail adresi ve en az 6 haneli şifre girin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean isValid(String mail, String regex){
        return Pattern.compile(regex)
                .matcher(mail)
                .matches();
    }
}