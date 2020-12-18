package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1,tv2,tv3,data,chehao;
    private Switch kg1,kg2,kg3;

    private ImageView imageView;
    private AnimationDrawable animationDrawable;               //动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();





    }

    private void getTime() {
        //获取现在的时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        data.setText(year+"年"+(month+1)+"月"+day+"日");
        if (day%2==0){
            chehao.setText("双号出行车辆：2号");

            tv1.setText("关");
            tv2.setText("开");
            tv3.setText("关");

            setKG(false);
        }else {
            chehao.setText("单号出行车辆：1、3号");

            tv1.setText("开");
            tv2.setText("关");
            tv3.setText("开");

            setKG(true);

        }



    }

    private void setKG(boolean is) {   //设置开关
        kg1.setChecked(is);
        kg2.setChecked(!is);
        kg3.setChecked(is);
        kg1.setEnabled(is);
        kg2.setEnabled(!is);
        kg3.setEnabled(is);
    }

    private void jianting() {
        kg1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv1.setText("开");
                }else {
                    tv1.setText("关");
                }
            }
        });
        kg2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                 tv2.setText("开");
                }else{
                    tv2.setText("关");
                }
            }
        });
        kg3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tv3.setText("开");
                }else {
                tv3.setText("关");
                }
            }
        });
    }

    private void donghua() {
        imageView.setBackgroundResource(R.drawable.donghua);
        animationDrawable = (AnimationDrawable)imageView.getBackground();
        animationDrawable.start();

    }

    private void initView() {

        data = findViewById(R.id.date);
        data.setOnClickListener(this);

        chehao = findViewById(R.id.chehao);


        imageView = findViewById(R.id.donghua);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        kg1 = findViewById(R.id.kg1);
        kg2 = findViewById(R.id.kg2);
        kg3 = findViewById(R.id.kg3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.date:
                setTime();
                break;
            default:
                break;
        }
    }

    private void setTime() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                data.setText(year+"年"+month+"月"+dayOfMonth+"日");
                if (dayOfMonth%2==0){
                    chehao.setText("双号出行车辆：2号");

                    setKG(false);
                }else {
                    chehao.setText("单号出行车辆：1、3号");

                    setKG(true);
                }
            }
        },year,month,day).show();
    }
}