package chapter_four;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * Created by eagle on 2016/6/16.
 */
public class SmoothListview extends ListView{

    private int mMaxOverScrollDistance = 20;

    public SmoothListview(Context context) {
        this(context, null);
    }

    public SmoothListview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmoothListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        DisplayMetrics mDm = context.getResources().getDisplayMetrics();
        float density = mDm.density;
        mMaxOverScrollDistance = (int) (density * mMaxOverScrollDistance);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY,
                maxOverScrollX, mMaxOverScrollDistance, isTouchEvent);
    }
}
