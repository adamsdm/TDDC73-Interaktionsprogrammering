package com.example.adam.accountregistration;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class AccountRegistration extends LinearLayout {

    private final Context context;
    private Button registerButton;
    private OnClickListener onRegistration;
    private LinearLayout fieldsView;
    ArrayList<Row> rows = new ArrayList<Row>();

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
                boolean isValid = validateAllInputs();

                if(isValid){
                    Toast.makeText(context, "Registration sucessfull!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Log.d(TAG, "FAIL :(((((");
                }
            }
        });
    }

    // TODO: Implementation
    private boolean validateAllInputs(){

        boolean isValid = true;
        for(Row r : rows){
            if(!r.validate()) isValid = false;
        }
        return isValid;
    }

    public void addRow(Row row ){
        fieldsView.addView(row);
        rows.add(row);
    }


}
