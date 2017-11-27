package com.example.adamsoderstrom.passwordstrengthmeter;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PasswordMeter extends LinearLayout {

    private int max_strength = 100;

    Context context;
    EditText passwordInput;
    TextView pwStrengthText;
    TextView passwordStatusText;
    ProgressBar progressBar;
    PasswordMeterAlgorithm algorithm;

    public int      minLength = 8;
    public boolean  mustContainSpecialCharacters = true;
    public boolean  mustContainUppercase = true;


    public PasswordMeter(Context con, AttributeSet attrs){
        super(con,attrs);
        this.context=con;
        init();


    }


    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.password_meter, this);

        passwordInput = findViewById(R.id.passwordInput);
        pwStrengthText = findViewById(R.id.strengthText);
        progressBar = findViewById(R.id.passwordProgressBar);
        passwordStatusText = findViewById(R.id.passwordStatusText);



        progressBar.setMax(max_strength);
        clear();
        passwordStatusText.setText("");



        // Default strength algorithm
        algorithm = new PasswordMeterAlgorithm() {
            @Override
            public int evaluatePassword(String password) {
                Random rand = new Random();

                return  rand.nextInt(max_strength + 1);
            };

        };

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {

                String input = editable.toString();

                boolean isValid = validatePassword(input);

                if(!isValid){
                    clear();
                    return;
                }

                if(input.isEmpty()){
                    clear();
                }

                int strength = algorithm.evaluatePassword(input);

                // Weak
                if(strength < 25){
                    progressBar.setProgress(strength);
                    pwStrengthText.setText("Weak");
                    pwStrengthText.setBackgroundColor(Color.YELLOW);
                }

                // Good
                else if(strength >= 25 && strength < 50){
                    progressBar.setProgress(50);
                    pwStrengthText.setText("Good");
                    pwStrengthText.setBackgroundColor(Color.GREEN);
                }

                // Strong
                else if(strength >= 50 && strength < 75){
                    progressBar.setProgress(75);
                    pwStrengthText.setText("Strong");
                    pwStrengthText.setBackgroundColor(Color.BLUE);
                }

                // Very strong
                else if(strength >= 75 && strength <= 100){
                    progressBar.setProgress(100);
                    pwStrengthText.setText("Very strong");
                    pwStrengthText.setBackgroundColor(Color.MAGENTA);
                }
            }
        };

        passwordInput.addTextChangedListener(textWatcher);

    }

    private boolean validatePassword(String input){

        boolean isValid = true;
        String statusText = "";


        /*
        public int      minLength = 8;
        public boolean  mustContainSpecialCharacters = true;
        public boolean  mustContainUppercase = true;
        */

        if(input.length() < minLength){
            statusText += " - Password must be at least " + minLength + " characters long\n";
            isValid = false;
        }

        if(mustContainSpecialCharacters){

            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(input);
            boolean containsSpecialChar = m.find();

            if (!containsSpecialChar){
                statusText += " - Password must contain a special character\n";
                isValid = false;
            }
        }


        if(mustContainUppercase){
            boolean hasUppercase = !input.equals(input.toLowerCase());

            if(!hasUppercase){
                statusText += " - Password must contain uppercase letters\n";
                isValid = false;
            }

        }


        passwordStatusText.setText(statusText);
        return isValid;
    }

    private void clear(){
        pwStrengthText.setBackgroundColor(Color.TRANSPARENT);
        pwStrengthText.setText("");
        progressBar.setProgress(0);
    }

    public void setAlgorithm(PasswordMeterAlgorithm alg){
        this.algorithm = alg;
    }

}
