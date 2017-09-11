package com.example.notifition;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View v){
        switch (v.getId()){
            case R.id.bt1:
                nm =  (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Intent intent = new Intent();//设置点击通知后的意图
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+110));

                PendingIntent pi = PendingIntent.getActivities(this, 0, new Intent[]{intent}, PendingIntent.FLAG_ONE_SHOT);
                Notification noti  = new Notification.Builder(this)
                        .setContentTitle("通知")
                        .setContentText("欠费通知")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pi)//点击通知
                        .build();
                //弹出通知
                nm.notify(10,noti);
                break;
            case R.id.bt2://取消显示通知
                nm.cancel(10);
                break;
        }
    }
}
