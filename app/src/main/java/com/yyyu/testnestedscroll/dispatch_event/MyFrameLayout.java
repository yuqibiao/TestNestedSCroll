package com.yyyu.testnestedscroll.dispatch_event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;

/**
 * 功能：
 * Created by yyyu on 2016/9/18.
 */
public class MyFrameLayout extends FrameLayout{

    private static final String TAG = "MyFrameLayout";

    public MyFrameLayout(Context context) {
        this(context , null);
    }

    public MyFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public MyFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "MyFrameLayout的dispatchTouchEvent==event==="+ev.getAction());

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Log.e(TAG, "activity的dispatchTouchEvent==event==="+ev.getAction());
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:{

                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_MOVE:{
                return true;
            }
        }


        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                Log.e(TAG, "viewGroup中的onTouchEvent======ACTION_DOWN=======");
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                Log.e(TAG, "viewGroup中的onTouchEvent======ACTION_MOVE=======");
                break;
            }
            case MotionEvent.ACTION_UP:{
                Log.e(TAG, "viewGroup中的onTouchEvent======ACTION_UP=======");
                break;
            }
        }

        return true;//super.onTouchEvent(event);
    }

}
