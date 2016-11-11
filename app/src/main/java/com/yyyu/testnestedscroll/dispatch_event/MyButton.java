package com.yyyu.testnestedscroll.dispatch_event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * 功能：
 *
 * Created by yyyu on 2016/9/18.
 */
public class MyButton extends Button{

    private static final String TAG = "MyButton";

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        Log.e(TAG, "MyButton的dispatchTouchEvent==event==="+event.getAction());

        return super.dispatchTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                //getParent().requestDisallowInterceptTouchEvent(true);
                Log.e(TAG, "view中的onTouchEvent======ACTION_DOWN=======");
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                Log.e(TAG, "view中的onTouchEvent======ACTION_MOVE=======");
                break;
            }
            case MotionEvent.ACTION_UP:{
                //getParent().requestDisallowInterceptTouchEvent(false);
                Log.e(TAG, "view中的onTouchEvent======ACTION_UP2=======");
                break;
            }
        }

        return super.onTouchEvent(event);
    }
}
