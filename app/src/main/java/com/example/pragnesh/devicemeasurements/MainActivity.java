package com.example.pragnesh.devicemeasurements;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView width11, width22, height22, height11;
    Button with, without, clear;
    float density;

    public static String getScreenWidth() {
        return String.valueOf(Resources.getSystem().getDisplayMetrics().widthPixels);
    }

    public static String getScreenHeight() {
        return String.valueOf(Resources.getSystem().getDisplayMetrics().heightPixels);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        width11 = findViewById(R.id.width11);
        width22 = findViewById(R.id.width22);
        height11 = findViewById(R.id.height11);
        height22 = findViewById(R.id.height22);
        with = findViewById(R.id.with);
        clear = findViewById(R.id.clear);
        without = findViewById(R.id.without);

        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        density = getResources().getDisplayMetrics().density;

        //click event of CHECK WITH METHOD button
        with.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = String.valueOf((displayMetrics.heightPixels) / density) + "dp";
                String width = String.valueOf((displayMetrics.widthPixels) / density) + "dp";
                width11.setText(width);
                height11.setText(height);
            }
        });
        //click event of CHECK WITHOUT METHOD button
        without.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                width22.setText(getScreenWidth());
                height22.setText(getScreenHeight());
            }
        });
        //click event of clear button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                width11.setText("0");
                height11.setText("0");
                width22.setText("0");
                height22.setText("0");
            }
        });

    }
}