package com.example.adam.accountregistration;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;


import java.util.regex.Pattern;

import static android.text.InputType.TYPE_CLASS_PHONE;
import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

/**
 * Created by adamsoderstrom on 30/11/17.
 */

public class RegistrationTextRow extends RegistrationRow {

    private Context context;
    private EditText input;
    public boolean isRequired = false;
    public boolean isValid = false;
    private InputType inputType = InputType.DEFAULT;




    public RegistrationTextRow(Context con) {
        super(con);
        this.context = con;
        this.input = new EditText(con);
        init();
    }

    // TODO: Add image row

    public RegistrationTextRow(Context con, AttributeSet attrs) {
        super(con, attrs);
        this.context = con;
        this.input = new EditText(con);
        init();
    }

    protected void init(){
        addView(this.input);

    }

    // https://tausiq.wordpress.com/2013/01/19/android-input-field-validation/
    protected boolean validate(){
        String text = this.input.getText().toString();
        boolean isValid = true;

        // Is this field required and does it have input?
        if(isRequired && text.isEmpty()) {
            isValid = false;
            this.input.setError("This field is required");
        }
        else
            this.input.setError(null);

        // Validate if email or phone
        if(isRequired && this.inputType == InputType.EMAIL){
            isValid = isEmail(text);
        }
        else if(isRequired && this.inputType == InputType.PHONE){
            isValid = isPhoneNmbr(text);
        }



        return isValid;

    }

    // TODO
    private boolean isPhoneNmbr(String text){
        boolean isNmr = true;
        String PHONE_REGEX = "^[0-9]";

        if(!Pattern.matches(PHONE_REGEX, text) && text.length() != 10 ){
            isNmr = false;
            this.input.setError("Please enter a valid phone number");
        }

        return isNmr;
    }

    // TODO
    private boolean isEmail(String text){
        boolean isMail = true;
        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if(!Pattern.matches(EMAIL_REGEX, text)) {
            isMail = false;
            this.input.setError("Please enter a valid e-mail");
        }
        return isMail;
    }


    public void setInputType(InputType type){
        this.inputType = type;

        switch(type){
            case EMAIL:
                this.input.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            case PASSWORD:
                this.input.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PASSWORD);
                break;
            case PHONE:
                this.input.setInputType(TYPE_CLASS_TEXT | TYPE_CLASS_PHONE);
                break;
        }
    }

    public void setRequired(boolean required){
        this.isRequired = required;
    }

    @Override
    public View getView() {
        return this.input;
    }


}
