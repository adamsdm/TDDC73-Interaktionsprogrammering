package com.example.adam.accountregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText password = new EditText(this);
        password.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PASSWORD);

        EditText email = new EditText(this);
        email.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_EMAIL_ADDRESS);


        AccountRegistration ar = findViewById(R.id.accountRegistration);
        AccountRegistrationRow row1 = ar.addRow("Name", new EditText(this));
        AccountRegistrationRow row2 = ar.addRow("Password", password);
        AccountRegistrationRow row3 = ar.addRow("Email", email);



    }
}
