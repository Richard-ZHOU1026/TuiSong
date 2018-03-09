package com.example.tuisong;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/3/7.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override

    //onReceive的时候传进来的context是ReceiverRestrictedContext，然而ReceiverRestrictedContext的代码很简单，里面没有startActivity方法
    //而ReceiverRestrictedContext是继承自ContextWrapper

    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        //初始化后通过Jpush的getRegistrationID方法得到RegistrationID
        String regid = JPushInterface.getRegistrationID(context);

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            Log.d("我去列", "[MyReceiver] 接收Registration Id ++++: " + regId);

            //send the Registration Id to your server...
        }
        else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            //不会显示在通知栏，需要自己搞
            Log.e(TAG, "[MyReceiver] 接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            processCustomMessage(context, bundle);

        }else if(JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())){
            Log.d("我点了", "[MyReceiver] 用户点击打开了通知");

            Intent intentxx = new Intent(context,Click.class);
            intentxx.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentxx);
            return;
        }

//        //通过广播启动Activity需要加FLAG_ACTIVITY_NEW_TASK
//        Intent intent01 = new Intent(context,MainActivity.class);
//        //创建一个新的任务栈
//        Log.e("xxxx","asdasdas");
//
//        Log.e("xxxx","+++++++++++++++++");
//       // intent01.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        intent01.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent01);
    }

    private void processCustomMessage(Context context, Bundle bundle) {
    }

}
