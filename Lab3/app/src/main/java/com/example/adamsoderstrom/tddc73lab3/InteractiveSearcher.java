package com.example.adamsoderstrom.tddc73lab3;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import static android.content.ContentValues.TAG;

public class InteractiveSearcher extends LinearLayout{

    Context c;
    private EditText input;
    private JsonHTTPGet myTask;
    SuggestionBox suggestionBox;
    TextWatcher textWatcher;
    private int getId;

    public InteractiveSearcher(Context context){
        super(context);
        this.c=context;
        init();
    }

    private void init() {
        setOrientation(LinearLayout.VERTICAL);
        input = new EditText(this.c);
        input.setHint("Enter name...");
        suggestionBox = new SuggestionBox(this.c, InteractiveSearcher.this);

        this.addView(input);
        this.addView(suggestionBox);
        getId = 0;


        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String input = editable.toString();

                Log.d(TAG, "afterTextChanged: " + input);

                if(input == null || input.isEmpty()) {
                    suggestionBox.setSuggestions(new String[0]);
                    return;
                }

                getId++;
                myTask = new JsonHTTPGet(getId, InteractiveSearcher.this);
                myTask.execute(input , Integer.toString(getId));


            }
        };

        input.addTextChangedListener(textWatcher);
    }

    public void setText(String text){
        input.removeTextChangedListener(textWatcher);
        input.setText(text);
        input.addTextChangedListener(textWatcher);
    }

    public EditText getInput(){
        return input;
    }

    public int getId(){
        return getId;
    }

    public SuggestionBox getSuggestionBox() {
        return suggestionBox;
    }



}
