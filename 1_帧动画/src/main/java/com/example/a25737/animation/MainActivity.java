package com.example.a25737.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = (ImageView) findViewById(R.id.iv);

        iv.setBackgroundResource(R.drawable.myanim);//设置背景资源
        AnimationDrawable iv_anim = (AnimationDrawable) iv.getBackground();//获取执行动画资源
        iv_anim.start();
    }
}
