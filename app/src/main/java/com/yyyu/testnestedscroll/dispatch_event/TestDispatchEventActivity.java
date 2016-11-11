package com.yyyu.testnestedscroll.dispatch_event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.yyyu.testnestedscroll.R;

/**
 * 功能：测试事件分发
 *
 * 参考：www.jianshu.com/p/e99b5e8bd67b
 *
 * 小结：
 *
 * 1.Activity、ViewGroup、View中均存在dispatchEvent、onTouchEvent方法而且ViewGroup中存在
 *    onInterceptTouchEvent方法来拦截事件的分发
 *
 * 2.dispatchTouchEvent：事件的分发，Activity中返回true或者false都会消耗该分发事件，不再往下面分发。
 *    activity中也不会调用onTouchEvent事件。ViewGroup和View则只有当返回false的时候才不往下
 *    分发了，事件就交由上一级处理（如当ViewGroup中dispatchEvent返回false则Activity中的
 *    OnTouchEvent方法被调用且ACTION_UP被调用）。
 *
 * 3.onInterceptTouchEvent：ViewGroup中专有，用来拦截事件的分发，当返回true时表示不向
 *    下进行事件分发了，及本Demo中MyButton将得不到事件
 *
 * 4.onTouchEvent：触摸事件，但ACTION_UP返回时，表示该事件在此被消耗了。
 *    ACTON_DOWN不能代表该事件在此被消耗了
 *
 * 5.事件分发的流程：先是调用dispatchTouchEvent方法如果向下分发（Activity中返回super.XXX,ViewGroup中true/super.XXX）,
 *    如果向下分发则再调用下一级中的dispatchTouchEvent，如果还向下分发接着调用下一级中的dispatchTouchEvent，
 *    以此类推，直到最后一级（一般为View），调用最后一级View中的OnTouchEvent的ACTION_DOWN ,
 *    a. 如果消耗（最内层view中返回true或者super），接着调用dispatchTouchEvent知道消耗该事件的层级，
 *    本Demo中即调用Activity中的dispatchTouchEvent，ViewGroup中的dispatchTouchEvent
 *    View中的dispatchTouchEvent ，最调用view中OnTouchEvent中的ACTION_UP
 *    b. 如果不消耗回调用上一级中的OnTouchEvent中ACTION_DOWN ,直到被消耗，接着调用dispatchTouchEvent知道消耗该事件的层级
 *    最调用事件被消耗层级中OnTouchEvent中的ACTION_UP
 *    所以，整个事件流向应该是从Activity---->ViewGroup--->View 从上往下调用dispatchTouchEvent方法
 * ，一直到叶子节点（View）的时候，再由View--->ViewGroup--->Activity从下往上调用onTouchEvent方法。。
 *
 * 6. 例子:
 *     a. MyButton中消耗事件（onTouchEvent中返回super/true）
 *          activity的dispatchTouchEvent-->viewGroup中的dispatchTouchEvent-->viewGroup中的onInterceptTouchEvent
 *          -->view中的dispatchTouchEvent-->view中的onTouchEvent(ACTION_DOWN) -->activity的dispatchTouchEvent
 *          -->viewGroup中的dispatchTouchEvent-->viewGroup中的onInterceptTouchEvent-->view中的dispatchTouchEvent
 *          --> view中的onTouchEvent(ACTION_UP即被消耗)
 *     b. Activity中消耗事件（MyButton中onTouchEvent中返回false ， activity中返回true）
 *         activity的dispatchTouchEvent-->viewGroup中的dispatchTouchEvent-->viewGroup中的onInterceptTouchEvent
 *          -->view中的dispatchTouchEvent-->view中的onTouchEvent(ACTION_DOWN) -->viewGroup中的onTouchEvent(ACTION_DOWN)
 *          -->Activity中的onTouchEvent(ACTION_DOWN)--->activity的dispatchTouchEvent-->activity的onTouchEvent(ACTION_UP即消耗了事件)
 *
 * 注意：
 *
 * 1.onTouchEvent、dispatchTouchEvent 中return true 表示消耗，事件不会再传递(上一级中的OnTouchEvent也不会调用)，
 *    return false 则表示事件不再向下传递，
 *    return super.XXX表示向下分发。
 *  a. demo中MyFrameLayout中dispatchTouchEvent return false:
 *      activity的dispatchTouchEvent-->viewGroup中的dispatchTouchEvent-->activity的onTouchEvent(ACTION_DOWN)
 *      -->activity的dispatchTouchEvent-->activity的onTouchEvent(ACTION_UP)
 *  b. demo中MyFrameLayout中dispatchTouchEvent return true
 *      activity的dispatchTouchEvent-->viewGroup中的dispatchTouchEvent
 *      -->activity的dispatchTouchEvent-->viewGroup中的dispatchTouchEvent
 *
 * 2.对于 dispatchTouchEvent，onTouchEvent，return true是终结事件传递。return false 是回溯到父View的onTouchEvent方法。
 *
 * 3.ViewGroup 想把自己分发给自己的onTouchEvent，需要拦截器onInterceptTouchEvent方法return true 把事件拦截下来。
 *
 * 4.ViewGroup 的拦截器onInterceptTouchEvent 默认是不拦截的，所以return super.onInterceptTouchEvent()=return false；
 *
 * 5.View 没有拦截器，为了让View可以把事件分发给自己的onTouchEvent，View的dispatchTouchEvent默认实现（super）
 *    就是把事件分发给自己的onTouchEvent。
 *
 * Created by yyyu on 2016/9/18.
 */
public class TestDispatchEventActivity extends AppCompatActivity {

    private static final String TAG = "TestDispatchEventActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dispatch_event);
    }

    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, TestDispatchEventActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.e(TAG, "activity的dispatchTouchEvent==event==="+ev.getAction());

        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                Log.e(TAG, "activity的onTouchEvent======ACTION_DOWN=======");
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                Log.e(TAG, "activity的onTouchEvent======ACTION_MOVE=======");
                break;
            }
            case MotionEvent.ACTION_UP:{
                Log.e(TAG, "activity的onTouchEvent======ACTION_UP=======");
                break;
            }
        }

    return super.onTouchEvent(event);
}
}
