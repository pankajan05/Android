package com.mad2020reg.docchannel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mad2020reg.docchannel.Database.DBHelper;

import java.util.List;

public class RegisterPatient extends AppCompatActivity {

    EditText edtName, edtAge, edtContact;
    String PId;
    private static final String TAG = "RegisterPatient";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtContact = findViewById(R.id.edtPhone);
        DBHelper dbHelper = new DBHelper(this);


        // generate Patient Id
        try{
            List patients= dbHelper.getPatient();
            String[] patient = (String[])patients.get(0);
            Log.i(TAG, "onCreate: "+ patient[1]);
            PId = patient[1];


            if(Integer.parseInt(PId.substring(1,PId.length()))+1<10){
                PId = "P00" + (Integer.parseInt(PId.substring(1,PId.length()))+1);
            }else if(Integer.parseInt(PId.substring(1,PId.length()))+1<100){
                PId = "P0" + (Integer.parseInt(PId.substring(1,PId.length()))+1);
            }else {
                PId = "P" + (Integer.parseInt(PId.substring(1,PId.length()))+1);
            }

            Log.i(TAG, "onCreate: "+ PId);
        }catch (Exception e){
            Log.i(TAG, "onCreate: Error");
            PId = "P001";

        }
    }

    public void saveData(View view){


        DBHelper dbhandler = new DBHelper(getApplicationContext());
        try {
            long newId = dbhandler.addPatient(edtName.getText().toString(), edtAge.getText().toString(), edtContact.getText().toString());
            Toast.makeText(RegisterPatient.this, "Data Inserted successfully " + newId, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(RegisterPatient.this, "Failed to Insert" + newId, Toast.LENGTH_SHORT).show();
        }

        Intent i = new Intent(this,MainActivity.class);
        i.putExtra(ID, String.valueOf(newId));
        startActivity(i);

        edtName.setText(null);
        edtAge.setText(null);
        edtContact.setText(null);


    }
}