package com.eaglei.android_heros_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import simple_demo.CombounView;

public class SecondActivity extends AppCompatActivity {
    CombounView combounView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        combounView = (CombounView) findViewById(R.id.topbar);
        combounView.setOnToobarClickListener(new CombounView.TopbarClickListener() {
            @Override
            public void leftClick() {

            }

            @Override
            public void rightClick() {

            }
        });
    }
}
