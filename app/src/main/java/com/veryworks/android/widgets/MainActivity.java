package com.veryworks.android.widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 1. 사용할 위젯의 변수를 선언한다.
    Button btnGrid;
    Button calc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 선언된 변수에 xml 의 위젯 id를 가져와서 담아준다.
        btnGrid = (Button) findViewById(R.id.btnGrid);
        calc = (Button) findViewById(R.id.calc);

        // 3. 변수(위젯)을 리스너에 달아준다.
        btnGrid.setOnClickListener(this);
        calc.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.btnGrid:
                // 안드로이드 메이저 컴포넌트를 로드하기 위해서는
                // intent 를 통해서 로드할 컴포넌트를 지정해야 한다.
                intent = new Intent(this, GridActivity.class);
                                                      // ^ 대상이 되는 컴포넌트
                startActivity(intent);
                break;

            case R.id.calc :
                intent = new Intent(this, WidgetActivity.class);
                startActivity(intent);
                break;

        }
    }
}
