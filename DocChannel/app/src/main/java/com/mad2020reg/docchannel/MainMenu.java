package com.mad2020reg.docchannel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        /****Question 06 (a)  ****/
        Intent intent = getIntent();
        this.id = intent.getStringExtra(MainActivity.ID);

    }

    public void openChannelDoc(View view){

        Intent i = new Intent(this,ChannelDoc.class);
        i.putExtra(ID, this.id);
        startActivity(i);

    }

    public void openTests(View view){

        Intent i = new Intent(this,LabTests.class);
        i.putExtra(ID, this.id);
        startActivity(i);

    }

    public void openHistory(View view){

        /****Question 06 (d)  ****/
        Intent i = new Intent(this,History.class);
        i.putExtra(ID, this.id);
        startActivity(i);

    }

    public void logout(View view){

        /****Question 06 (e)  ****/

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }
}