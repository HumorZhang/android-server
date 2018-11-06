package com.uuch.android_zxinglibrary.LoginAndReg;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.uuch.android_zxinglibrary.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegActivity extends AppCompatActivity {
    private EditText uname;
    private EditText upassword;
    private EditText uid;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        uname=(EditText) findViewById(R.id.etname);
        upassword=(EditText)findViewById(R.id.etpas);
        uid=(EditText)findViewById(R.id.etId);
        submit=(Button)findViewById(R.id.Reg);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = RegActivity.this.uname.getText()
                        .toString().trim();
                String password = RegActivity.this.upassword.getText()
                        .toString().trim();
                String id = RegActivity.this.uid.getText()
                        .toString().trim();
                if ("".equals(username)) {
                    Toast.makeText(RegActivity.this, "请填写用户名",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(password)) {
                    Toast.makeText(RegActivity.this, "请填写密码",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(id)) {
                    Toast.makeText(RegActivity.this, "请填写学号",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                //如果已经填写了用户名和密码，执行登录操作
                handleReg();

                Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void handleReg() {
        String username = uname.getText().toString();
        String password = upassword.getText().toString();
        String id=uid.getText().toString();
        reg(username, password,id);
    }

    private void reg(final String username, final String password,final String id) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                JSONArray reqValue;
                try {
                    //将用户名和密码封装到JSONArray中，进行HTTP通信
                    reqValue = new JSONArray().put(new JSONObject().put("username", username).put("password", password).put("id",id));

                    String rec = WebUtil.getJSONArrayByWeb(Config.METHOD_REG,
                            reqValue);

                } catch (JSONException e) {

                    e.printStackTrace();
                }

            }
        }).start();

    }



}
