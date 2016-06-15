package com.eaglei.android_heros_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import simple_demo.CombounView;

public class MainActivity extends AppCompatActivity {
    CombounView combounView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        combounView = (CombounView) findViewById(R.id.topbar);
        combounView.setOnToobarClickListener(new CombounView.TopbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this,"left",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this,"right",Toast.LENGTH_SHORT).show();
            }
        });
        combounView.setButtonVisable(0,false);

    }
}
