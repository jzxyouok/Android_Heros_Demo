package com.eaglei.android_heros_demo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import chapter_six.ImageHelper;

public class ColorMatrixActi extends AppCompatActivity {
    private ImageView mImageView;
    private GridLayout mGroup;
    private Bitmap mBitmap;
    private Bitmap mBitmap2;
    private int mEtWidth , mEtHegith;
    private EditText [] mEts = new EditText[20];
    private float [] mColorMatrix = new float[20];
    private Button mButtoneNegative , mButtonOldphoto , mButtonRelief , mButtonMesh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test1);
        mImageView = (ImageView) findViewById(R.id.imageview_color);
        mGroup = (GridLayout) findViewById(R.id.group);
        mImageView.setImageBitmap(mBitmap);
        mGroup.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth = mGroup.getWidth() / 5;
                mEtHegith = mGroup.getHeight() / 4;
                addEts();
                initMatrix();
            }
        });
        mButtoneNegative = (Button) findViewById(R.id.btn_negative);
        mButtoneNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBitmap2 = ImageHelper.handleImageNegative(mBitmap);
                mImageView.setImageBitmap(mBitmap2);
            }
        });

        mButtonOldphoto = (Button) findViewById(R.id.btn_oldphoto);
        mButtonOldphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBitmap2 = ImageHelper.handleImagePixelsOldPhoto(mBitmap);
                mImageView.setImageBitmap(mBitmap2);
            }
        });

        mButtonRelief = (Button) findViewById(R.id.btn_fudiao);
        mButtonRelief.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBitmap2 = ImageHelper.handleImagePixelsRelief(mBitmap);
                mImageView.setImageBitmap(mBitmap2);
            }
        });

        mButtonMesh = (Button) findViewById(R.id.btn_Mesh);
        mButtonMesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ColorMatrixActi.this,FlagMeshActi.class);
                startActivity(intent);
            }
        });
    }

    private void initMatrix() {
       for (int i = 0 ; i < 20 ;i++){
           if (i % 6 == 0){
               mEts[i].setText(String.valueOf(1));
           }else{
               mEts[i].setText(String.valueOf(0));
           }
       }
    }

    private void addEts() {
        for (int i = 0 ; i < 20 ; i++){
            EditText editText = new EditText(ColorMatrixActi.this);
            mEts[i] = editText;
            mGroup.addView(editText , mEtWidth , mEtHegith);
        }
    }

    public void btnChange(View view){
        getMatrix();
        setImageMatrxi();
    }

    public void btnReset(View view){
        initMatrix();
        getMatrix();
        setImageMatrxi();
    }

    private void setImageMatrxi() {
        Bitmap bmp = Bitmap.createBitmap(mBitmap.getWidth() , mBitmap.getHeight() , Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMatrix);

        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(mBitmap, 0, 0, paint);
        mImageView.setImageBitmap(bmp);
    }

    private void getMatrix() {
        for (int i = 0 ; i < 20 ; i++){
            mColorMatrix[i] = Float.valueOf(mEts[i].getText().toString());
        }
    }
}
