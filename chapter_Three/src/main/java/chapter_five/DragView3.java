package chapter_five;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by eagle on 2016/6/17.
 */
public class DragView3 extends View{

    private int lastX;
    private int lastY;

    public DragView3(Context context) {
        super(context);
        initView();
    }

    public DragView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x ;
                lastY = y ;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                ((View)getParent()).scrollBy( - offsetX , -offsetY);
                break;
        }
        return true;
    }
}
