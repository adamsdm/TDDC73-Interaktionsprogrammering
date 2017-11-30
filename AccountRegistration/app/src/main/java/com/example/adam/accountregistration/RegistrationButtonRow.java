package com.example.adam.accountregistration;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;

import static android.content.ContentValues.TAG;

/**
 * Created by adamsoderstrom on 30/11/17.
 */

public class RegistrationButtonRow extends RegistrationRow {

    private Context context;
    private Button input;

    public RegistrationButtonRow(Context con) {
        super(con);
        this.context = con;
        this.input = new Button(con);
        init();
    }

    // TODO: Add image row

    public RegistrationButtonRow(Context con, AttributeSet attrs) {
        super(con, attrs);
        this.context = con;
        this.input = new Button(con);
        init();
    }

    protected boolean validate(){ return true; }

    protected void init(){
        addView(this.input);
    }

    @Override
    public View getView() {
        return this.input;
    }

}
