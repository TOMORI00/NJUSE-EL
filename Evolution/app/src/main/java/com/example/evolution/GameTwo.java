package com.example.evolution;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class GameTwo extends Activity {

    //TODO:游戏二，集成电路时代

    private ImageButton buttonUp;
    private ImageButton buttonDown;
    private ImageButton buttonLeft;
    private ImageButton buttonRight;

    private ImageView dog;
    private ImageView dog2;
    private TextView door;
    private TextView goal;
    private TextView wallUp;
    private TextView wallDown;

    private Timer timerUp;
    private Timer timerDown;
    private Timer timerLeft;
    private  Timer timerRight;
    private TimerTask taskUp;
    private TimerTask taskDown;
    private TimerTask taskLeft;
    private TimerTask taskRight;
    private  Handler handler;

    private int width2;
//    private int height2;

    private  int key = 0;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_two);
        buttonUp = findViewById(R.id.goUp);
        buttonDown = findViewById(R.id.goDown);
        buttonLeft = findViewById(R.id.goLeft);
        buttonRight = findViewById(R.id.goRight);
        dog = findViewById(R.id.imageView);
        dog2 = findViewById(R.id.imageView6);
        door = findViewById(R.id.textView10);
        goal = findViewById(R.id.textView25);
        wallUp = findViewById(R.id.textView9);
        wallDown = findViewById(R.id.textView17);
        ButtonListener upListener = new ButtonListener();
        ButtonListener downListener = new ButtonListener();
        ButtonListener leftListener = new ButtonListener();
        ButtonListener rightListener = new ButtonListener();
        buttonUp.setOnTouchListener(upListener);
        buttonDown.setOnTouchListener(downListener);
        buttonLeft.setOnTouchListener(leftListener);
        buttonRight.setOnTouchListener(rightListener);
        handler = new Handler();

        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        width2 = outMetrics.widthPixels;
//        height2 = outMetrics.heightPixels;
        new overlord().start();
        new overlord2().start();

        ObjectAnimator objectAnimator  = ObjectAnimator.ofFloat(goal, "alpha",0f,1f);
        objectAnimator.setDuration(20000);
        objectAnimator.start();
        tip();
        dog.setImageResource(R.drawable.dog_1);
        dog2.setImageResource(R.drawable.dog_2);
        movingeffect();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    key = 1;
//                    Toast.makeText(this,"目前集成电路芯片都是利用逻辑电路来进行计算的，门上的锁便是之中的一种——译码器",Toast.LENGTH_SHORT).show();
                }
        }

    }
    class overlord extends Thread {
        @Override
        public void run() {
            Looper.prepare();
            Boolean flag = true;
            while(flag) {
                if((dog.getLeft() > door.getLeft())&&(dog.getRight() < door.getRight())) {
                    flag = false;
                    question();
                }
            }
            Looper.loop();
        }
    }
    class overlord2 extends Thread {
        @Override
        public void run() {
            Looper.prepare();
            Boolean flag = true;
//            Boolean flag2 = true;
            while(flag) {
                if(dog.getRight() >= width2-200) {
                    flag = false;
                    next();
                }
            }
//            while(flag2) {
//                if(dog.getRight() >= width2-600) {
//                    flag2 = false;
//                    tipp();
//                }
//            }
            Looper.loop();
        }
    }
    class ButtonListener implements View.OnTouchListener {
            public boolean onTouch(View v, MotionEvent event) {
                if(v.getId() == R.id.goUp) {
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        stopUp();
                    }
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        upStart();
                    }
                }
                if(v.getId() == R.id.goDown) {
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        stopDown();
                    }
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        downStart();
                    }
                }
                if(v.getId() == R.id.goLeft) {
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        stopLeft();
                    }
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        leftStart();
                    }
                }
                if(v.getId() == R.id.goRight) {
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        stopRight();
                    }
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        rightStart();
                    }
                }
                return false;
            }
        }

    public void upStart() {
            timerUp = new Timer();
            taskUp = new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(judgeUp()) {
                                dog.layout(dog.getLeft(), dog.getTop()-1, dog.getRight(), dog.getBottom()-1);
                                dog2.layout(dog.getLeft(), dog.getTop()-1, dog.getRight(), dog.getBottom()-1);
                            }
                        }
                    });
                }
            };
            timerUp.schedule(taskUp,0,1);
        }
    public void downStart() {
            timerDown = new Timer();
            taskDown = new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(judgeDown()) {
                                dog.layout(dog.getLeft(), dog.getTop()+1, dog.getRight(), dog.getBottom()+1);
                                dog2.layout(dog.getLeft(), dog.getTop()+1, dog.getRight(), dog.getBottom()+1);
                            }
                        }
                    });
                }
            };
            timerDown.schedule(taskDown,0,1);
        }
    public void leftStart() {
        timerLeft = new Timer();
        taskLeft = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(judgeLeft()) {
                            dog.layout(dog.getLeft()-1, dog.getTop(), dog.getRight()-1, dog.getBottom());
                            dog2.layout(dog.getLeft()-1, dog.getTop(), dog.getRight()-1, dog.getBottom());
                        }
                    }
                });
            }
        };
        timerLeft.schedule(taskLeft,0,1);
    }
    public void rightStart() {
        timerRight = new Timer();
        taskRight = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(judgeRight()) {
                            dog.layout(dog.getLeft()+1, dog.getTop(), dog.getRight()+1, dog.getBottom());
                            dog2.layout(dog.getLeft()+1, dog.getTop(), dog.getRight()+1, dog.getBottom());
                        }
                    }
                });
            }
        };
        timerRight.schedule(taskRight,0,1);
    }

    public void next(View view) {
        Intent next = new Intent();
        next.setClass(this, ChangePageTwo.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
    public void next() {
        Intent next = new Intent();
        next.setClass(this, ChangePageTwo.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
    public void next2solve() {
        Intent next = new Intent(GameTwo.this,GameTwo_solve.class);
//        next.setClass(this, GameTwo_solve.class);
        startActivityForResult(next,1);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public Boolean judgeUp() {
        InteractionBox wallUpBox = new InteractionBox(wallUp.getTop(), wallUp.getBottom(), wallUp.getLeft(), wallUp.getRight());
        InteractionBox dogBox = new InteractionBox(dog.getTop(), dog.getBottom(), dog.getLeft(), dog.getRight());
        if(dogBox.interact(wallUpBox).equals("up")) {
            return false;
        }
        return true;
    }
    public Boolean judgeDown() {
        InteractionBox wallDownBox = new InteractionBox(wallDown.getTop(), wallDown.getBottom(), wallDown.getLeft(), wallDown.getRight());
        InteractionBox dogBox = new InteractionBox(dog.getTop(), dog.getBottom(), dog.getLeft(), dog.getRight());
        if(dogBox.interact(wallDownBox).equals("down")) {
            return false;
        }
        return true;
    }
    public Boolean judgeLeft() {
        if(dog.getLeft() <= 0) {
            return false;
        }
        return true;
    }
    public Boolean judgeRight() {
        if(((dog.getLeft() > door.getLeft())&&(dog.getRight() < door.getRight()))&&(key==0)) {
            return false;
        }
        return true;
    }

    public void stopUp() {
        timerUp.cancel();
        taskUp.cancel();
    }
    public void stopDown() {
        timerDown.cancel();
        taskDown.cancel();
    }
    public void stopLeft() {
        timerLeft.cancel();
        taskLeft.cancel();
    }
    public void stopRight() {
        timerRight.cancel();
        taskRight.cancel();
    }

    public void question() {
        final AlertDialog.Builder alterDialog = new AlertDialog.Builder(GameTwo.this);
        alterDialog.setTitle("门被锁住了 T_T");
        alterDialog.setMessage("用二进制表示出 3+4 的结果来把它打开吧");
        alterDialog.setPositiveButton("好的，我来试试", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                next2solve();
            }
        });
        alterDialog.show();
    }
    public void tip() {
        final AlertDialog.Builder alterDialog = new AlertDialog.Builder(GameTwo.this);
        alterDialog.setTitle("狗子来到了集成电路的时代");
        alterDialog.setMessage("所谓集成电路，是采用一定的工艺，把一个电路中所需的晶体管、电阻、电容和电感等元件及布线连在一起，制作在小块半导体晶片或介质基片上，然后封装在一个管壳内，成为具有所需电路功能的微型结构\n   集成电路具有体积小，重量轻，引出线和焊接点少，寿命长，可靠性高，性能好等优点，同时成本低，便于大规模生产，得到了广泛的应用。");
        alterDialog.setPositiveButton("哦。。。。。", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alterDialog.show();
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

}
