package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question1 extends AppCompatActivity {

    TextView welcome;
    Button submit, ans1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        welcome = findViewById(R.id.welcome);
        submit = findViewById(R.id.submit);
        ans1 = findViewById(R.id.ans1);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        welcome.setText("Welcome " + name);

        
    }
    public void next(View view) {
        Intent intent = new Intent(this,Question2.class);
        startActivity(intent);
    }
}