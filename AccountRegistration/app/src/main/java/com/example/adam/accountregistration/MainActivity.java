package com.example.adam.accountregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AccountRegistration ar = findViewById(R.id.accountRegistration);


        // Image
        ImageRow img = new ImageRow(this, R.drawable.androidlogo);
        img.setScaleX(0.5f);
        img.setScaleY(0.5f);
        ar.addRow(img);

        // Name input
        TextRow firstName = new TextRow(this);
        firstName.setRequired(true);
        ((EditText) firstName.getView()).setHint("Firstname");
        ar.addRow(firstName);


        TextRow surName = new TextRow(this);
        surName.setRequired(true);
        ((EditText) surName.getView()).setHint("Surname");
        ar.addRow(surName);


        TextRow password = new TextRow(this);
        password.setRequired(true);
        password.setInputType(InputType.PASSWORD);
        ((EditText) password.getView()).setHint("Password");
        ar.addRow(password);

        TextRow email = new TextRow(this);
        email.setRequired(true);
        email.setInputType(InputType.EMAIL);
        ((EditText) email.getView()).setHint("Email");
        ar.addRow(email);

        TextRow phone = new TextRow(this);
        phone.setRequired(true);
        phone.setInputType(InputType.PHONE);
        ((EditText) phone.getView()).setHint("Phone");
        ar.addRow(phone);

        // Button
        /*
        RegistrationRow row2 = new RegistrationButtonRow(this);
        ((Button) row2.getView()).setText("Button");
        ar.addRow(row2);
        */

        // Radio group
        RadioGroupRow rg = new RadioGroupRow(this);
        RadioButton rbmale = new RadioButton(this);
        RadioButton rbfemale = new RadioButton(this);
        rbmale.setText("Male");
        rbfemale.setText("Female");
        rg.addRadioButton(rbfemale);
        rg.addRadioButton(rbmale);

        ar.addRow(rg);



    }
}
