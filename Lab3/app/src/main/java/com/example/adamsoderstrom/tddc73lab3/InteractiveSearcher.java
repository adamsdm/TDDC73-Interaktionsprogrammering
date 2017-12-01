package com.example.adamsoderstrom.tddc73lab3;

import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import static android.content.ContentValues.TAG;

public class InteractiveSearcher extends LinearLayout{

    Context c;
    private EditText input;
    private JsonHTTPGet myTask;
    SuggestionBox suggestionBox;
    TextWatcher textWatcher;
    private int getId;
    private PopupWindow popupWindow;


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
        popupWindow = new PopupWindow(suggestionBox,
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );

        popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setContentView(suggestionBox);
        this.addView(input);

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

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        popupWindow.showAsDropDown(this ,0, -14);


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
