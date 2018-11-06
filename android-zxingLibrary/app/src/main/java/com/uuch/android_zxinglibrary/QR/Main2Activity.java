package com.uuch.android_zxinglibrary.QR;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.uuch.android_zxinglibrary.HistoryAndRepair.HistoryActivity;
import com.uuch.android_zxinglibrary.LoginAndReg.Config;
import com.uuch.android_zxinglibrary.LoginAndReg.WebUtil;
import com.uuch.android_zxinglibrary.R;
import com.uuch.android_zxinglibrary.SignSituation.Type1Activity;
import com.uuch.android_zxinglibrary.SignSituation.Type2Activity;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 这是老师界面
 */
public class Main2Activity extends AppCompatActivity {
private String rec=null;
    private String rec1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button5=(Button)findViewById(R.id.button5);

        Button clear=(Button)findViewById(R.id.clear);
        Button fabu=(Button)findViewById(R.id.fabu);
         clear.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 sign("123");
                Intent intent=new Intent(Main2Activity.this, HistoryActivity.class);
                startActivity(intent);
             }
         });





fabu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Main2Activity.this,FActivity.class);
        startActivity(intent);
    }
});
    }

    private void sign(final String buff) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                JSONArray reqValue;
                try {

                    reqValue = new JSONArray().put(new JSONObject().put("buff", buff));

                    rec = WebUtil.getJSONArrayByWeb(Config.METHOD_CLEAR,
                            reqValue);


                } catch (JSONException e) {

                    e.printStackTrace();
                }

            }
        }).start();

    }
}
