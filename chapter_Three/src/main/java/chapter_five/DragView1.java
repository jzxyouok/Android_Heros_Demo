package chapter_five;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by eagle on 2016/6/17.
 */
public class DragView1 extends View{

    private int lastx;
    private int lastY;

    public DragView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragView1(Context context) {
        super(context);
        initView();
    }

    public DragView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastx = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastx;
                int offsetY = y - lastY;
                layout(getLeft() + offsetX , getTop() + offsetY , getRight() + offsetX , getBottom() + offsetY);
                break;
        }

        return true;
    }
}
