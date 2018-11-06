package com.uuch.android_zxinglibrary.SignSituation;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import com.uuch.android_zxinglibrary.LoginAndReg.Config;
import com.uuch.android_zxinglibrary.LoginAndReg.WebUtil;
import com.uuch.android_zxinglibrary.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
public class Type1Activity extends AppCompatActivity {
private SwipeRefreshLayout swipeRefresh;
String rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type1);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                sign("1");
            }
        });

    }
    private void sign(final String buff) {
        new Thread(new Runnable() {
            @Override
            public void run() {
    JSONArray reqValue;
                try {
                    //将用户名和密码封装到JSONArray中，进行HTTP通信
                    reqValue = new JSONArray().put(new JSONObject().put("buff", buff));
                    rec = WebUtil.getJSONArrayByWeb(Config.METHOD_TYPE,
                            reqValue);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView type1 = (TextView) findViewById(R.id.type1);
                        type1.setText(rec);
                        swipeRefresh.setRefreshing(false);
                    }
                });

            }
        }).start();

    }



}
