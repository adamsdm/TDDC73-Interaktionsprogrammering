package com.example.adam.accountregistration;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;



/**
 * Created by adamsoderstrom on 30/11/17.
 */

public class RegistrationRadioGroupRow extends RegistrationRow {

    private Context context;
    private RadioGroup input;
    private RadioButton lastRadioButton;

    public RegistrationRadioGroupRow(Context con) {
        super(con);
        this.context = con;
        this.input = new RadioGroup(con);
        init();
    }

    // TODO: Add image row

    public RegistrationRadioGroupRow(Context con, AttributeSet attrs) {
        super(con, attrs);
        this.context = con;
        this.input = new RadioGroup(con);
        init();
    }



    protected void init(){
        setOrientation(TableLayout.HORIZONTAL);
        addView(this.input);

        input.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                lastRadioButton.setError(null);
            }
        });
    }

    protected boolean validate() {

        if (input.getCheckedRadioButtonId() <= 0) {//Grp is your radio group object
            lastRadioButton.setError("At least one must be selected");//Set error to last Radio button
            return false;
        }
        return true;
    }

    public void addRadioButton(RadioButton rb){
        rb.setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        ));
        this.input.addView(rb);
        lastRadioButton = rb;
    }

    @Override
    public View getView() {
        return this.input;
    }

}
