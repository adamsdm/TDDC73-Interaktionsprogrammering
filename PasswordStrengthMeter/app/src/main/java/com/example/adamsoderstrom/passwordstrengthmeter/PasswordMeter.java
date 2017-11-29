package com.example.adamsoderstrom.passwordstrengthmeter;

import android.content.Context;
import android.graphics.Color;
import android.nfc.Tag;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.ContentValues.TAG;

/**
 * Password meter
 */
public class PasswordMeter extends LinearLayout {

    private int max_strength = 100;

    Context context;
    EditText passwordInput;
    TextView pwStrengthText;
    TextView passwordStatusText;
    ProgressBar progressBar;
    PasswordMeterAlgorithm algorithm;

    int[] strengthColors = new int[4];

    public int      minLength = 8;
    public boolean  canContainSpecialCharacters = true;
    public boolean  mustContainNumber = true;
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

        strengthColors[0] = Color.YELLOW;
        strengthColors[1] = Color.GREEN;
        strengthColors[2] = Color.BLUE;
        strengthColors[3] = Color.MAGENTA;

        progressBar.setMax(max_strength);
        clear();
        passwordStatusText.setText("");



        // Default strength algorithm
        algorithm = new PasswordMeterAlgorithm() {
            @Override
            public int evaluatePassword(String password) {
                Log.w(TAG, "evaluatePassword: USING DEFAULT PASSWORD ALGORITHM");
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

                if(input.isEmpty()){
                    clear();
                }

                if(!isValid){
                    clear();
                    return;
                }

                int strength = algorithm.evaluatePassword(input);



                // Weak
                if(strength < 25){
                    progressBar.setProgress(10);
                    pwStrengthText.setText("Weak");
                    pwStrengthText.setBackgroundColor(strengthColors[0]);
                }

                // Good
                else if(strength >= 25 && strength < 50){
                    progressBar.setProgress(50);
                    pwStrengthText.setText("Good");
                    pwStrengthText.setBackgroundColor(strengthColors[1]);
                }

                // Strong
                else if(strength >= 50 && strength < 75){
                    progressBar.setProgress(75);
                    pwStrengthText.setText("Strong");
                    pwStrengthText.setBackgroundColor(strengthColors[2]);
                }

                // Very strong
                else if(strength >= 75 && strength <= 100){
                    progressBar.setProgress(100);
                    pwStrengthText.setText("Very strong");
                    pwStrengthText.setBackgroundColor(strengthColors[3]);
                }
            }
        };

        passwordInput.addTextChangedListener(textWatcher);

    }

    private boolean validatePassword(String input){

        boolean isValid = true;
        String statusText = "";



        if(input.length() < minLength){
            statusText += " - Password must be at least " + minLength + " characters long\n";
            isValid = false;
        }

        if(!canContainSpecialCharacters){

            Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(input);
            boolean containsSpecialChar = m.find();

            if (containsSpecialChar){
                statusText += " - Password can't contain a special characters\n";
                isValid = false;
            }
        }

        if(mustContainNumber){

            Pattern p = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(input);
            boolean containsNumber = m.find();

            if (!containsNumber){
                statusText += " - Password must contain a number [0-9]\n";
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

    public void setStrengthColors(int[] _colors){
        if (_colors == null) throw new NullPointerException();
        if (_colors.length != 4) throw new IllegalArgumentException("Colors array must have length 4");

        strengthColors = _colors;
    }

}
