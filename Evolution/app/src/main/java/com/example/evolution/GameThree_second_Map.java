package com.example.evolution;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameThree_second_Map extends Activity {

    //TODO:游戏三

    private Map map;
    private ObjectAnimator upAnimator;
    private ObjectAnimator downAnimator;
    private ObjectAnimator leftAnimator;
    private ObjectAnimator rightAnimator;

    private ImageView dog;
    private ImageView step1;
    private ImageView step2;
    private ImageView step3;
    private ImageView step4;
    private ImageView step5;
    private ImageView step6;
    private ImageView step7;
    private ImageView step8;
    private ImageView step9;
    private ImageView step10;
    private ImageView step11;
    private ImageView step12;
    private ImageView step13;
    private ImageView step14;
    private ImageView imageView22;
    private ImageButton upbutton;
    private ImageButton downbutton;
    private ImageButton leftbutton;
    private ImageButton rightbutton;
    private ImageButton clearbutton;
    private ImageButton confirmbutton;

    private Handler handler;
    private Timer timer;

    private ArrayList<String> instructions;

    private Boolean lock12;
    private int i = 0;

    private  int step;

    private int upstep = 0;
    private int downstep = 0;
    private int leftstep = 0;
    private int rightstep = 0;

    private int Xstart;
    private int Ystart;

    private Boolean bug = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_three_second_map);

        upbutton = findViewById(R.id.upButton);
        downbutton = findViewById(R.id.downButton);
        leftbutton = findViewById(R.id.leftButton);
        rightbutton = findViewById(R.id.rightButton);
        clearbutton = findViewById(R.id.clearButton);
        confirmbutton = findViewById(R.id.confirmButton);
        dog = findViewById(R.id.dogImage);
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step3 = findViewById(R.id.step3);
        step4 = findViewById(R.id.step4);
        step5 = findViewById(R.id.step5);
        step6 = findViewById(R.id.step6);
        step7 = findViewById(R.id.step7);
        step8 = findViewById(R.id.step8);
        step9 = findViewById(R.id.step9);
        step10 = findViewById(R.id.step10);
        step11 = findViewById(R.id.step11);
        step12 = findViewById(R.id.step12);
        step13 = findViewById(R.id.step13);
        step14 = findViewById(R.id.step14);
        Xstart = dog.getLeft();
        Ystart = dog.getTop();

        imageView22 = findViewById(R.id.imageView22);

        int[][] mapData1 = {{0,1,0,1,0},{0,1,0,0,0},{0,1,0,1,0},{0,0,1,0,0},{1,0,0,0,1}};
        map = new Map(mapData1);
        handler = new Handler();
        instructions = new ArrayList<String>();
        lock12 = true;
        final AlertDialog.Builder alterDialog = new AlertDialog.Builder(GameThree_second_Map.this);
        alterDialog.setTitle("训练程序02");
        alterDialog.setMessage("这种芯片的计算能力是训练出来的哦，编辑一段指令让狗子到达中心的终点吧");
        alterDialog.setPositiveButton("我再试试", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alterDialog.show();
    }

    public void up(View view) {
        if(instructions.size()==14) {
            return;
        }
        instructions.add("up");
        check();
    }
    public void down(View view) {
        if(instructions.size()==14) {
            return;
        }
        instructions.add("down");
        check();
    }
    public void left(View view) {
        if(instructions.size()==14) {
            return;
        }
        instructions.add("left");
        check();
    }
    public void right(View view) {
        if(instructions.size()==14) {
            return;
        }
        instructions.add("right");
        check();
    }

    public void clear(View view) {
//        instructions.clear();
//        lock12 = true;
//        step1.setImageResource(R.mipmap.ic_launcher);
//        step2.setImageResource(R.mipmap.ic_launcher);
//        step3.setImageResource(R.mipmap.ic_launcher);
//        step4.setImageResource(R.mipmap.ic_launcher);
//        step5.setImageResource(R.mipmap.ic_launcher);
//        step6.setImageResource(R.mipmap.ic_launcher);
//        step7.setImageResource(R.mipmap.ic_launcher);
//        step8.setImageResource(R.mipmap.ic_launcher);
//        step9.setImageResource(R.mipmap.ic_launcher);
//        step10.setImageResource(R.mipmap.ic_launcher);
//        step11.setImageResource(R.mipmap.ic_launcher);
//        step12.setImageResource(R.mipmap.ic_launcher);
//        upstep = 0;
//        downstep = 0;
//        leftstep = 0;
//        rightstep = 0;
//        i = 0;
//        ObjectAnimator res1 = ObjectAnimator.ofFloat(dog,"translationX",-(dog.getTranslationX()-Xstart));
//        ObjectAnimator res2 = ObjectAnimator.ofFloat(dog,"translationY",-(dog.getTranslationY()-Ystart));
//        res1.start();
//        res2.start();
//        dog.setLeft(Xstart);
//        dog.setTop(Ystart);
        Intent next = new Intent();
        next.setClass(this, GameThree_second_Map.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    public void clear() {
        Intent next = new Intent();
        next.setClass(this, GameThree_second_Map.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
    public void check() {
        bug = false;
        while (lock12){
            if(instructions.size()==0) { break; }

            if(instructions.get(0).equals("up")) {
                step1.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(0).equals("down")) {
                step1.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(0).equals("left")) {
                step1.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(0).equals("right")) {
                step1.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==1) { break; }

            if(instructions.get(1).equals("up")) {
                step2.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(1).equals("down")) {
                step2.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(1).equals("left")) {
                step2.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(1).equals("right")) {
                step2.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==2) { break; }

            if(instructions.get(2).equals("up")) {
                step3.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(2).equals("down")) {
                step3.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(2).equals("left")) {
                step3.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(2).equals("right")) {
                step3.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==3) { break; }

            if(instructions.get(3).equals("up")) {
                step4.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(3).equals("down")) {
                step4.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(3).equals("left")) {
                step4.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(3).equals("right")) {
                step4.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==4) { break; }

            if(instructions.get(4).equals("up")) {
                step5.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(4).equals("down")) {
                step5.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(4).equals("left")) {
                step5.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(4).equals("right")) {
                step5.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==5) { break; }

            if(instructions.get(5).equals("up")) {
                step6.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(5).equals("down")) {
                step6.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(5).equals("left")) {
                step6.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(5).equals("right")) {
                step6.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==6) { break; }

            if(instructions.get(6).equals("up")) {
                step7.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(6).equals("down")) {
                step7.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(6).equals("left")) {
                step7.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(6).equals("right")) {
                step7.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==7) { break; }

            if(instructions.get(7).equals("up")) {
                step8.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(7).equals("down")) {
                step8.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(7).equals("left")) {
                step8.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(7).equals("right")) {
                step8.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==8) { break; }

            if(instructions.get(8).equals("up")) {
                step9.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(8).equals("down")) {
                step9.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(8).equals("left")) {
                step9.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(8).equals("right")) {
                step9.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==9) { break; }

            if(instructions.get(9).equals("up")) {
                step10.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(9).equals("down")) {
                step10.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(9).equals("left")) {
                step10.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(9).equals("right")) {
                step10.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==10) { break; }

            if(instructions.get(10).equals("up")) {
                step11.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(10).equals("down")) {
                step11.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(10).equals("left")) {
                step11.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(10).equals("right")) {
                step11.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==11) { break; }

            if(instructions.get(11).equals("up")) {
                step12.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(11).equals("down")) {
                step12.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(11).equals("left")) {
                step12.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(11).equals("right")) {
                step12.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==12) { break; }

            if(instructions.get(12).equals("up")) {
                step13.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(12).equals("down")) {
                step13.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(12).equals("left")) {
                step13.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(12).equals("right")) {
                step13.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==13) { break; }

            if(instructions.get(13).equals("up")) {
                step14.setImageResource(R.drawable.arrow_up);
            }
            else if(instructions.get(13).equals("down")) {
                step14.setImageResource(R.drawable.arrow_down);
            }
            else if(instructions.get(13).equals("left")) {
                step14.setImageResource(R.drawable.arrow_left);
            }
            else if(instructions.get(13).equals("right")) {
                step14.setImageResource(R.drawable.arrrow_right);
            }

            if(instructions.size()==14) {
                lock12 = false;
                break;
            }
        }
    }


    class Run extends Thread {
        @Override
        public void run() {
            Looper.prepare();
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    if (i+1==instructions.size()) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                timer.cancel();
                                if(((map.dogY==2)&&(map.dogX==2))||((map.dogY==1)&&(map.dogX==2))) {
                                    final AlertDialog.Builder alterDialog = new AlertDialog.Builder(GameThree_second_Map.this);
                                    alterDialog.setTitle("YaDa!");
                                    alterDialog.setMessage("狗子的第二次训练也成功了！");
                                    alterDialog.setPositiveButton("Nice", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            next();
                                        }
                                    });
                                    alterDialog.show();
                                }
                                else  {
                                    final AlertDialog.Builder alterDialog = new AlertDialog.Builder(GameThree_second_Map.this);
                                    alterDialog.setTitle("啊嘞!");
                                    alterDialog.setMessage("狗子的第二次训练失败了！哪儿出了问题，再试一次吧！");
                                    alterDialog.setPositiveButton("好吧", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            clear();
                                        }
                                    });
                                    alterDialog.show();
                                }
                            }
                        });
                    }
                    String a = map.move(instructions.get(i));
                    if(a=="up") {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                upstep++;
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

    public void confirm(View view) {
        if(bug) {
            return;
        }
        step = (imageView22.getRight() - imageView22.getLeft()) / 5;
        new Run().start();
        bug = true;
    }

    public void next(View view) {
        Intent next = new Intent();
        next.setClass(this, DogNewLife.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
    public void next() {
        Intent next = new Intent();
        next.setClass(this, DogNewLife.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
//    private void movingeffect() {
//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        if(i%2==0) {
//                            dog.setImageResource(R.drawable.dog_2);
//                        }else{
//                            dog.setImageResource(R.drawable.dog_1);
//                        }
//                        i++;
//                    }
//                });
//            }
//        };
//        timer.schedule(timerTask,0,500);
//    }
}
