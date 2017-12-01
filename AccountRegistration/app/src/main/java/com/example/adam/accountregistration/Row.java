package com.example.adam.accountregistration;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;

public abstract class Row extends TableLayout {



    public Row(Context con) {
        super(con);
    }

    // TODO: Add image row

    public Row(Context con, AttributeSet attrs) {
        super(con, attrs);
    }

    protected abstract void init();

    protected abstract boolean validate();

    public abstract View getView();
}
