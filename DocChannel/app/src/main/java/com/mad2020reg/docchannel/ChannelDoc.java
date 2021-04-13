package com.mad2020reg.docchannel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mad2020reg.docchannel.Database.DBHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ChannelDoc extends AppCompatActivity {

    EditText edtId, edtDocFee, edtHospitalCharges,edtTotal;

    private double hsptlFee = 800.00;

    String[][] doctors = {{"Dr. Jayasekara","Dr. Amarasooriya"},
            {"Dr. Wijayathilaka","Dr. Amarasena"},
            {"Dr. Kalansooriya","Dr. Wedituwakku"},
            {"Dr. Ranaweera","Dr. Amarasooriya"},
            {"Dr. Wickramasooriya","Dr. Sriyawansa"},
            };
    Double[][] prices = {{400.00,450.00},{500.00,500.00},{450.00,400.00},{600.00,550.00},
            {450.00,500.00}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_doc);


        edtId = findViewById(R.id.edtId);
        edtDocFee = findViewById(R.id.edtDocFee);
        edtHospitalCharges = findViewById(R.id.edtHospitalCharges);
        edtTotal = findViewById(R.id.edtTotal);



        /****Question 07 (a)  ****/


        /****Question 07 (b)  ****/



        /****Question 07 (d)  ****/



    }

    public void openHome(View view){

        // Opens MainMenu Activity

    }

    public void saveChanneling(View view) {


        /****Question 07 (e)  ****/

    }

    public static double calculateTotal(double docFee, double hospitalFee){

        /****Question 07 (c)  ****/

    }
}