package com.example.evolution;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class IntroductionPage2 extends Activity {

    private TextView textView;
    private Boolean lock = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_introduction_page2);
        textView = findViewById(R.id.textView24);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(textView,"alpha",0f, 1f);
        objectAnimator4.setDuration(5000);
        textView.setText("Touch the screen to continue");
        objectAnimator4.start();
        lock = true;
    }

    public void next(View view) {
        Intent next = new Intent();
        next.setClass(this, ThanksScreen.class);
        startActivity(next);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
    public void clicked2(View v) {
        if(lock) {
            Intent next = new Intent();
            next.setClass(this, ThanksScreen.class);
            startActivity(next);
            finish();
        }
    }
}
