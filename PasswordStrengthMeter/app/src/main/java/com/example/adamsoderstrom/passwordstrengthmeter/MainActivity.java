package com.example.adamsoderstrom.passwordstrengthmeter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        PasswordMeter pm = findViewById(R.id.passwordMeter);



        pm.minLength = 0;
        pm.canContainSpecialCharacters = true;
        pm.mustContainNumber = false;
        pm.mustContainUppercase = false;

        pm.setStrengthColors(new int[]{
                Color.GRAY,
                Color.GREEN,
                    Color.YELLOW,
                    Color.RED
                });

        pm.setAlgorithm(new PasswordMeterAlgorithm() {
            @Override
            public int evaluatePassword(String password) {
                int res = 1;

                boolean containsUppercase;
                boolean containsNumber;

                // Contains number
                containsNumber = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE).matcher(password).find();

                // Contain uppercase
                containsUppercase = !password.equals(password.toLowerCase());


                if(containsNumber) res+=10;
                if(containsUppercase) res+=5;

                res = res * (password.length() / 2);
                Log.d("Main", "evaluatePassword: " + res);
                return res;
            }
        });
    }
}
