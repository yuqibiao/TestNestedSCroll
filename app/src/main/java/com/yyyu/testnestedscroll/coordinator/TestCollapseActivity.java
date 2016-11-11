package com.yyyu.testnestedscroll.coordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.yyyu.testnestedscroll.R;

/**
 * 功能：
 * Created by yyyu on 2016/9/13.
 */
public class TestCollapseActivity extends AppCompatActivity{

    private Toolbar tb_collapse;
    private CollapsingToolbarLayout ctl_collapse;
    private AppBarLayout abl_collapse;
    private AppBarLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_collapse);

        initView();

    }

    private void initView() {

        abl_collapse = (AppBarLayout) findViewById(R.id.abl_collapse);
        ctl_collapse = (CollapsingToolbarLayout) findViewById(R.id.ctb_collapse);
        tb_collapse = (Toolbar) findViewById(R.id.tb_collapse);

        //---得到第一个子控件的LayoutParams
        layoutParams = (AppBarLayout.LayoutParams) abl_collapse.getChildAt(0).getLayoutParams();

        //---title设置
        ctl_collapse.setTitle("Collapse测试");
        //---展开后title的颜色
        ctl_collapse.setExpandedTitleColor(getResources().getColor(android.R.color.white ) );
        //---未展开时Title的颜色
        ctl_collapse.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white ));
        ctl_collapse.setContentScrimColor(getResources().getColor(R.color.colorAccent));
        //ctl_collapse.setScrimsShown(true);

        setSupportActionBar(tb_collapse);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test_collapse ,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_enter_always:{
                layoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        |AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
                ctl_collapse.setLayoutParams(layoutParams);
                break;
            }
            case  R.id.menu_exit_until:{
                layoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        |AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
                ctl_collapse.setLayoutParams(layoutParams);
                break;
            }
        }

        return true;
    }

    public static void startAction(Activity activity){
        Intent intent = new Intent(activity , TestCollapseActivity.class);
        activity.startActivity(intent);
    }


}
