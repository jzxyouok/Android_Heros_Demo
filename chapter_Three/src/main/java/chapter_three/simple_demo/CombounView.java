package chapter_three.simple_demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eaglei.android_heros_demo.R;

/**
 * Created by eagle on 2016/6/15.
 */
public class CombounView extends RelativeLayout{

    private Button mLeftButton,mRightButton;
    private TextView mTextview;

    private LayoutParams mLeftParams,mTitleParams,mRightParams;

    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;

    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;

    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;

    private TopbarClickListener mListener;


    public CombounView(Context context) {
        super(context);
    }

    public CombounView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(0xFFF59563);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor1,0);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground1);
        mLeftText = ta.getString(R.styleable.TopBar_leftText1);
        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor1, 0);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground1);
        mRightText = ta.getString(R.styleable.TopBar_rightText1);
        mTitleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize1, 10);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor1, 0);
        mTitle = ta.getString(R.styleable.TopBar_title1);

        ta.recycle();
        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTextview = new TextView(context);

        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setText(mRightText);

        mTextview.setText(mTitle);
        mTextview.setTextColor(mTitleTextColor);
        mTextview.setTextSize(mTitleTextSize);
        mTextview.setGravity(Gravity.CENTER);

        mLeftParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        // 添加到ViewGroup
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTextview, mTitleParams);

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.rightClick();
            }
        });

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.leftClick();
            }
        });
    }

    public void setOnToobarClickListener(TopbarClickListener mListener){
        this.mListener = mListener;
    }

    public void setButtonVisable(int id , boolean flag){
        if (flag){
            if (id == 0){
                mLeftButton.setVisibility(View.VISIBLE);
            }else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        }else {
            if (id == 0){
                mLeftButton.setVisibility(View.GONE);
            }else {
                mRightButton.setVisibility(View.GONE);
            }
        }
    }

    public interface TopbarClickListener{
        void leftClick();

        void rightClick();
    }
}
