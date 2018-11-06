package com.uuch.android_zxinglibrary.LoginAndReg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.uuch.android_zxinglibrary.QR.Main2Activity;


import com.uuch.android_zxinglibrary.R;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Button button1=(Button)findViewById(R.id.xuesheng);
        Button button2=(Button)findViewById(R.id.laoshi);
        button1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent();
             intent.setClass(ChooseActivity.this,LoginActivity.class);
             startActivity(intent);

         }
     });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ChooseActivity.this,TeacherActivity.class);
                startActivity(intent);
            }
        });

    }
}
