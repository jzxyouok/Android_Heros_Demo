package com.eaglei.android_heros_demo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import chapter_seven.CustomerTv;

public class PropertyAniActi extends AppCompatActivity implements View.OnClickListener{
    ImageView imageView;
    Button mAnimateTv;
    private int [] mRes = {R.id.imageView_a , R.id.imageView_b , R.id.imageView_c , R.id.imageView_d , R.id
            .imageView_e};
    private List<ImageView> mImageviews = new ArrayList<>();
    private boolean mFlag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_ani);
        /*imageView = (ImageView) findViewById(R.id.iv_anim);
        final ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"rotation" , 0 ,360);
        animator.setDuration(1000);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
            }
        });
        mAnimateTv = (Button) findViewById(R.id.btn_tv);
        mAnimateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerTv mTv = new CustomerTv();
                v.startAnimation(mTv);
            }
        });*/
        for (int i = 0; i < mRes.length; i++) {
            ImageView imageView = (ImageView) findViewById(mRes[i]);
            imageView.setOnClickListener(this);
            mImageviews.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView_a:
                if (mFlag){
                    startAnim();
                }else {
                    closeAnim();
                }
                break;
            default:
                Toast.makeText(PropertyAniActi.this , "hello" ,Toast.LENGTH_SHORT).show();
        }
    }

    private void closeAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageviews.get(0),
                "alpha", 0.5F, 1F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageviews.get(1),
                "translationY", 200F, 0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageviews.get(2),
                "translationX", 200F, 0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageviews.get(3),
                "translationY", -200F, 0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImageviews.get(4),
                "translationX", -200F, 0);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator0, animator1, animator2, animator3, animator4);
        set.start();
        mFlag = true;
    }

    private void startAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageviews.get(0) , "alpha" , 1F , 0.5F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageviews.get(1) , "translationY" , 200F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageviews.get(2) , "translationX" , 200F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageviews.get(3) , "translationY" , -200F);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImageviews.get(4) , "translationX" , -200F);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        //set.playTogether(animator0, animator1, animator2, animator3, animator4);
        set.playSequentially( animator1, animator2, animator3, animator4 );
        set.playTogether(animator4 , animator0);
        set.start();
        mFlag = false;
    }
}
