package com.example.adamsoderstrom.tddc73lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));

        InteractiveSearcher v = new InteractiveSearcher(this);
        layout.addView(v);

        Button b = new Button(this);
        layout.addView(b);

        setContentView(layout);
    }
}
