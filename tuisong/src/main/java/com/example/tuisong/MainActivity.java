package com.example.tuisong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        Log.d("首先获取id",JPushInterface.getRegistrationID(this));
    }
}
