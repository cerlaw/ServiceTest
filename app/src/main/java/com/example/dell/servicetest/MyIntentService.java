package com.example.dell.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by DELL on 2016/12/2.
 */

public class MyIntentService extends IntentService {

    public MyIntentService(){
        super("MyIntentService");//调用父类的有参构造函数
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("MyIntentService","Thread id is " + Thread.currentThread().getId()
                );
    }

    @Override
    public void onDestroy() {
        Log.d("MyIntentService","onDestroy executed");
        super.onDestroy();
    }
}
