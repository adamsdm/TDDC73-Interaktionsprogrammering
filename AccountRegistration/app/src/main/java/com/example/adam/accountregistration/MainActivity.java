package com.example.adam.accountregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AccountRegistration ar = findViewById(R.id.accountRegistration);
        ar.addRow("Namn", new EditText(this), false);
    }
}
