package com.example.evolution;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ThanksScreen extends Activity {

    TextView creators;
    TextView csh;
    TextView dqj;
    TextView why;
    TextView xyx;
    TextView thanks;
    Timer timer;
    Timer timer2;

    Handler handler;

    int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thanks_screen);
        thanks = findViewById(R.id.textView7);
        creators = findViewById(R.id.textView19);
        csh = findViewById(R.id.textView18);
        dqj = findViewById(R.id.textView20);
        why = findViewById(R.id.textView21);
        xyx = findViewById(R.id.textView22);
        handler = new Handler();
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        go();
                    }
                });
            }
        };
        timer.schedule(timerTask,0,1000);
        final Intent intent = new Intent(this,Bgm.class);

        timer2 = new Timer();
        TimerTask tak = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        stopService(intent);
                    }
                });
            }
        };
        timer2.schedule(tak,6000);
    }

    private void go() {
        if (time == 1) {
            creators.setVisibility(View.VISIBLE);
//            ObjectAnimator animator = ObjectAnimator.ofFloat(creators, "alpha", 1f, 0f, 1f);
//            animator.setDuration(5000);
//            animator.start();
        }
        if (time == 2) {
            csh.setVisibility(View.VISIBLE);
            ObjectAnimator animator = ObjectAnimator.ofFloat(csh, "alpha", 0f, 1f);
            animator.setDuration(5000);
            animator.start();
        }
        if (time == 3) {
            dqj.setVisibility(View.VISIBLE);
            ObjectAnimator animator = ObjectAnimator.ofFloat(dqj, "alpha", 0f, 1f);
            animator.setDuration(5000);
            animator.start();
        }
        if (time == 4) {
            why.setVisibility(View.VISIBLE);
            ObjectAnimator animator = ObjectAnimator.ofFloat(why, "alpha", 0f, 1f);
            animator.setDuration(5000);
            animator.start();
        }
        if (time == 5) {
            xyx.setVisibility(View.VISIBLE);
            ObjectAnimator animator = ObjectAnimator.ofFloat(xyx, "alpha", 0f, 1f);
            animator.setDuration(5000);
            animator.start();
        }
        if (time == 6) {
            thanks.setVisibility(View.VISIBLE);
            ObjectAnimator animator = ObjectAnimator.ofFloat(thanks, "alpha", 0f, 1f);
            animator.setDuration(7000);
            animator.start();
        }
    }
}
