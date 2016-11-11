package com.yyyu.testnestedscroll.nested;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.yyyu.testnestedscroll.R;

/**
 * 功能：自定义一个先隐藏Header的View
 *
 *
 * Created by yyyu on 2016/9/13.
 */
public class HiddenHeaderView extends LinearLayout implements NestedScrollingParent{

    private static final String TAG = "HiddenHeaderView";
    private NestedScrollingParentHelper nestedHelper;
    private View header;
    private int headerHeight;

    public HiddenHeaderView(Context context) {
        this(context , null);
    }

    public HiddenHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public HiddenHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
        nestedHelper = new NestedScrollingParentHelper(this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        header = findViewById(R.id.id_nested_header);
        header.measure(0 , 0 );
        headerHeight = header.getMeasuredHeight();

        Log.e(TAG , "headerHeight====="+headerHeight);

    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.e(TAG , "onStartNestedScroll==============");
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        Log.e(TAG , "onNestedScrollAccepted==============");
        nestedHelper.onNestedScrollAccepted(child , target ,axes);
    }

    @Override
    public void onStopNestedScroll(View child) {
        Log.e(TAG , "onStopNestedScroll==============");
        nestedHelper.onStopNestedScroll(child);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.e(TAG , "onNestedScroll==============");
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        boolean hiddenHeader = dy>0 && getScrollY()<=headerHeight;
        boolean showHeader = dy<0 && getScrollY()>=0;
        if(hiddenHeader | showHeader){ // 消耗滑动事件
            scrollBy(0, dy);
            consumed[1] = dy;
        }
        Log.e(TAG , "onNestedPreScroll==============");
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Log.e(TAG , "onNestedFling==============");
        return false;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Log.e(TAG , "onNestedPreFling==============");
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        Log.e(TAG , "getNestedScrollAxes==============");
        return nestedHelper.getNestedScrollAxes();
    }
}
