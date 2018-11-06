package com.uuch.android_zxinglibrary.LoginAndReg;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uuch.android_zxinglibrary.QR.Main2Activity;
import com.uuch.android_zxinglibrary.QR.MainActivity;
import com.uuch.android_zxinglibrary.QR.ThreeActivity;
import com.uuch.android_zxinglibrary.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TeacherActivity extends AppCompatActivity {
    private EditText etId;
    private EditText etPassword;
    private Button btnLogin;

    public static final int MSG_LOGIN_SUCESS=0;
    public static final int MSG_LOGIN_FAIL=1;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case MSG_LOGIN_SUCESS:
                    Toast.makeText(TeacherActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(TeacherActivity.this,Main2Activity.class);
                    startActivity(intent);

                    break;
                case MSG_LOGIN_FAIL:
                    Toast.makeText(TeacherActivity.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
                    break;


            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        this.etId = (EditText) this.findViewById(R.id.etId);
        this.etPassword = (EditText) this.findViewById(R.id.etPassword);
        this.btnLogin = (Button) this.findViewById(R.id.btnLogin);
        this.btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String id = TeacherActivity.this.etId.getText()
                        .toString().trim();
                String password = TeacherActivity.this.etPassword.getText()
                        .toString().trim();
                if ("".equals(id)) {
                    Toast.makeText(TeacherActivity.this, "请填写用户名",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(password)) {
                    Toast.makeText(TeacherActivity.this, "请填写密码",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                //如果已经填写了用户名和密码，执行登录操作
                handleLogin();
            }
        });

    }
    private void handleLogin() {
        String username = etId.getText().toString();
        String password = etPassword.getText().toString();
        login(username, password);
    }





    private void login(final String id, final String password) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                JSONArray reqValue;
                try {
                    //将用户名和密码封装到JSONArray中，进行HTTP通信
                    reqValue = new JSONArray().put(new JSONObject().put("id", id).put("password", password));

                    String rec = WebUtil.getJSONArrayByWeb(Config.METHOD_TEACHER,
                            reqValue);
                    if (rec != null) {//如果成功获取用户ID
                        // result = rec.getJSONObject(0).getInt("userId");

                        Message msg = new Message();
                        msg.obj = rec;
                        msg.what = MSG_LOGIN_SUCESS;
                        handler.sendMessage(msg);
                    }
                    else{
                        Message msg=new Message();
                        msg.what = MSG_LOGIN_FAIL;
                        handler.sendMessage(msg);

                    }
                } catch (JSONException e) {

                    e.printStackTrace();
                }

            }
        }).start();

    }




}
