package com.eaglei.android_heros_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import chapter_four.SmLisAdapter;
import chapter_four.SmoothListview;
import chapter_three.simple_demo.CombounView;

public class SmoothListviewActi extends AppCompatActivity {

    private List<String> mList = new ArrayList<>();
    private SmoothListview smoothListview;
    private SmLisAdapter mAdapter;
    private CombounView mCombounView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smooth_listview);
        initData();
        initView();
    }

    private void initView() {
        smoothListview = (SmoothListview) findViewById(R.id.slv);
        mAdapter = new SmLisAdapter(mList,SmoothListviewActi.this);
        smoothListview.setAdapter(mAdapter);
        mCombounView = (CombounView) findViewById(R.id.topbar);
        mCombounView.setOnToobarClickListener(new CombounView.TopbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {
                Intent intent = new Intent(SmoothListviewActi.this,HideShow_AutoAct.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        for (int i = 0 ; i < 100 ; i++){
            mList.add("i = "+i);
        }
    }
}
