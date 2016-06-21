package chapter_six;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.eaglei.android_heros_demo.R;

/**
 * Created by eagle on 2016/6/21.
 */
public class RoundRecPoterView extends View{

    private Bitmap mBitmap;
    private Bitmap mOut;
    private Paint mPaint;

    public RoundRecPoterView(Context context) {
        this(context, null);
    }

    public RoundRecPoterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRecPoterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initView() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test1);
        mOut = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mOut);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        canvas.drawRoundRect(0, 0, mBitmap.getWidth(), mBitmap.getHeight(), 80, 80, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mBitmap , 0 , 0, mPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mOut , 0 , 0 , null);
    }
}
