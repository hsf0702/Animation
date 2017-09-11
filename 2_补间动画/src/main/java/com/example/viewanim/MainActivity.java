package com.example.viewanim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv =  (ImageView) findViewById(R.id.iv);
    }
    public void click(View view){
        int id = view.getId();
        switch (id){//Alpha 透明
            case R.id.a:
                AlphaAnimation alpha = new AlphaAnimation(1.0f,0.0f);//参数1：1.0完全不透明 参数2：0.0 完全透明
                alpha.setDuration(2000);//动画执行的时长
                alpha.setRepeatCount(3);
                alpha.setRepeatMode(Animation.REVERSE);//不透明--》透明，透明--》不透明
                iv.startAnimation(alpha);
                break;
            case R.id.b://rotate旋转
                RotateAnimation rotate = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);//默认基于图片左上角   多个参数改变旋转位置
                rotate.setDuration(2000);//动画执行的时长
                rotate.setRepeatCount(3);
                rotate.setRepeatMode(Animation.REVERSE);//此处为原路反转
                iv.startAnimation(rotate);
                break;
            case R.id.c://scale缩放
                ScaleAnimation scale = new ScaleAnimation(1.0f,2.0f,1.0f,2.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);//参数1：1.0默认值 参数2：2.0为2倍
                scale.setDuration(2000);//动画执行的时长
                scale.setRepeatCount(3);
                scale.setRepeatMode(Animation.REVERSE);//此处为原路反转
                iv.startAnimation(scale);
                break;
            case R.id.d://translate位移
                TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,0.0f,
                        Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,0.2f);
                translate.setDuration(2000);//动画执行的时长
                translate.setFillAfter(true);
                translate.setRepeatCount(2);
                translate.setRepeatMode(Animation.REVERSE);//此处为原路反转
                iv.startAnimation(translate);
                break;
            case R.id.e://一起执行
                AnimationSet animationSet = new AnimationSet(true);

                //1透明
                AlphaAnimation aa = new AlphaAnimation(1.0f,0.0f);//参数1：1.0完全不透明 参数2：0.0 完全透明
                aa.setDuration(2000);//动画执行的时长
                aa.setRepeatCount(3);
                aa.setRepeatMode(Animation.REVERSE);//不透明--》透明，透明--》不透明

                //2旋转
                RotateAnimation ra = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);//默认基于图片左上角
                ra.setDuration(2000);//动画执行的时长
                ra.setRepeatCount(3);
                ra.setRepeatMode(Animation.REVERSE);//此处为原路反转

                //3缩放
                ScaleAnimation sa = new ScaleAnimation(1.0f,2.0f,1.0f,2.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                sa.setDuration(2000);//动画执行的时长
                sa.setRepeatCount(3);
                sa.setRepeatMode(Animation.REVERSE);//此处为原路反转

                //4位移----------这里实际上只是产生了动画效果，不会真实改变坐标，类似：下拉刷新，
                TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,0.0f,
                        Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,0.2f);
                ta.setDuration(2000);//动画执行的时长
                ta.setFillAfter(true);
                ta.setRepeatCount(2);
                ta.setRepeatMode(Animation.REVERSE);//此处为原路反转

                //5.添加到集合
                animationSet.addAnimation(aa);
                animationSet.addAnimation(ra);
                animationSet.addAnimation(sa);
                animationSet.addAnimation(ta);

                //执行
                iv.startAnimation(animationSet);
        }
    }
}
