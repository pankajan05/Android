package com.mad2020reg.docchannel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mad2020reg.docchannel.Database.DBHelper;

import java.util.Calendar;

public class LabTests extends AppCompatActivity {
    private String PId;

    EditText edtId;
    Spinner spnTests;

    Double[] Values = {0.0,2500.00,3000.00,1000.00,1250.00,1250.00};
    Double total = 0.00;
    TextView txtTotalVal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_tests);
        Intent intent = getIntent();

        edtId = findViewById(R.id.edtId);
        txtTotalVal = findViewById(R.id.txtTotalVal);


        /****Question 08 (a) & (b)  ****/
        switch (edtId){
            case 'Complete Blood count':
                break;
            case 'Lipid Panel':
                break;
            case 'Liver Panel':
                break;
            case 'Urinalysis':
                    break;
            case 'Cultures':
                break;
        }
    }

    public void openHomefromLab(View view){

        /****Question 08 (d)  ****/

    }

    public void openChannel(View view){

        /****Question 08 (c)  ****/

    }

    public void SaveDetails(View view){
        Toast.makeText(this, "View History to view Saved", Toast.LENGTH_SHORT).show();

    }


}