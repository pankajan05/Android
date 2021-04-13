package com.elzian.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView txt;
    EditText username;
    EditText password;
    DBHandler db = new DBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txt = findViewById(R.id.txt);
        username = findViewById(R.id.txtusername);
        password = findViewById(R.id.txtpassword);
    }

    public void login(View view) {

        String x = db.addRecord(username.getText().toString(), password.getText().toString());

        txt.setText(x);
    }


    public void edit(View view) {
        String s = db.read();
        txt.setText(s);
        username.setText("kajan");
        password.setText("1234");
    }
}
