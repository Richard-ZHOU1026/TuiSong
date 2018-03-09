package com.example.tuisong;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2018/3/7.
 */

public class CustomMessage extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custo);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
