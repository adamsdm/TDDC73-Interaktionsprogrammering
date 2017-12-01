package com.example.adam.accountregistration;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by adamsoderstrom on 30/11/17.
 */

public class ImageRow extends Row {

    private Context context;
    private ImageView input;

    public ImageRow(Context con, int resId) {
        super(con);
        this.context = con;
        this.input = new ImageView(con);
        this.input.setImageResource(resId);
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
