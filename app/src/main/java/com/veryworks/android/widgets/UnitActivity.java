package com.veryworks.android.widgets;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class UnitActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLength, btnArea, btnWeight;
    LinearLayout layoutLength, layoutArea, layoutWeight;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

        // EditText 가져오기
        // EditText.getText().toString();
        et = (EditText) findViewById(R.id.editText3);
        Toast.makeText(this, "EditText:"+et.getText().toString(), Toast.LENGTH_SHORT).show();

        // EidtText 사용안되게
        //et.setEnabled(false); // < 모든 위젯
        //et.setKeyListener(null); // < EditText 만

        // EditText 리스너
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                Log.i("Input Text", "after="+s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        // 1. 위젯 가져오기
        btnLength = (Button) findViewById(R.id.btnLength);
        btnArea = (Button) findViewById(R.id.btnArea);
        btnWeight = (Button) findViewById(R.id.btnWeight);

        layoutLength = (LinearLayout) findViewById(R.id.layoutLength);
        layoutArea = (LinearLayout) findViewById(R.id.layoutArea);
        layoutWeight = (LinearLayout) findViewById(R.id.layoutWeight);

        // 2. 버튼 클릭 리스너 등록
        btnLength.setOnClickListener(this);
        btnArea.setOnClickListener(this);
        btnWeight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // 클릭이 일어나면 레이아웃을 모두 지운다
        layoutLength.setVisibility(View.GONE);
        layoutArea.setVisibility(View.GONE);
        layoutWeight.setVisibility(View.GONE);

        // 클릭된 버튼에 해당하는 레이아웃만 보여준다.
        switch(view.getId()){
            case R.id.btnLength:
                layoutLength.setVisibility(View.VISIBLE);
                break;
            case R.id.btnArea:
                layoutArea.setVisibility(View.VISIBLE);
                break;
            case R.id.btnWeight:
                layoutWeight.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void setLayout(LinearLayout target){


    }

}
