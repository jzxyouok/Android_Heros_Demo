package com.eaglei.android_heros_demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import chapter_six.ImageHelper;

public class Primary_ColorActi extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private static int MAX_VALUE = 255;
    private static int MIN_VALUE = 127;
    private ImageView mImageView;
    private SeekBar mSeekbarhue, mSeekbarSaturation , mSeekbarLum;
    private float mHue , mSaturation , mLum;
    private Bitmap mBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary__color);

        mBitmap = BitmapFactory.decodeResource(getResources() , R.drawable.test3);
        mImageView = (ImageView) findViewById(R.id.imageview);
        mSeekbarhue = (SeekBar) findViewById(R.id.seekbarHue);
        mSeekbarSaturation = (SeekBar) findViewById(R.id.seekbarSaturation);
        mSeekbarLum = (SeekBar) findViewById(R.id.seekbatLum);
        mSeekbarLum.setOnSeekBarChangeListener(this);
        mSeekbarSaturation.setOnSeekBarChangeListener(this);
        mSeekbarhue.setOnSeekBarChangeListener(this);
        mSeekbarhue.setMax(MAX_VALUE);
        mSeekbarSaturation.setMax(MAX_VALUE);
        mSeekbarLum.setMax(MAX_VALUE);
        mSeekbarhue.setProgress(MIN_VALUE);
        mSeekbarSaturation.setProgress(MIN_VALUE);
        mSeekbarLum.setProgress(MIN_VALUE);
        mImageView.setImageBitmap(mBitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekbarHue:
                mHue = (progress - MIN_VALUE) * 1.0F / MIN_VALUE * 180 ;
                break;
            case R.id.seekbarSaturation:
                mSaturation = progress * 1.0F / MIN_VALUE ;
                break;
            case R.id.seekbatLum:
                mLum = progress * 1.0F / MIN_VALUE ;
                break;
        }
        mImageView .setImageBitmap(ImageHelper.handleImageEffect(mBitmap, mHue, mSaturation, mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
