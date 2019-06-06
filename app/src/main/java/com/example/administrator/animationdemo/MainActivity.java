package com.example.administrator.animationdemo;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView,imageView2;
    Button btnTranslation, btnAlpha, btnRotate, btnScale,btn_frame,btn_stop,btn_property,btn_vg;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        btnTranslation = findViewById(R.id.btn_translation);
        imageView2=findViewById(R.id.imageView2);
        btn_frame=findViewById(R.id.btn_frame);
        btnAlpha = findViewById(R.id.btn_alpha);
        btnRotate = findViewById(R.id.btn_rotate);
        btnScale = findViewById(R.id.btn_scale);
        btn_stop=findViewById(R.id.btn_stop);
        btn_property=findViewById(R.id.btn_property);
        btn_vg=findViewById(R.id.btn_vg);
        btn_vg.setOnClickListener(this);
        btn_property.setOnClickListener(this);
        btnTranslation.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
        btn_frame.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        imageView2.setImageResource(R.drawable.my_frame);
        animationDrawable= (AnimationDrawable) imageView2.getDrawable();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha:
                alphaAnimation();
                break;
            case R.id.btn_rotate:
                rotateAnimation();
                break;
            case R.id.btn_scale:
                scaleAnimation();
                break;
            case R.id.btn_translation:
                translationAnimation();
                break;
            case R.id.btn_frame:
                animationDrawable.start();
                break;
            case R.id.btn_stop:
                animationDrawable.stop();
                break;
            case R.id.btn_property:
                Intent intent=new Intent(MainActivity.this,PropertyActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_vg:
                Intent intent1=new Intent(MainActivity.this,ListAnimatorActivity.class);
                startActivity(intent1);
                break;
        }
    }

    private void alphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(3000);
        imageView.startAnimation(alphaAnimation);
    }

    private void rotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 90,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(3000);
        imageView.startAnimation(rotateAnimation);
    }

    private void scaleAnimation() {
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.my_scale);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 1.5f, 1, 1, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_PARENT, 0.5f);
        animation.setDuration(3000);
//        animation.setRepeatCount(ValueAnimator.INFINITE);
//        animation.setRepeatMode(Animation.REVERSE);
//        animation.setStartOffset(5000);
//        animation.setFillAfter(true);
//        animation.setFillEnabled(true);
        imageView.startAnimation(animation);
    }

    private void translationAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, 100);
        translateAnimation.setDuration(3000);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillBefore(false);

        imageView.startAnimation(translateAnimation);
    }
}
