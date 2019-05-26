package com.example.evolution;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class IntroductionPage extends Activity {

    //TODO：介绍页一，介绍游戏背景

    private Timer timer;
    private ImageView dog;
    private TextView textView5;
    private Handler handler;
    private Boolean lock = false;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_introduction);
        dog = findViewById(R.id.imageView2);
        textView5 = findViewById(R.id.textView5);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(textView5,"alpha",0f, 1f);
        objectAnimator4.setDuration(10000);
        textView5.setText("Touch the screen to continue");
        objectAnimator4.start();
        handler = new Handler();
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(dog,"translationX",900f);
        objectAnimator.setDuration(4000);
        objectAnimator.start();
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {}
            @Override
            public void onAnimationEnd(Animator animation) {
                        lock = true;
            }
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
        });
        movingEffect();
    }
    //实现移动效果
    private void movingEffect() {
        timer = new Timer();
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(flag%2==0) {
                            dog.setImageResource(R.drawable.dog_2);
                        }
                        else {
                            dog.setImageResource(R.drawable.dog_1);
                        }
                        flag++;
                    }
                });
            }
        };
        timer.schedule(task2,0,400);
    }
    //下一个Activity
    public void clicked(View v) {
        if(lock) {
            Intent next = new Intent();
            next.setClass(this, GameOne.class);
            startActivity(next);
            finish();
        }
    }
}
