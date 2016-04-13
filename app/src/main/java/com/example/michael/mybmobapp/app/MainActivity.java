package com.example.michael.mybmobapp.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.michael.mybmobapp.R;
import com.example.michael.mybmobapp.model.Person;

import org.json.JSONArray;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindCallback;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends BaseActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView = (TextView)findViewById(R.id.text);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Person p2 = new Person();
                p2.setName("gzw");
                p2.setAddress("shenzhen");
                p2.save(MainActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "save success!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(MainActivity.this, "save fail! errorcode=" + i + " string=" + s, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            queryData();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void queryData(){
        BmobQuery query = new BmobQuery("Person");
        query.findObjects(this, new FindCallback() {

            @Override
            public void onSuccess(JSONArray arg0) {
                //注意：查询的结果是JSONArray,需要自行解析
                showToast("查询成功:" + arg0.length());
                textView.setText(arg0.toString());
                for (int i = 0; i < arg0.length(); i++) {

                    Person p = JSON.parseObject(arg0.optString(i), Person.class);
                    showToast(p.toString());
                }
            }

            @Override
            public void onFailure(int arg0, String arg1) {
                showToast("查询失败:" + arg1 + " errorcode=" + arg0);
            }
        });
    }

    private void showToast(String s) {
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
    }
}
