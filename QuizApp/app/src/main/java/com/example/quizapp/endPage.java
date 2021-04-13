package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.app.Activity.*;

public class endPage extends AppCompatActivity {

    TextView congrats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);

        congrats = findViewById(R.id.congrats);
        TextView score = findViewById(R.id.score);

        Intent intents = getIntent();
        String name = intents.getStringExtra("username");
        int total = intents.getIntExtra("total", 0);
        congrats.setText("Congratulations " + name);
        score.setText("Your score is " + total);

    }

    public void finish(View view) {
        finishAffinity();

    }
    public void end(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}