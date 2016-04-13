package com.example.michael.mybmobapp.app;

import android.support.v7.app.AppCompatActivity;

import com.example.michael.mybmobapp.utils.ToastUtils;

/**
 * Created by Michael on 16/4/13.
 */
public class BaseActivity extends AppCompatActivity {

    protected void toast(String string) {
        ToastUtils.showShortToast(this,string);
    }

}
