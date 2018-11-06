package com.uuch.android_zxinglibrary.HistoryAndRepair;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.uuch.android_zxinglibrary.LoginAndReg.Config;
import com.uuch.android_zxinglibrary.LoginAndReg.WebUtil;
import com.uuch.android_zxinglibrary.QR.MainActivity;
import com.uuch.android_zxinglibrary.QR.ThreeActivity;
import com.uuch.android_zxinglibrary.R;
import com.uuch.android_zxinglibrary.SignSituation.Type1Activity;
import com.uuch.android_zxinglibrary.SignSituation.Type2Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HistoryActivity extends AppCompatActivity {
    Spinner s;
    private String selected;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        adapter = ArrayAdapter.createFromResource(this, R.array.place, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Button xuanke=(Button)findViewById(R.id.xuanzhe);
        Button jieshu = (Button) findViewById(R.id.jieshu);
        Button ty1 = (Button) findViewById(R.id.ty1);
        Button ty2 = (Button) findViewById(R.id.ty2);
        Button history = (Button) findViewById(R.id.history);
        Button erweima = (Button) findViewById(R.id.erweima);

        s = (Spinner)findViewById(R.id.spinner1);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new SpinnerListener());
        s.setPrompt("时间");


        erweima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),ThreeActivity.class);
                startActivity(intent);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(v.getContext(),LookHistoryActivity.class);
              startActivity(intent);
            }
        });
        ty1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(), Type1Activity.class);

                startActivity(intent);
            }
        });


        ty2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), Type2Activity.class);
                startActivity(intent);
            }
        });

        xuanke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kaiqi(selected);
            }
        });

        jieshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end("1");
            }
        });
    }


    class SpinnerListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            selected = arg0.getItemAtPosition(arg2).toString();
            Toast.makeText(HistoryActivity.this, "你选的是 :"+selected, Toast.LENGTH_LONG).show();
            Log.d("test", "what you selected is :"+selected);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
            Toast.makeText(HistoryActivity.this, "you have selected nothing", Toast.LENGTH_LONG).show();

        }

    }


    private void kaiqi(final String selecte) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                JSONArray reqValue;
                try {
                    //将用户名和密码封装到JSONArray中，进行HTTP通信
                    reqValue = new JSONArray().put(new JSONObject().put("selecte", selecte));

                    String rec = WebUtil.getJSONArrayByWeb(Config.METHOD_KAIQI,
                            reqValue);
                    if (rec != null) {//如果成功获取用户ID
                        // result = rec.getJSONObject(0).getInt("userId");




                    }
                    else{


                    }
                } catch (JSONException e) {

                    e.printStackTrace();
                }

            }
        }).start();

    }

    private void end(final String selec) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                JSONArray reqValue;
                try {
                    //将用户名和密码封装到JSONArray中，进行HTTP通信
                    reqValue = new JSONArray().put(new JSONObject().put("selec", selec));

                    String rec = WebUtil.getJSONArrayByWeb(Config.METHOD_END,
                            reqValue);
                    if (rec != null) {//如果成功获取用户ID
                        // result = rec.getJSONObject(0).getInt("userId");




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
