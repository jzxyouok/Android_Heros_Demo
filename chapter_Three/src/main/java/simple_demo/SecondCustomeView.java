package simple_demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by eagle on 2016/6/15.
 */
public class SecondCustomeView extends TextView{

    private LinearGradient mLinarGradient;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mViewWidth;
    private int mTranslate;

    public SecondCustomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0){
            mViewWidth = getMeasuredWidth();
            if (mViewWidth>0){
                mPaint = getPaint();
                mLinarGradient = new LinearGradient(0,0,mViewWidth,0,new int[]{Color.BLUE,0xffffffff,Color
                        .BLUE},null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinarGradient);
                mMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mMatrix != null){
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth){
                mTranslate = - mViewWidth;
            }
            mMatrix.setTranslate(mTranslate,0);
            mLinarGradient.setLocalMatrix(mMatrix);
            postInvalidateDelayed(300);
        }
    }
}
