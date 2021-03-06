package chapter_six;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eagle on 2016/6/22.
 */
public class SurfaceViewTest1 extends SurfaceView implements SurfaceHolder.Callback,Runnable{

    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private boolean mIsDrawing;
    private int x;
    private int y;
    private Paint mPaint;
    private Path mPath;

    public SurfaceViewTest1(Context context) {
        this(context, null);
    }

    public SurfaceViewTest1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SurfaceViewTest1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        mPath.moveTo(0, 400);
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    @Override
    public void run() {
        while (mIsDrawing){
            draw();
            x += 1;
            y = (int) (100 * Math.sin(x * 2 * Math.PI / 180) +400);
            mPath.lineTo(x , y);
        }
    }

    private void draw(){
        try {
            mCanvas = mHolder.lockCanvas();
            //mCanvas.drawColor(Color.WHITE);
            mCanvas.drawPath(mPath , mPaint);
        }catch (Exception e){

        }finally {
            if (mCanvas != null){
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }
}
