package com.yyyu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yyyu.line_chart.TestLineChartActivity;
import com.yyyu.testnestedscroll.R;
import com.yyyu.testnestedscroll.coordinator.TestCollapseActivity;
import com.yyyu.testnestedscroll.coordinator.TestCoordinatorActivity;
import com.yyyu.testnestedscroll.dispatch_event.TestDispatchEventActivity;
import com.yyyu.testnestedscroll.nested.TestNestedActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn_dispatch;
    private Button btn_coo;
    private Button btn_collapse;
    private Button btn_nested;
    private Button btn_line_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        btn_dispatch = (Button) findViewById(R.id.btn_dispatch);
        btn_coo = (Button) findViewById(R.id.btn_coo);
        btn_collapse = (Button) findViewById(R.id.btn_collapse);
        btn_nested = (Button) findViewById(R.id.btn_nested);
        btn_line_chart = (Button) findViewById(R.id.btn_line_chart);
    }

    private void initListener() {
        btn_dispatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestDispatchEventActivity.startAction(MainActivity.this);
            }
        });
        btn_coo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestCoordinatorActivity.startAction(MainActivity.this);
            }
        });

        btn_collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestCollapseActivity.startAction(MainActivity.this);
            }
        });
        btn_nested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestNestedActivity.startAction(MainActivity.this);
            }
        });
        btn_line_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestLineChartActivity.startAction(MainActivity.this);
            }
        });
    }


}
