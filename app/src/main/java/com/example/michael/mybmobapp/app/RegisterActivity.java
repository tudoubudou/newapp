package com.example.michael.mybmobapp.app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.michael.mybmobapp.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Michael on 16/4/13.
 */
public class RegisterActivity extends BaseActivity {
    TextView name;
    TextView pwd;
    TextView email;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_register);
        name = (TextView)findViewById(R.id.name);
        pwd = (TextView)findViewById(R.id.pwd);
        email = (TextView)findViewById(R.id.email);
        register = (TextView)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(name.getText().toString(), pwd.getText().toString(), email.getText().toString());
            }
        });

    }

    private void register(String name, String pwd, String email) {
        BmobUser bu = new BmobUser();
        bu.setUsername(name);
        bu.setPassword(pwd);
        bu.setEmail(email);
        //注意：不能用save方法进行注册
        bu.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {
                // TODO Auto-generated method stub
                toast("注册成功:");
            }

            @Override
            public void onFailure(int code, String msg) {
                // TODO Auto-generated method stub
                toast("注册失败:" + msg);
            }
        });
    }
}
