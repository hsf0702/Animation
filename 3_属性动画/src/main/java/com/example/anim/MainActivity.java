package com.example.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv =  (ImageView) findViewById(R.id.iv);
    }
    public void click(View view) {
        int id = view.getId();
        switch (id) {//Alpha 透明
            case R.id.a:
                ObjectAnimator oa1 = ObjectAnimator.ofFloat(iv, "alpha", 1.0f, 0.7f, 0.5f, 0.3f, 0.0f,0.2f,0.4f,0.6f,0.8f,1.0f);
                oa1.setDuration(2000);
                oa1.start();
                break;
            case R.id.b://rotate旋转 rotationX
                ObjectAnimator oa2 = ObjectAnimator.ofFloat(iv, "rotationX",0,90,180,360);
                oa2.setDuration(2000);
                oa2.start();
                break;
            case R.id.c://缩放scaleX
                ObjectAnimator oa3 = ObjectAnimator.ofFloat(iv, "scaleX",1.0f,2.0f,3.0f,2.0f,1.0f);
                oa3.setDuration(2000);
                oa3.start();
                break;
            case R.id.d://位移translationX
                ObjectAnimator oa4 = ObjectAnimator.ofFloat(iv, "translationX",0,10,40,80,40,10,0);
                oa4.setDuration(2000);
                oa4.start();
                break;
            case R.id.e:
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator oa11 = ObjectAnimator.ofFloat(iv, "alpha", 1.0f, 0.7f, 0.5f, 0.3f, 0.0f,0.2f,0.4f,0.6f,0.8f,1.0f);
                ObjectAnimator oa12 = ObjectAnimator.ofFloat(iv, "rotationX",0,90,180,360);
                ObjectAnimator oa13 = ObjectAnimator.ofFloat(iv, "scaleX",1.0f,2.0f,3.0f,2.0f,1.0f);
                ObjectAnimator oa14 = ObjectAnimator.ofFloat(iv, "translationX",0,10,40,80,40,10,0);
                set.playTogether(oa11,oa12,oa13,oa14);
                set.setTarget(iv);
                set.setDuration(2000);
                set.start();
                break;

        }
    }
}
