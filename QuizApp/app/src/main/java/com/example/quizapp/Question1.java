package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question1 extends AppCompatActivity {

    TextView welcome;
    Button submit, ans1;
    int total = 0;
    String username = "";

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        welcome = findViewById(R.id.welcome);
        submit = findViewById(R.id.submit);
        ans1 = findViewById(R.id.ans1);

        this.intent = getIntent();
        username = intent.getStringExtra("username");
        welcome.setText("Welcome " + this.username);

        
    }

    public void correct(View view) {
        Button button = findViewById(R.id.ans1);
        button.setBackgroundColor(Color.GREEN);
        this.total++;
        pass();
    }

    public void wrong1(View view){
        Button button = findViewById(R.id.ans2);
        button.setBackgroundColor(Color.RED);
        pass();
    }

    public void wrong2(View view) {
        Button button = findViewById(R.id.ans3);
        button.setBackgroundColor(Color.RED);
        pass();
    }

    public void next(View view) {
        pass();
    }

    public void pass(){
        Intent intent = new Intent(this, Question2.class);
        intent.putExtra("username", this.username);
        intent.putExtra("total",this.total);
        startActivity(intent);
    }
}