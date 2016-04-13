package com.example.michael.mybmobapp.app;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by Michael on 16/4/13.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "14fc2142c3fa7d48d597f565a3540aaf");

    }
}
