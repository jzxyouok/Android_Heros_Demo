package chapter_seven;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by eagle on 2016/6/22.
 */
public class CustomerTv extends Animation{
    private int mCenterWidth;
    private int mCenterHeight;
    private Camera mCamera = new Camera();
    private float mRotateY = 0.0f;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(1000);
        setFillAfter(true);
        setInterpolator(new AccelerateInterpolator());
        mCenterWidth = width / 2 ;
        mCenterHeight = height / 2 ;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Matrix matrix = t.getMatrix();
        matrix.preScale(1 , 1 -interpolatedTime , mCenterWidth , mCenterHeight);
    }
}
