package com.example.adam.accountregistration;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by adamsoderstrom on 30/11/17.
 */

public class ButtonRow extends Row {

    private Context context;
    private Button input;

    public ButtonRow(Context con) {
        super(con);
        this.context = con;
        this.input = new Button(con);
        init();
    }

    // TODO: Add image row

    public ButtonRow(Context con, AttributeSet attrs) {
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
