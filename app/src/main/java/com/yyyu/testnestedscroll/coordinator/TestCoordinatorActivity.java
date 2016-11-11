package com.yyyu.testnestedscroll.coordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.yyyu.testnestedscroll.R;

/**
 * 功能：测试CoordinatorLayout的使用
 *
 *
 * Created by yyyu on 2016/9/12.
 */
public class TestCoordinatorActivity extends AppCompatActivity{

    private AppBarLayout abl_test;
    private Toolbar tb_test;
    private AppBarLayout.LayoutParams params;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_coordinator);
        initView();
    }

    private void initView() {

        abl_test = (AppBarLayout) findViewById(R.id.abl_test);
        tb_test = (Toolbar) findViewById(R.id.tb_test);


        //---得到第一个子控件（这里的Toolbar）
        params = (AppBarLayout.LayoutParams) abl_test.getChildAt(0).getLayoutParams();
        setSupportActionBar(tb_test);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test_coo , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_jst_scroll:{
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
                tb_test.setLayoutParams(params);
                break;
            }
            case R.id.menu_enter_always:{
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        |AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
                tb_test.setLayoutParams(params);
                break;
            }
        }
        return true;
    }

    public static void startAction(Activity activity){
        Intent intent = new Intent(activity , TestCoordinatorActivity.class);
        activity.startActivity(intent);
    }

}
