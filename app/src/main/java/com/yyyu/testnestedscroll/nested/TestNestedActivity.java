package com.yyyu.testnestedscroll.nested;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yyyu.testnestedscroll.R;

/**
 * 功能：测试Nested的activity
 *
 * Created by yyyu on 2016/9/13.
 */
public class TestNestedActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_nested);
    }


    public static void startAction(Activity activity){

        Intent intent = new Intent(activity , TestNestedActivity.class);
        activity.startActivity(intent);

    }

}
