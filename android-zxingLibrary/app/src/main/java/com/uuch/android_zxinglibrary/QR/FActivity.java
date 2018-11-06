package com.uuch.android_zxinglibrary.QR;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.uuch.android_zxinglibrary.LoginAndReg.Config;
import com.uuch.android_zxinglibrary.LoginAndReg.LoginActivity;
import com.uuch.android_zxinglibrary.LoginAndReg.WebUtil;
import com.uuch.android_zxinglibrary.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FActivity extends AppCompatActivity {

    private EditText nr;
    private Button fabu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        nr=(EditText)findViewById(R.id.nr1);
        fabu = (Button) findViewById(R.id.fb1);
        fabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign(nr.getText().toString());
                Toast.makeText(FActivity.this, "发布成功："+nr.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sign(final String neir) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                JSONArray reqValue;
                try {
                    //将用户名和密码封装到JSONArray中，进行HTTP通信
                    reqValue = new JSONArray().put(new JSONObject().put("neirong", neir));

                    String rec = WebUtil.getJSONArrayByWeb(Config.METHOD_FABU,
                            reqValue);


                } catch (JSONException e) {

                    e.printStackTrace();
                }

            }
        }).start();

    }

}
