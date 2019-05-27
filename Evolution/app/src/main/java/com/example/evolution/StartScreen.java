package com.example.evolution;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class StartScreen extends Activity {

    //TODO：欢迎界面
    private Handler handler;
    private Boolean lock = false;
    private Bgm bgm;
//    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_startscreen);
        handler = new Handler();
        try {
            Thread.sleep(500);
            bgm = new Bgm();
            Intent intent = new Intent(this,Bgm.class);
//            bgm.onStartCommand(intent);
            startService(intent);
//            mediaPlayer = MediaPlayer.create(this,R.raw.bgm);
//            if(!mediaPlayer.isPlaying()) {
//                mediaPlayer.start();
//                mediaPlayer.setLooping(true);
//            }
//            mediaPlayer.setVolume(0.5f,0.5f);
            action1();
            action2();
            action3();
            action4();
            action5();
        }catch(Exception e) {}
    }
    //25
    private void action1() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ProgressBar a = findViewById(R.id.progressBar);
                ProgressBar b = findViewById(R.id.progressBar2);
                a.setProgress(a.getProgress()+25);
                b.setProgress(b.getProgress()+25);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 500);
    }
    //50
    private void action2() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ProgressBar a = findViewById(R.id.progressBar);
                ProgressBar b = findViewById(R.id.progressBar2);
                a.setProgress(a.getProgress()+25);
                b.setProgress(b.getProgress()+25);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1000);
    }
    //75
    private void action3() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ProgressBar a = findViewById(R.id.progressBar);
                ProgressBar b = findViewById(R.id.progressBar2);
                a.setProgress(a.getProgress()+25);
                b.setProgress(b.getProgress()+25);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1500);
    }
    //100
    private void action4() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ProgressBar a = findViewById(R.id.progressBar);
                ProgressBar b = findViewById(R.id.progressBar2);
                a.setProgress(a.getProgress()+25);
                b.setProgress(b.getProgress()+25);
                lock = true;
//                clicked();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 2000);
    }
    //显示触摸提示
    private void action5() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView readyForClick = findViewById(R.id.textView3);
                        readyForClick.setText("Touch the screen to continue");
                        ObjectAnimator animator = ObjectAnimator.ofFloat(readyForClick, "alpha", 1f, 0f, 1f, 0f, 1f, 0f, 1f);
                        animator.setDuration(6000);
                        animator.start();
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 2200);
    }
    //转到下一个Activity（IntroductionPage
    public void clicked(View view){
        if (lock) {
            Intent toSecond = new Intent();
            toSecond.setClass(this,IntroductionPage.class);
            startActivity(toSecond);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
    }
    //转到下一个Activity（IntroductionPage
    public void clicked(){
        if (lock) {
            Intent toSecond = new Intent();
            toSecond.setClass(this,IntroductionPage.class);
            startActivity(toSecond);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
    }

}