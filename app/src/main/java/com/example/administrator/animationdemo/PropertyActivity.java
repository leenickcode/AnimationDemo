package com.example.administrator.animationdemo;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PropertyActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView3;
    Button btnTranslation,btnBg,btnSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        imageView3=findViewById(R.id.imageView3);
        btnBg=findViewById(R.id.btn_bg);
        btnSet=findViewById(R.id.btn_set);
        btnTranslation=findViewById(R.id.btn_translation);

        btnBg.setOnClickListener(this);
        btnSet.setOnClickListener(this);
        btnTranslation.setOnClickListener(this);
    }

    @SuppressLint("ObjectAnimatorBinding")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bg:
                ValueAnimator valueAnimator=ObjectAnimator.ofInt(v,"backgroundColor",0xFFFF8080,0xFF8080FF);
                valueAnimator.setDuration(3000);
                valueAnimator.setEvaluator(new ArgbEvaluator());
                valueAnimator.setRepeatCount(ValueAnimator.INFINITE);//无限循环
                valueAnimator.setRepeatMode(ValueAnimator.REVERSE);//循环顺序  A-B-C  C-B-A
                valueAnimator.start();
                break;
            case R.id.btn_set:
                AnimatorSet set=new AnimatorSet();
                set.playTogether(
                        ObjectAnimator.ofFloat(imageView3,"rotationX",0,360),//已水平轴旋转360
                        ObjectAnimator.ofFloat(imageView3,"rotationY",0,360),//以垂直轴旋转360
                        ObjectAnimator.ofFloat(imageView3,"rotation",0,90),//以Z轴旋转90度
                        ObjectAnimator.ofFloat(imageView3,"translationX",0,100),
                        ObjectAnimator.ofFloat(imageView3,"translationY",0,100),
                        ObjectAnimator.ofFloat(imageView3,"alpha",1,0.25f,1)
                );
                set.setDuration(3000).start();
                break;
            case R.id.btn_translation:
                ObjectAnimator.ofFloat(imageView3,"translationY",imageView3.getHeight()).start();
                break;
            case R.id.btn_property:

                break;
        }
    }
}
