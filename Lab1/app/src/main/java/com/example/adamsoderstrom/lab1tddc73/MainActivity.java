package com.example.adamsoderstrom.lab1tddc73;

import android.app.ActionBar;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //*******************//
        //****** DEL 1 ******//
        //*******************//
        /*
        // Main container för appen
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        // Simpel knapp
        Button button = new Button(this);
        button.setText("Knapp");
        layout.addView(button);


        // Textfält med max 1 rad
        EditText textField = new EditText(this);
        textField.setMaxLines(1);
        layout.addView(textField);


        // 5 rating-stjärnor
        RatingBar stars = new RatingBar(this);
        stars.setMax(5);
        stars.setNumStars(5);

        // Måste ha layout för att endast få 5 stjärnor
        LinearLayout.LayoutParams starParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.addView(stars, starParams);

        // Multiline textfält
        EditText multilineTextField = new EditText(this);
        LinearLayout.LayoutParams multilineTextFieldParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, // Match == fyll allt i detta fall
                LinearLayout.LayoutParams.MATCH_PARENT);
        layout.addView(multilineTextField, multilineTextFieldParams);
        */

        //*******************//
        //****** DEL 2 ******//
        //*******************//


        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Name row
        layout.addView(createRow("Namn", new EditText(this)));

        // Password row
        EditText password = new EditText(this);
        password.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PASSWORD);
        layout.addView(createRow("Lösenord", password));

        EditText email = new EditText(this);
        email.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        layout.addView(createRow("E-mail", email));

        SeekBar ageSlider = new SeekBar(this);
        layout.addView(createRow("Age", ageSlider));


        //*******************//
        //****** DEL 3 ******//
        //*******************//

        /*
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView text1 = new TextView(this);
        text1.setText("Hur trivs du på LiU?");
        text1.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(text1);


        // Row 1
        LinearLayout row1 = new LinearLayout(this);
        row1.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        row1.setOrientation(LinearLayout.HORIZONTAL);

        final CheckBox ch1 = new CheckBox(this);
        ch1.setText("Bra");
        row1.addView(ch1);

        final CheckBox ch2 = new CheckBox(this);
        ch2.setText("Mycket bra");
        row1.addView(ch2);

        final CheckBox ch3 = new CheckBox(this);
        ch3.setText("Jättebra");
        row1.addView(ch3);

        layout.addView(row1);

        TextView text2 = new TextView(this);
        text2.setText("Läser du på LiU?");
        text2.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(text2);


        ch1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ch1.setChecked(true);
                ch2.setChecked(false);
                ch3.setChecked(false);
            }
        });
        ch2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ch2.setChecked(true);
                ch1.setChecked(false);
                ch3.setChecked(false);
            }
        });
        ch3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ch3.setChecked(true);
                ch1.setChecked(false);
                ch2.setChecked(false);
            }
        });

        // Row 2
        LinearLayout row2 = new LinearLayout(this);
        row2.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        row2.setOrientation(LinearLayout.HORIZONTAL);

        final CheckBox ch4 = new CheckBox(this);
        ch4.setText("Ja");
        row2.addView(ch4);

        final CheckBox ch5 = new CheckBox(this);
        ch5.setText("Nej");
        row2.addView(ch5);

        ch4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ch4.setChecked(true);
                ch5.setChecked(false);
            }
        });

        ch5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ch5.setChecked(true);
                ch4.setChecked(false);
            }
        });

        layout.addView(row2);


        // Image
        ImageView image = new ImageView(this);
        image.setImageResource(R.mipmap.ic_launcher_foreground);
        layout.addView(image);

        TextView text3 = new TextView(this);
        text3.setText("Är detta LiUs logotyp?");
        text3.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(text3);

        LinearLayout row3 = new LinearLayout(this);
        row3.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        row3.setOrientation(LinearLayout.HORIZONTAL);

        final CheckBox ch6 = new CheckBox(this);
        ch6.setText("Ja");
        row3.addView(ch6);

        final CheckBox ch7 = new CheckBox(this);
        ch7.setText("Nej");
        row3.addView(ch7);

        ch6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ch6.setChecked(true);
                ch7.setChecked(false);
            }
        });

        ch7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ch7.setChecked(true);
                ch6.setChecked(false);
            }
        });

        layout.addView(row3);

        Button button = new Button(this);
        button.setText("Skicka in");
        layout.addView(button);
        */

        





        setContentView(layout);

    }

    private LinearLayout createRow(String text, View input) {
        // Create a row
        LinearLayout tmpLayout = new LinearLayout(this);
        tmpLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        tmpLayout.setOrientation(LinearLayout.HORIZONTAL);

        // Text
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setTextSize(18);

        // Setup layout
        input.setLayoutParams(new TableRow.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT, .7f));
        textView.setLayoutParams(new TableRow.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT, .3f));

        tmpLayout.addView(textView);
        tmpLayout.addView(input);

        return tmpLayout;
    }
}
