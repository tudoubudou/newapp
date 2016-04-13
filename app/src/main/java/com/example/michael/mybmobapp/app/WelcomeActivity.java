package com.example.michael.mybmobapp.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.michael.mybmobapp.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Michael on 16/4/13.
 */
public class WelcomeActivity extends BaseActivity {
    TextView name;
    TextView pwd;
    TextView submit;
    TextView register;
    TextView ignore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        name = (TextView)findViewById(R.id.name);
        pwd = (TextView)findViewById(R.id.pwd);
        submit = (TextView)findViewById(R.id.submit);
        register = (TextView)findViewById(R.id.register);
        ignore = (TextView)findViewById(R.id.ignore);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(name.getText().toString(), pwd.getText().toString());
            }
        });
        ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void login (String name, String pwd) {
        BmobUser bu2 = new BmobUser();
        bu2.setUsername(name);
        bu2.setPassword(pwd);
        bu2.login(this, new SaveListener() {
            @Override
            public void onSuccess() {
                // TODO Auto-generated method stub
                toast("登录成功");
                Intent i = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
            @Override
            public void onFailure(int code, String msg) {
                // TODO Auto-generated method stub
                toast("登录失败:"+msg);
            }
        });
    }
}
