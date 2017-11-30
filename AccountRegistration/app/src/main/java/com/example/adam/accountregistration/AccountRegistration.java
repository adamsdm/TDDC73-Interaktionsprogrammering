package com.example.adam.accountregistration;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class AccountRegistration extends LinearLayout {

    private final Context context;
    private Button registerButton;
    private OnClickListener onRegistration;

    public AccountRegistration(Context con, AttributeSet attrs){
        super(con,attrs);
        this.context=con;
        init();


    }

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.account_registration, this);

        registerButton = findViewById(R.id.registerButton);

        onRegistration = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: NO_DEFAULT");
            }
        };

        registerButton.setOnClickListener(onRegistration);
    }

    public LinearLayout addRow(String text, View input, boolean isMandatory) {
        // Create a row
        LinearLayout tmpLayout = new LinearLayout(context);
        tmpLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        tmpLayout.setOrientation(LinearLayout.HORIZONTAL);

        // Text
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextSize(18);

        // Setup layout
        input.setLayoutParams(new TableRow.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT, .7f));
        textView.setLayoutParams(new TableRow.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT, .3f));

        tmpLayout.addView(textView);
        tmpLayout.addView(input);

        return tmpLayout;
    }

    public void setOnRegistration(OnClickListener o){
        onRegistration = o;
        registerButton.setOnClickListener(o);
    }

}
