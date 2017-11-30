package com.example.adam.accountregistration;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class AccountRegistration extends LinearLayout {

    private final Context context;
    private Button registerButton;
    private OnClickListener onRegistration;
    private LinearLayout fieldsView;

    public AccountRegistration(Context con, AttributeSet attrs){
        super(con,attrs);
        this.context=con;
        init();
    }

    private void init(){

        LayoutInflater.from(getContext()).inflate(R.layout.account_registration, this);

        // We always want a register button
        registerButton = findViewById(R.id.registerButton);
        fieldsView = findViewById(R.id.fieldsLayout);

        registerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = validateInputs();

                if(isValid){
                    Log.d(TAG, "SUCCESSFULL!");
                    //TODO: Call interface method to handle submit

                }
            }
        });


    }

    // TODO: Implementation
    private boolean validateInputs(){

        boolean isValid = true;

        // For each input field....
            // Validate


        return isValid;

    }


    public AccountRegistrationRow addRow(String hint,  View view){

        AccountRegistrationRow row = new AccountRegistrationRow(this.context,hint, view);
        fieldsView.addView(row);

        return row;
    }


}
