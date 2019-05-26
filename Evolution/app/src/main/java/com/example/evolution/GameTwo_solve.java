package com.example.evolution;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class GameTwo_solve extends Activity {

    //TODO:游戏二

    private Switch mSwitch1;
    private Switch mSwitch2;
    private Switch mSwitch3;
    private Switch mSwitch4;
    private ImageView imageView;

    private int flag1=0;
    private int flag2=0;
    private int flag3=0;
    private int flag4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_two_solve);
        imageView = findViewById(R.id.image_view);
        mSwitch1 = findViewById(R.id.switch1);
        mSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    flag1=1;
//                    Toast.makeText(GameTwo_solve.this,"1",Toast.LENGTH_SHORT).show();
                }else {
//                    Toast.makeText(GameTwo_solve.this,"0",Toast.LENGTH_SHORT).show();
                    flag1 = 0;
                }
            }
        });
        mSwitch2 = findViewById(R.id.switch2);
        mSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    flag2=1;
//                    Toast.makeText(GameTwo_solve.this,"1",Toast.LENGTH_SHORT).show();
                }else {
//                    Toast.makeText(GameTwo_solve.this,"0",Toast.LENGTH_SHORT).show();
                    flag2=0;
                }
            }
        });
        mSwitch3 = findViewById(R.id.switch3);
        mSwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    flag3=1;
//                    Toast.makeText(GameTwo_solve.this,"1",Toast.LENGTH_SHORT).show();
                }else {
//                    Toast.makeText(GameTwo_solve.this,"0",Toast.LENGTH_SHORT).show();
                    flag3=0;
                }
            }
        });
        mSwitch4 = findViewById(R.id.switch4);
        mSwitch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    flag4=1;
//                    Toast.makeText(GameTwo_solve.this,"1",Toast.LENGTH_SHORT).show();
                }else {
//                    Toast.makeText(GameTwo_solve.this,"0",Toast.LENGTH_SHORT).show();
                    flag4=0;
                }
            }
        });
    }
    public void check(View view){
        if(flag1==0&&flag2==0&&flag3==0&&flag4==0)
        { Toast.makeText(this,"你输入的是0000,是十进制的0，答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_0000);}
        else if (flag1==0&flag2==0&&flag3==0&&flag4==1)
        {
            Toast.makeText(this,"你输入的是0001,是十进制的1,答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_0001);
        }
        else if (flag1==0&flag2==0&&flag3==1&&flag4==0) {
            Toast.makeText(this, "你输入的是0010,是十进制的2,答案错误", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_0010);
        }
        else if (flag1==0&flag2==0&&flag3==1&&flag4==1) {
            Toast.makeText(this, "你输入的是0011,是十进制的3，答案错误", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_0011);
        }
        else if (flag1==0&flag2==1&&flag3==0&&flag4==0){
            Toast.makeText(this,"你输入的是0100,是十进制的4，答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_0100);}
        else if (flag1==0&flag2==1&&flag3==0&&flag4==1){
            Toast.makeText(this,"你输入的是0101,是十进制的5，答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_0101);}
        else if (flag1==0&flag2==1&&flag3==1&&flag4==0) {
            Toast.makeText(this, "你输入的是0110,是十进制的6，答案错误", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_0110);}
        else if (flag1==0&flag2==1&&flag3==1&&flag4==1){
            Toast.makeText(this,"你输入的是0111,是十进制的7，答案正确,继续前进吧",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_0111);
            Intent intent = new Intent();
            intent.putExtra("OK","OK");
            setResult(RESULT_OK,intent);
            finish();
        }
        else if(flag1==1&&flag2==0&&flag3==0&&flag4==0){
            Toast.makeText(this,"你输入的是1000,是十进制的8，答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_1000);}
        else if (flag1==1&flag2==0&&flag3==0&&flag4==1) {
            Toast.makeText(this, "你输入的是1001,是十进制的9，答案错误", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_1001);}
        else if (flag1==1&flag2==0&&flag3==1&&flag4==0){
            Toast.makeText(this,"你输入的是1010,是十进制的10，答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_1010);}
        else if (flag1==1&flag2==0&&flag3==1&&flag4==1){
            Toast.makeText(this,"你输入的是1011,是十进制的11，答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_1011);}
        else if (flag1==1&flag2==1&&flag3==0&&flag4==0){
            Toast.makeText(this,"你输入的是1100,是十进制的12，答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_1100);}
        else if (flag1==1&flag2==1&&flag3==0&&flag4==1){
            Toast.makeText(this,"你输入的是1101,是十进制的13，答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_1101);}
        else if (flag1==1&flag2==1&&flag3==1&&flag4==0){
            Toast.makeText(this,"你输入的是1110,是十进制的14，答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_1110);}
        else if (flag1==1&flag2==1&&flag3==1&&flag4==1){
            Toast.makeText(this,"你输入的是1111,是十进制的15，答案错误",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p_1111);}
    }
}
