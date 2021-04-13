package com.mad2020reg.docchannel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mad2020reg.docchannel.Database.DBHelper;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText phone;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.edtPhone);


    }

    public void openRegisterActivity(View view){
        Intent intent = new Intent(this,RegisterPatient.class);
        startActivity(intent);

    }

    public void openMenu(View view){
        if(phone = "077297834") {
            try{
            Intent myIntent = new Intent(this, MainMenu.class);
            this.startActivity(myIntent);
            }catch (Exception e){
                Toast toast=Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
            }

        } else {
            Toast toast=Toast.makeText(getApplicationContext(),"Please enter a valid contact number",Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
        }


  }
}