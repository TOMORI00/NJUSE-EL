package com.example.evolution;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DogNewLife extends Activity {

    private ImageView imageView8;
    private ImageView dog;
    private Timer timer;
    private ArrayList<String> instructions;
    private Handler handler;
    private int i;
    private int upstep;
    private int downstep;
    private int leftstep;
    private int rightstep;
    private ObjectAnimator upAnimator;
    private ObjectAnimator downAnimator;
    private ObjectAnimator leftAnimator;
    private ObjectAnimator rightAnimator;
    private int step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dog_new_life);
        imageView8 = findViewById(R.id.imageView8);
        dog = findViewById(R.id.imageView9);
        handler = new Handler();
        instructions = new ArrayList<String>();
        instructions.add("down");
        instructions.add("down");
        instructions.add("right");
        instructions.add("down");
        instructions.add("down");
        instructions.add("left");
        instructions.add("down");
        instructions.add("down");
        instructions.add("down");
        instructions.add("down");
        instructions.add("right");
        instructions.add("right");
        instructions.add("down");
        instructions.add("down");
        instructions.add("right");
        instructions.add("right");
        instructions.add("right");
        instructions.add("right");
        instructions.add("right");
        instructions.add("right");
        instructions.add("right");
        instructions.add("up");
        instructions.add("up");
        instructions.add("up");
        instructions.add("up");
        instructions.add("left");
        instructions.add("left");
        instructions.add("up");
        instructions.add("left");
        instructions.add("left");
        instructions.add("down");
        instructions.add("left");
        new Run().start();
    }

    class Run extends Thread {
        @Override
        public void run() {
            Looper.prepare();
            step = (imageView8.getRight() - imageView8.getLeft()) / 10 - 2;
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    if (i+1==instructions.size()) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                timer.cancel();
                                final AlertDialog.Builder alterDialog = new AlertDialog.Builder(DogNewLife.this);
                                alterDialog.setTitle("YaDa!");
                                alterDialog.setMessage("看啊！狗子经过训练已经可以自己解决问题了");
                                alterDialog.setPositiveButton("真是不错", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        next();
                                    }
                                });
                                alterDialog.show();
                            }
                        });
                    }
                    String a = instructions.get(i);
                    if(a=="up") {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                upstep++;
                                step = (imageView8.getRight() - imageView8.getLeft()) / 10 - 2;
                                upAnimator = ObjectAnimator.ofFloat(dog, "translationY",(dog.getTranslationY()-step));
                                upAnimator.start();
                                i++;
                            }
                        });
                    }
                    else if(a=="down") {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                downstep++;
                                step = (imageView8.getRight() - imageView8.getLeft()) / 10 - 2;
                                downAnimator = ObjectAnimator.ofFloat(dog, "translationY",(dog.getTranslationY()+step));
                                downAnimator.start();
                                i++;
                            }
                        });
                    }
                    else if(a=="left") {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                leftstep++;
                                step = (imageView8.getRight() - imageView8.getLeft()) / 10 - 2;
                                leftAnimator = ObjectAnimator.ofFloat(dog, "translationX",(dog.getTranslationX()-step));
                                leftAnimator.start();
                                i++;
                            }
                        });
                    }
                    else if(a=="right") {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                rightstep++;
                                step = (imageView8.getRight() - imageView8.getLeft()) / 10 - 2;
                                rightAnimator = ObjectAnimator.ofFloat(dog, "translationX",(dog.getTranslationX()+step));
                                step += 1;
                                rightAnimator.start();
                                i++;
                            }
                        });
                    }
                    else {
                        i++;
                    }
                }
            };
            timer.schedule(timerTask,0,500);
//            movingeffect();
            Looper.loop();
        }
    }


    public void next(View view) {
        Intent next = new Intent();
        next.setClass(this, IntroductionPage2.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    public void next() {
        Intent next = new Intent();
        next.setClass(this, IntroductionPage2.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
}
