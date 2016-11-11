package com.yyyu.line_chart;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;

import com.yyyu.testnestedscroll.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 功能：
 *
 * Created by yyyu on 2016/9/29.
 */
public class TestLineChartActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_line_chart);

        MyLineChart mlc_test = (MyLineChart) findViewById(R.id.mlc_test);

        List<Point> data = new ArrayList<>() ;
        for (int i = 0 ; i<20 ; i++){
            data.add(new Point(i*40 , 100+1000*i));
        }
        mlc_test.addData(data , Color.parseColor("#D64321"));

        List<Point> data2 = new ArrayList<>() ;
        for (int i = 0 ; i<30 ; i++){
            data2.add(new Point(i*40 , 100+100*i*(new Random().nextInt(100) ) ));
        }
        mlc_test.addData(data2 , Color.parseColor("#E3AB4A"));

    }

    public static void startAction(Activity activity){
        Intent intent = new Intent(activity, TestLineChartActivity.class);
        activity.startActivity(intent);
    }

}
