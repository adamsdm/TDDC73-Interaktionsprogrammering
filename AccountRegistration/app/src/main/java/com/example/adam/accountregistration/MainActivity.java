package com.example.adam.accountregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AccountRegistration ar = findViewById(R.id.accountRegistration);


        // Name input
        RegistrationTextRow firstName = new RegistrationTextRow(this);
        firstName.setRequired(true);
        ((EditText) firstName.getView()).setHint("Firstname");
        ar.addRow(firstName);


        RegistrationTextRow surName = new RegistrationTextRow(this);
        surName.setRequired(true);
        ((EditText) surName.getView()).setHint("Surname");
        ar.addRow(surName);


        RegistrationTextRow password = new RegistrationTextRow(this);
        password.setRequired(true);
        password.setInputType(InputType.PASSWORD);
        ((EditText) password.getView()).setHint("Password");
        ar.addRow(password);

        RegistrationTextRow email = new RegistrationTextRow(this);
        email.setRequired(true);
        email.setInputType(InputType.EMAIL);
        ((EditText) email.getView()).setHint("Email");
        ar.addRow(email);

        RegistrationTextRow phone = new RegistrationTextRow(this);
        phone.setRequired(false);
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
        RegistrationRadioGroupRow row3 = new RegistrationRadioGroupRow(this);
        RadioButton rbmale = new RadioButton(this);
        RadioButton rbfemale = new RadioButton(this);
        rbmale.setText("Male");
        rbfemale.setText("Female");
        row3.addRadioButton(rbfemale);
        row3.addRadioButton(rbmale);






        ar.addRow(row3);



    }
}
