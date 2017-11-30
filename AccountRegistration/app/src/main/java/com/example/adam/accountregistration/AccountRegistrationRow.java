package com.example.adam.accountregistration;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by adamsoderstrom on 30/11/17.
 */

public class AccountRegistrationRow extends TableLayout {

    private Context context;
    private String title;
    private View input;
    public boolean isRequired = false;

    public AccountRegistrationRow(Context con, String title, View input) {
        super(con);
        this.context = con;
        this.title = title;
        this.input = input;
        init();
    }

    // TODO: Add image row

    public AccountRegistrationRow(Context con, AttributeSet attrs, String title, View input) {
        super(con, attrs);
        this.context = con;
        this.title = title;
        this.input = input;
        init();
    }

    private void init(){


        if(this.input instanceof TextView){
            ((TextView) this.input).setHint(this.title);
        } else if (this.input instanceof Button){
            ( (Button) this.input ).setText(this.title);
        }

        addView(input);

    }

}
