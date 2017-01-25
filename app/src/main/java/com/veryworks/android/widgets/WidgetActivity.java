package com.veryworks.android.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class WidgetActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    ToggleButton tb;
    CheckBox cbApple;
    CheckBox cbBanana;
    CheckBox cbCherry;
    RadioGroup rg;
    Spinner sp;
    SeekBar sb;
    TextView seekTv;

    ArrayList<String> months = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        // 1. 컴파운드 계열 버튼 작성
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        cbApple = (CheckBox) findViewById(R.id.cbApple);
        cbBanana = (CheckBox) findViewById(R.id.cbBanana);
        cbCherry = (CheckBox) findViewById(R.id.cbCherry);

        // 1.1 컴파운드 계열 리스너 등록
        tb.setOnCheckedChangeListener(this);
        cbApple.setOnCheckedChangeListener(this);
        cbBanana.setOnCheckedChangeListener(this);
        cbCherry.setOnCheckedChangeListener(this);

        // 2. 라디오
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        // 2.1 라디오그룹 리스너 생성 및 등록 같이 하기
        rg.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int button_id) {
                switch(button_id){
                    case R.id.rdAnaconda:
                        Toast.makeText(WidgetActivity.this, "Anaconda 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdBear:
                        Toast.makeText(WidgetActivity.this, "Bear 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdCat:
                        Toast.makeText(WidgetActivity.this, "Cat 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        // 3. 스피너
        sp = (Spinner) findViewById(R.id.spinner);

        // 3.pre 스피너에 들어갈 데이터를 동적으로 정의하세요
        //   데이터 = 올해부터 ~ 100년전까지
        // months.add("2017");
        for(int index=2017;index>2017-100;index--){
            months.add(index+"");
        }
        // 3.1 스피너 데이터 아답터로 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,      android.R.layout.simple_spinner_dropdown_item,   months
                // 컨텍스트 ,           스피너에서 사용할 레이아웃 ,             배열데이터
        );
        // 3.2 스피너에 아답터 등록
        sp.setAdapter(adapter);
        // 3.3 스피너 리스너에 등록
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(WidgetActivity.this, "선택된아이템="+months.get(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        // 4. seekbar 등록, 변경사항을 seekTv 에 보여준다
        sb = (SeekBar) findViewById(R.id.seekBar);
        seekTv = (TextView) findViewById(R.id.seekTv);

        // 4.1 seekbar 에 리스너를 등록한다.
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // 4.1.2 seekbar 를 움직이면 호출되는 함수
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekTv.setText( progress + "" ); // ***** 중요 : setText 함수에 숫자값만 넘기면 시스템 다운됨 *****
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton cb, boolean flag) {
        switch(cb.getId()){
            case R.id.toggleButton:
                Toast.makeText(this, "토글됨="+flag, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.cbApple:
                Toast.makeText(this, "사과 체크됨="+flag, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.cbBanana:
                Toast.makeText(this, "바나나 체크됨="+flag, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.cbCherry:
                Toast.makeText(this, "체리 체크됨="+flag, Toast.LENGTH_SHORT ).show();
                break;
        }
    }
}
