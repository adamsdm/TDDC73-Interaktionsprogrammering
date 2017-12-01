package com.example.adamsoderstrom.tddc73lab3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static android.content.ContentValues.TAG;

public class SuggestionBox extends View {

    final int FONTSIZE = 52;
    final int PADDING_LEFT = 20;
    final int PADDING_RIGHT = 20;
    final int PADDING_TOP = 5;
    final int OFFSET_TOP = 50;

    Paint p = new Paint();
    Paint textPaint = new Paint();
    Context context;
    InteractiveSearcher searcher;
    private String[] currentSuggestions = new String[0];


    public SuggestionBox(Context con, InteractiveSearcher search){
        super(con);
        this.context = con;
        this.searcher = search;

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {

                int y = (int) e.getY();
                int wordNr = (y-OFFSET_TOP - PADDING_TOP)/FONTSIZE;



                if(wordNr < currentSuggestions.length){
                    searcher.setText(currentSuggestions[wordNr]);
                    currentSuggestions = new String[0];
                    invalidate();
                }

                return false;
            }
        });
    }

    public void setSuggestions(String[] newSuggestions){
        currentSuggestions = newSuggestions;

        // Redraw
        invalidate();
    }

    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);

        // Clear canvas
        canvas.drawColor(Color.TRANSPARENT);

        p.setColor(Color.parseColor("#ffffff"));

        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(FONTSIZE);


        Rect bounds = new Rect();
        float maxTextWidth = 0;


        for(int i=0; i<currentSuggestions.length; i++){
            textPaint.getTextBounds(currentSuggestions[i], 0, currentSuggestions[i].length(), bounds);

            if(bounds.width() > maxTextWidth)
                maxTextWidth = bounds.width() + PADDING_RIGHT;
        }

        float totalWidth = PADDING_LEFT  + maxTextWidth;
        float totalHeight = OFFSET_TOP/2 + currentSuggestions.length * FONTSIZE + PADDING_TOP;

        canvas.drawRect(PADDING_LEFT,0,totalWidth, totalHeight , p);



        // The actual text
        for(int i=0; i<currentSuggestions.length; i++){
            String message = currentSuggestions[i];
            canvas.drawText(message, PADDING_LEFT, OFFSET_TOP + i * FONTSIZE + PADDING_TOP  , textPaint);
        }

    }

}
