package com.eaglei.android_heros_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import chapter_five.DragView3;

public class ScrollActi extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        button = (Button) findViewById(R.id.btn_int);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollActi.this , ScrollViewGroupActi.class);
                startActivity(intent);
            }
        });
    }
}
