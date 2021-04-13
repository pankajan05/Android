package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class question4 extends AppCompatActivity {

    int total = 0;
    String username = "";

    public void next(View view) {
        pass();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        Intent intent = getIntent();
        this.username = intent.getStringExtra("username");
        this.total = intent.getIntExtra("total",0);
    }

    public void correct(View view) {
        Button button = findViewById(R.id.ans3);
        button.setBackgroundColor(Color.GREEN);
        this.total++;
        pass();
    }

    public void wrong1(View view){
        Button button = findViewById(R.id.ans1);
        button.setBackgroundColor(Color.RED);
        pass();
    }

    public void wrong2(View view) {
        Button button = findViewById(R.id.ans2);
        button.setBackgroundColor(Color.RED);
        pass();
    }


    public void pass(){
        Intent intent = new Intent(this, question5.class);
        intent.putExtra("username", this.username);
        intent.putExtra("total",this.total);
        startActivity(intent);
    }
}