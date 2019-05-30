package com.example.evolution;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class ChangePageTwo extends Activity {

    //TODO:过场二

    private ImageView dog;
    private ImageView hand;
    private Handler handler;
    private Timer timer;

    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_change_page_two);
        handler = new Handler();
        dog = findViewById(R.id.imageView5);
        hand = findViewById(R.id.imageView7);
        movingEffect();
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width2 = outMetrics.widthPixels;
        final ObjectAnimator dogmove_1 = ObjectAnimator.ofFloat(dog,"translationX",-80,width2/2-180);
        final ObjectAnimator dogmove_2 = ObjectAnimator.ofFloat(dog, "translationX",2200);
        final ObjectAnimator handmove = ObjectAnimator.ofFloat(hand,"translationY",-10,450);
        final ObjectAnimator handdis = ObjectAnimator.ofFloat(hand,"alpha",1,0);
        dogmove_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {}
            @Override
            public void onAnimationEnd(Animator animation) {
                handmove.start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
        });
        handmove.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {}
            @Override
            public void onAnimationEnd(Animator animation) {
                dogmove_2.start();
                handdis.start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
        });
        dogmove_2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {}
            @Override
            public void onAnimationEnd(Animator animation) {
                next();
            }
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
        });
        dogmove_1.setDuration(2000);
        dogmove_2.setDuration(2000);
        handmove.setDuration(1500);
        dogmove_1.start();
    }

    public void next(View view) {
        Intent next = new Intent();
        next.setClass(this, GameThree_first_Map.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
    public void next() {
        Intent next = new Intent();
        next.setClass(this, GameThree_first_Map.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

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
}
