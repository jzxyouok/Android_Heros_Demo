package com.eaglei.android_heros_demo;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HideShow_AutoAct extends AppCompatActivity {
    private ListView mListview;
    private String [] mData = new String[20];
    private Toolbar toolbar;
    private int mTouchSlop;
    private float mFirstY;
    private float mCurrentY;
    private int direction;
    private ObjectAnimator mAnimator;
    private boolean mShow = true;

    View.OnTouchListener mListener =new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = event.getY();
                    if (mCurrentY - mFirstY > mTouchSlop){
                        direction = 0;
                    }else  if (mCurrentY - mFirstY < mTouchSlop){
                        direction = 1;
                    }
                    if (direction == 1){
                        if (mShow){
                            toolbarAnim(1);
                            mShow = !mShow;
                        }
                    }else if (direction == 0){
                        if (!mShow){
                            toolbarAnim(0);
                            mShow = !mShow;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    };

    private void toolbarAnim(int i) {
        if (mAnimator != null && mAnimator.isRunning()){
            mAnimator.cancel();
        }
        if (i == 0){
            mAnimator = ObjectAnimator.ofFloat(toolbar,"translationY",toolbar.getTranslationY(),0);
        }else{
            mAnimator = ObjectAnimator.ofFloat(toolbar,"translationY",toolbar.getTranslationY(),-toolbar
                    .getHeight());
        }
        mAnimator.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_show__auto);
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        toolbar = (Toolbar) findViewById(R.id.hsa_tool);
        setSupportActionBar(toolbar);
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        mListview = (ListView) findViewById(R.id.hideshow_listview);
        for (int i = 0; i < mData.length; i++) {
            mData[i] = "Item " + i;
        }
        /*View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(
                        R.dimen.abc_action_bar_default_height_material)));
        mListview.addHeaderView(header);*/
        mListview.setAdapter(new ArrayAdapter<String>(
                HideShow_AutoAct.this,
                android.R.layout.simple_expandable_list_item_1,
                mData));
        mListview.setOnTouchListener(mListener);
    }



}
