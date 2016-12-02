package com.example.dell.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by DELL on 2016/12/1.
 */

public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("MyService","startDownload executed");
        }

        public int getProgress(){
            Log.d("MyService","getProgress executed");
            return 0;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new Notification.Builder(this).
                setSmallIcon(R.mipmap.ic_launcher).
                setContentTitle("This is title").
                setContentText("This is content").
                setWhen(System.currentTimeMillis()).
                setTicker("Notification comes").
                setContentIntent(pi).build();
        startForeground(1,notification);
        Log.d("MyService","onCreate executed");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("MyService","onDestroy executed");
        super.onDestroy();
    }
}
