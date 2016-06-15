package complex_demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by eagle on 2016/6/15.
 */
public class CircleProgress extends View{

    private int mMeasureHeight;
    private int mMeasureWidth;

    private Paint mCirclePaint;
    private float mCircleXY;
    private float mRadius;

    private Paint mArcPaint;
    private RectF mArcRectF;
    private float mSweepAngle;
    private float mSweepValue = 66;

    private Paint mTextPaint;
    private String mShowText;
    private float mShowTextSize;


    public CircleProgress(Context context) {
        super(context);
    }

    public CircleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mMeasureWidth,mMeasureHeight);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);

        canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY, mCircleXY + (mShowTextSize / 4), mTextPaint);

        canvas.drawArc(mArcRectF, 270, mSweepAngle, false, mArcPaint);
    }

    private void initView() {
        float length = 0 ;
        if (mMeasureHeight >= mMeasureWidth){
            length = mMeasureWidth;
        }else {
            length = mMeasureHeight;
        }

        mCircleXY = length /2 ;
        mRadius = (float) (length * 0.5 / 2);
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));

        mArcRectF = new RectF((float)(length * 0.1),(float)(length * 0.1) ,(float) (length * 0.9 ), (float)(length * 0.9));
        mSweepAngle = (mSweepValue /100f) * 360f;
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mArcPaint.setStrokeWidth((float) (length * 0.1));
        mArcPaint.setStyle(Paint.Style.STROKE);

        mShowText = setShowText();
        mShowTextSize = setShowTextSize();
        mTextPaint = new Paint();
        mTextPaint.setTextSize(mShowTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    private float setShowTextSize() {
        this.invalidate();
        return 50;
    }

    private String setShowText() {
        this.invalidate();
        return "Android Skill";
    }

    public void forceInvalidate(){
        this.invalidate();
    }

    public void setSweepValue(float sweepValue){
        if (sweepValue != 0){
            mSweepValue = sweepValue;
        }else {
            mSweepValue = 25;
        }
        this.invalidate();
    }
}
