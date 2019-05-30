package com.example.evolution;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class GameOne extends AppCompatActivity {
    private ImageView TempImage;
    private ImageButton buttonUp;
    private ImageButton buttonDown;
    private ImageButton buttonLeft;
    private ImageButton buttonRight;
    private Timer timer;
    private TimerTask taskUp;
    private TimerTask taskDown;
    private TimerTask taskLeft;
    private TimerTask taskRight;
    private Handler handler;
    private ImageView dog;
    private ImageView dog2;
    private TextView door;
    private TextView wall_up1;
    private TextView wall_up2;
    private TextView wall_up3;
    private TextView wall_down1;
    private TextView wall_down2;
    private TextView wall_down3;
    private TextView target;
    private TextView wall_left1;
    private TextView wall_left2;
    private TextView wall_right1;
    private TextView wall_right2;
    private TextView target3;
    private TextView target2;
    private TextView target4;
    private int key = 0;
    private int key2 = 0;
    private int key3 = 0;
    private int key4 = 0;
    private ImageView bright;
    private int i = 0;

    private Boolean lock = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_one);
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        }
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        TempImage = findViewById(R.id.bridge);
        buttonUp = findViewById(R.id.button_up);
        buttonDown = findViewById(R.id.button_down);
        buttonLeft = findViewById(R.id.button_left);
        buttonRight = findViewById(R.id.button_right);
        dog = findViewById(R.id.dog);
        dog2 = findViewById(R.id.dog2);
        GameOne.ButtonListener upListener = new GameOne.ButtonListener();
        GameOne.ButtonListener downListener = new GameOne.ButtonListener();
        GameOne.ButtonListener leftListener = new GameOne.ButtonListener();
        GameOne.ButtonListener rightListener = new GameOne.ButtonListener();
        buttonUp.setOnTouchListener(upListener);
        buttonDown.setOnTouchListener(downListener);
        buttonLeft.setOnTouchListener(leftListener);
        buttonRight.setOnTouchListener(rightListener);
        handler = new Handler();
        door = findViewById(R.id.door);
        wall_up1 = findViewById(R.id.wall_up1);
        wall_up2 = findViewById(R.id.wall_up2);
        wall_up3 = findViewById(R.id.wall_up3);
        wall_down1 = findViewById(R.id.wall_down1);
        wall_down2 = findViewById(R.id.wall_down2);
        wall_down3 = findViewById(R.id.wall_down3);
        target = findViewById(R.id.target);
        target2 = findViewById(R.id.target2);
        target3 = findViewById(R.id.target3);
        target4 = findViewById(R.id.target4);
        wall_left1 = findViewById(R.id.wall_left1);
        wall_left2 = findViewById(R.id.wall_left2);
        wall_right1 = findViewById(R.id.wall_right1);
        wall_right2 = findViewById(R.id.wall_right2);
        bright = findViewById(R.id.bright);
        final android.app.AlertDialog.Builder alterDialog = new android.app.AlertDialog.Builder(GameOne.this);
        alterDialog.setTitle("狗子开始了冒险");
        alterDialog.setMessage("    最早的狗子使用晶体管做运算元件，晶体管是一种可变电流开关，能够基于输入电压控制输出电流，具有检波、整流、放大、开关、稳压、信号调制等多种功能。");
        alterDialog.setPositiveButton("了解！", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });
        alterDialog.show();
    }

    class ButtonListener implements View.OnTouchListener {
        public boolean onTouch(View v, MotionEvent event) {
            if (v.getId() == R.id.button_up) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    bright.setVisibility(View.VISIBLE);
                    get();
                    stop();
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    movingeffect();
                    bright.setVisibility(View.INVISIBLE);
                    upStart();
                }
            }
            if (v.getId() == R.id.button_down) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    bright.setVisibility(View.VISIBLE);
                    get();
                    stop();
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    movingeffect();
                    bright.setVisibility(View.INVISIBLE);
                    downStart();
                }
            }
            if (v.getId() == R.id.button_left) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    bright.setVisibility(View.VISIBLE);
                    get();
                    stop();
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    movingeffect();
                    bright.setVisibility(View.INVISIBLE);
                    leftStart();
                }
            }
            if (v.getId() == R.id.button_right) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    bright.setVisibility(View.VISIBLE);
                    get();
                    stop();
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    movingeffect();
                    bright.setVisibility(View.INVISIBLE);
                    rightStart();
                }
            }
            return false;
        }
    }


    //get判定方法开始
    public void get() {
        if (getTarget_1()) {
            introduce();
        }
        if (getTarget_2()) {
            if (lock) {
                Toast.makeText(this, "Author.kill(Newton) //所以狗子它飞！过去了", Toast.LENGTH_LONG).show();
            }
            TempImage.setImageResource(R.drawable.bridge_broken);
            bridge();
        }
        if (getDoor()) {
            nextgame();
        }
        if (getImage_1()) {

        }
        if (getLava()) {
            lava();
        }
        if (getCity()) {
            city();
        }
    }

    public Boolean getTarget_1() {
        ImageView dog = findViewById(R.id.dog);
        TextView target = findViewById(R.id.target);
        if ((dog.getLeft() >= target.getLeft()) && (dog.getRight() <= target.getRight()) && (dog.getTop() >= target.getTop()) && (dog.getBottom() <= target.getBottom())) {
            return true;
        }
        return false;
    }

    public Boolean getTarget_2() {
        ImageView dog = findViewById(R.id.dog);
        TextView target2 = findViewById(R.id.target2);
        if ((dog.getLeft() >= target2.getLeft()) && (dog.getRight() <= target2.getRight()) && (dog.getTop() >= target2.getTop()) && (dog.getBottom() <= target2.getBottom())) {
            return true;
        }
        return false;
    }


    public Boolean getImage_1() {
        ImageView bridge = findViewById(R.id.bridge);
        ImageView dog = findViewById(R.id.dog);
        if ((dog.getLeft() >= bridge.getLeft()) && (dog.getRight() <= bridge.getRight()) && (dog.getTop() >= bridge.getTop()) && (dog.getBottom() <= bridge.getBottom())) {
            return true;
        }
        return false;
    }

    public Boolean getLava() {
        ImageView dog = findViewById(R.id.dog);
        TextView lava = findViewById(R.id.target3);
        if ((dog.getLeft() >= lava.getLeft()) && (dog.getRight() <= lava.getRight()) && (dog.getTop() >= lava.getTop()) && (dog.getBottom() <= lava.getBottom())) {
            return true;
        }
        return false;

    }

    public Boolean getDoor() {
        ImageView dog = findViewById(R.id.dog);
        TextView lava = findViewById(R.id.door);
        if ((dog.getLeft() >= lava.getLeft()) && (dog.getRight() <= lava.getRight()) && (dog.getTop() >= lava.getTop()) && (dog.getBottom() <= lava.getBottom())) {
            return true;
        }
        return false;
    }

    public Boolean getCity() {
        ImageView dog = findViewById(R.id.dog);
        TextView city = findViewById(R.id.target4);
        if ((dog.getLeft() >= city.getLeft()) && (dog.getRight() <= city.getRight()) && (dog.getTop() >= city.getTop()) && (dog.getBottom() <= city.getBottom())) {
            return true;
        }
        return false;
    }


    //get判定方法结束

    //告示牌开始

    //第一个介绍
    public void introduce() {
        if(key3==0) {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(GameOne.this);
            dialog.setTitle("狗子");
            dialog.setMessage("它叫RCA501");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            dialog.show();
        }
        key3=1;
    }

    //桥介绍
    public void bridge() {
        if(key2==0) {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(GameOne.this);
            dialog.setTitle("这是一座桥");
            dialog.setMessage("搭载晶体管计算机的狗子体重达30吨，而本桥的负重为29吨，现在知道晶体管计算机有多重了吧");
            dialog.setCancelable(false);
            dialog.setPositiveButton("狗子出师不利，不幸遇难，不过我们给它上了个buff，再走一遍试试吧", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            dialog.show();
            lock = true;
        }
        key2=1;
    }

    //岩浆介绍
    public void lava() {
        if(key==0) {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(GameOne.this);
            dialog.setTitle("警告");
            dialog.setMessage("狗子过热了，谁叫晶体管发热太多，请赶快前往下一区域（一直向前走哦）");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            dialog.show();
        }
        key=1;
    }

    //城市介绍
    public void city() {
        if(key4==0) {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(GameOne.this);
            dialog.setTitle("这是城市");
            dialog.setMessage("狗子的能耗达到150KW，实在大到不行，当它行动时，整座城市的灯光都为之暗淡");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            dialog.show();
        }
        key4=1;
    }
    //告示牌结束

    //切换下一幕
    public void nextgame(){
        Intent next = new Intent();
        next.setClass(this, ChangePageOne.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    public void upStart() {
        timer = new Timer();
        taskUp = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(judgeUp(dog)) {
                            dog.layout(dog.getLeft()-1, dog.getTop()-7, dog.getRight()-1, dog.getBottom()-7);
                            dog2.layout(dog2.getLeft()-1, dog2.getTop()-7, dog2.getRight()-1, dog2.getBottom()-7);
                        }
                    }
                });
            }
        };
        timer.schedule(taskUp,0,14);
    }

    public void downStart() {
        timer = new Timer();
        taskDown = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(judgeDown(dog)) {
                            dog.layout(dog.getLeft()-1, dog.getTop()+6, dog.getRight()-1, dog.getBottom()+6);
                            dog2.layout(dog2.getLeft()-1, dog2.getTop()+6, dog2.getRight()-1, dog2.getBottom()+6);
                        }
                    }
                });
            }
        };
        timer.schedule(taskDown,0,6);
    }

    public void leftStart() {
        timer = new Timer();
        taskLeft = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(judgeLeft(dog)) {
                            dog.layout(dog.getLeft()-1, dog.getTop(), dog.getRight()-1, dog.getBottom());
                            dog2.layout(dog2.getLeft()-1, dog2.getTop(), dog2.getRight()-1, dog2.getBottom());
                        }
                    }
                });
            }
        };
        timer.schedule(taskLeft,0,1);
    }

    public void rightStart() {
        timer = new Timer();
        taskRight = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(judgeRight(dog)) {
                            dog.layout(dog.getLeft()+1, dog.getTop(), dog.getRight()+1, dog.getBottom());
                            dog2.layout(dog2.getLeft()+1, dog2.getTop(), dog2.getRight()+1, dog2.getBottom());
                        }
                    }
                });
            }
        };
        timer.schedule(taskRight,0,1);
    }

    public Boolean judgeUp(ImageView dog) {
        InteractionBox wallUpBox1 = new InteractionBox(wall_up1.getTop(), wall_up1.getBottom(), wall_up1.getLeft(),wall_up1.getRight());
        InteractionBox wallUpBox2 = new InteractionBox(wall_up2.getTop(), wall_up2.getBottom(), wall_up2.getLeft(),wall_up2.getRight());
        InteractionBox wallUpBox3 = new InteractionBox(wall_up3.getTop(), wall_up3.getBottom(), wall_up3.getLeft(),wall_up3.getRight());
        InteractionBox dogBox = new InteractionBox(dog.getTop(), dog.getBottom(), dog.getLeft(), dog.getRight());
        if(dogBox.interact(wallUpBox1).equals("up") &&dog.getLeft()<wall_up1.getRight()){
            return false;
        }
        else if(dogBox.interact(wallUpBox2).equals("up") &&dog.getLeft()<wall_up2.getRight()){
            return false;
        }
        else if(dogBox.interact(wallUpBox3).equals("up") &&dog.getLeft()<wall_up3.getRight()){
            return false;
        }
        return true;
    }

    public Boolean judgeDown(ImageView dog) {
        InteractionBox wallDownBox1 = new InteractionBox(wall_down1.getTop(), wall_down1.getBottom(), wall_down1.getLeft(),wall_down1.getRight());
        InteractionBox wallDownBox2 = new InteractionBox(wall_down2.getTop(), wall_down2.getBottom(), wall_down2.getLeft(),wall_down2.getRight());
        InteractionBox wallDownBox3 = new InteractionBox(wall_down3.getTop(), wall_down3.getBottom(), wall_down3.getLeft(),wall_down3.getRight());
        InteractionBox dogBox = new InteractionBox(dog.getTop(), dog.getBottom(), dog.getLeft(), dog.getRight());
        if(dogBox.interact(wallDownBox1).equals("down") &&dog.getLeft()<wall_down1.getRight()){
            return false;
        }
        else if(dogBox.interact(wallDownBox2).equals("down") &&dog.getLeft()<wall_down2.getRight()){
            return false;
        }
        else if(dogBox.interact(wallDownBox3).equals("down") &&dog.getLeft()<wall_down3.getRight()){
            return false;
        }
        return true;
    }

    public Boolean judgeLeft(ImageView dog) {
        if(dog.getLeft()<0) {
            return false;
        }
        if( dog.getLeft() < wall_left1.getRight() && dog.getTop()<=wall_left1.getBottom()&& dog.getBottom()>=wall_left1.getTop()&dog.getTop()<=wall_left1.getBottom()){
            return false;
        }
        if( dog.getLeft() < wall_left2.getRight() && dog.getTop()<=wall_left2.getBottom()&& dog.getBottom()>=wall_left2.getTop()&&dog.getTop()<=wall_left2.getBottom()){
            return false;
        }
        return true;
    }

    public Boolean judgeRight(ImageView dog) {
        if( dog.getLeft() > target.getLeft()  &&  dog.getRight() < target.getRight()&&key3==0){
            return false;
        }
        if( dog.getLeft() > wall_right1.getLeft()  &&  dog.getRight() < wall_right1.getRight() && dog.getBottom()>=wall_right1.getTop()&&dog.getTop()<=wall_right1.getBottom()){
            return false;
        }
        if( dog.getLeft() > target3.getLeft()  &&  dog.getRight() < target3.getRight()&&key==0){
            return false;
        }
        if( dog.getLeft() > door.getLeft()  &&  dog.getRight() < door.getRight()){
            return false;
        }
        if( dog.getLeft() > target2.getLeft()  &&  dog.getRight() < target2.getRight()&&key2==0){
            return false;
        }
        if( dog.getLeft() > wall_right2.getLeft()  &&  dog.getRight() < wall_right2.getRight() && dog.getTop()<=wall_right2.getBottom()&&dog.getTop()<=wall_right2.getBottom()){
            return false;
        }
        if( dog.getLeft() > target4.getLeft()  &&  dog.getRight() < target4.getRight()&&key4==0){
            return false;
        }

        return true;
    }

    private void movingeffect() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(i%2==0) {
                            dog.setVisibility(View.INVISIBLE);
                            dog2.setVisibility(View.VISIBLE);
                        }else{
                            dog.setVisibility(View.VISIBLE);
                            dog2.setVisibility(View.INVISIBLE);
                        }
                        i++;
                    }
                });
            }
        };
        timer.schedule(timerTask,0,500);
    }

    public void stop() {
        timer.cancel();
//        taskUp.cancel();
//        taskDown.cancel();
//        taskLeft.cancel();
//        taskRight.cancel();
    }
}