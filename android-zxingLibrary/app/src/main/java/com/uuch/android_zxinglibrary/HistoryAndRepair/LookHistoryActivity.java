package com.uuch.android_zxinglibrary.HistoryAndRepair;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.uuch.android_zxinglibrary.LoginAndReg.Config;
import com.uuch.android_zxinglibrary.LoginAndReg.WebUtil;
import com.uuch.android_zxinglibrary.QR.MainActivity;
import com.uuch.android_zxinglibrary.R;
import com.uuch.android_zxinglibrary.Timetabel.Timetable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LookHistoryActivity extends AppCompatActivity {
    Spinner s;
    private String selected;
    ArrayAdapter<CharSequence> adapter;
    public static final int MSG_SUCESS=0;
    public static final int MSG_FAIL=1;
    TextView renyuan;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case MSG_SUCESS:

renyuan.setText(msg.obj.toString());
                    break;
                case MSG_FAIL:

                    break;


            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_history);
        adapter = ArrayAdapter.createFromResource(this, R.array.place, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s = (Spinner)findViewById(R.id.spinner1);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new SpinnerListener());
        s.setPrompt("时间");

        Button chakan = (Button) findViewById(R.id.ck1);
         renyuan = (TextView) findViewById(R.id.renyuan);

        chakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               res(selected);
            }
        });


    }

    class SpinnerListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            selected = arg0.getItemAtPosition(arg2).toString();
            Toast.makeText(LookHistoryActivity.this, "你选的是 :"+selected, Toast.LENGTH_LONG).show();
            Log.d("test", "what you selected is :"+selected);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
            Toast.makeText(LookHistoryActivity.this, "you have selected nothing", Toast.LENGTH_LONG).show();

        }

    }

    private void res(final String selecte) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                JSONArray reqValue;
                try {
                    //将用户名和密码封装到JSONArray中，进行HTTP通信
                    reqValue = new JSONArray().put(new JSONObject().put("selecte", selecte));

                    String rec = WebUtil.getJSONArrayByWeb(Config.METHOD_RENYUAN,
                            reqValue);
                    if (rec != null) {//如果成功获取用户ID
                        // result = rec.getJSONObject(0).getInt("userId");


                        Message msg = new Message();
                        msg.obj = rec;
                        msg.what = MSG_SUCESS;
                        handler.sendMessage(msg);

                    }
                    else{


                    }
                } catch (JSONException e) {

                    e.printStackTrace();
                }

            }
        }).start();

    }


}
