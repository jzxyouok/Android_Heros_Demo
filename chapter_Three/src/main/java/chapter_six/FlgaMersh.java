package chapter_six;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.eaglei.android_heros_demo.R;

/**
 * Created by eagle on 2016/6/21.
 */
public class FlgaMersh extends View{

    private final int WIDTH = 200;
    private final int HEIGHT = 200;
    private int COUNT = (WIDTH + 1) * (HEIGHT + 1);
    private float [] verts = new float[2 * COUNT];
    private float [] orig = new float[2 * COUNT];
    private Bitmap mBitmap;
    private float A;
    private float k = 1;

    public FlgaMersh(Context context) {
        this(context, null);
    }

    public FlgaMersh(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlgaMersh(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        setFocusable(true);
        mBitmap = BitmapFactory.decodeResource(context.getResources() , R.drawable.test4);
        float bitmapWidth = mBitmap.getWidth();
        float bitmapHeight = mBitmap.getHeight();
        int index = 0;
        for (int y = 0 ; y <= HEIGHT ; y++){
            float fy = bitmapHeight * y / HEIGHT;
            for (int x = 0 ; x <= WIDTH ; x++){
                float fx = bitmapWidth * x / WIDTH;
                orig[index * 2 + 0] = verts[index * 2 + 0] = fx;
                orig[index * 2 + 1] = verts[index * 2 + 1] = fy + 100;
                index += 1 ;
            }
        }
        A = 50;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        flagWave();
        k += 0.1F;
        canvas.drawBitmapMesh(mBitmap , WIDTH ,HEIGHT ,verts , 0 , null , 0 , null);
        invalidate();
    }

    private void flagWave() {
        for (int j = 0 ; j <= HEIGHT ; j++){
            for (int i = 0 ; i <= WIDTH ; i++){
                verts[(j * (WIDTH + 1) + i) * 2 + 0] += 0;
                float offsetY =
                        (float) Math.sin((float) i / WIDTH * 2 * Math.PI +
                                Math.PI * k);
                verts[(j * (WIDTH + 1) + i) * 2 + 1] =
                        orig[(j * WIDTH + i) * 2 + 1] + offsetY * A;
            }
        }
    }
}
