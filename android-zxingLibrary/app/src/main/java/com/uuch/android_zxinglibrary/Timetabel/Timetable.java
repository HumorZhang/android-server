package com.uuch.android_zxinglibrary.Timetabel;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;



import com.uuch.android_zxinglibrary.R;

import org.json.JSONArray;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Timetable extends AppCompatActivity {
    private CourseTableView courseTableView;
    private String extra_data = null;
    private String va1=null;
    private String va2=null;
    private String va3=null;
    private String va4=null;

    private String va5=null;
    private String va6=null;
    private String va7=null;
    private String va8=null;

    private String va9=null;
    private String va10=null;
    private String va11=null;
    private String va12=null;

    private String va13=null;
    private String va14=null;
    private String va15=null;
    private String va16=null;

    private String va17=null;
    private String va18=null;
    private String va19=null;
    private String va20=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        courseTableView = (CourseTableView) findViewById(R.id.ctv);


        Intent intent=getIntent();
        extra_data=intent.getStringExtra("extra_data");
       // Toast.makeText(Timetable.this, "传输结果:" + extra_data, Toast.LENGTH_LONG).show();

        try
            {
                     JSONArray jsonArray = new JSONArray(extra_data);
                     for (int i=0; i < jsonArray.length(); i++)    {
                             JSONObject jsonObject = jsonArray.getJSONObject(i);
                         va1  = jsonObject.getString("1_1");
                         va2  = jsonObject.getString("1_2");
                         va3  = jsonObject.getString("1_3");
                         va4  = jsonObject.getString("1_4");

                         va5  = jsonObject.getString("2_1");
                         va6  = jsonObject.getString("2_2");
                         va7  = jsonObject.getString("2_3");
                         va8  = jsonObject.getString("2_4");

                         va9  = jsonObject.getString("3_1");
                         va10  = jsonObject.getString("3_2");
                         va11  = jsonObject.getString("3_3");
                         va12  = jsonObject.getString("3_4");

                         va13  = jsonObject.getString("4_1");
                         va14  = jsonObject.getString("4_2");
                         va15  = jsonObject.getString("4_3");
                         va16  = jsonObject.getString("4_4");

                         va17  = jsonObject.getString("5_1");
                         va18  = jsonObject.getString("5_2");
                         va19  = jsonObject.getString("5_3");
                         va20  = jsonObject.getString("5_4");



                         }
                }
             catch (Exception e)
            {
                     e.printStackTrace();
                 }


        List<Course> list = new ArrayList<>();

        Toast.makeText(Timetable.this, "结果:" + va1, Toast.LENGTH_LONG).show();



            Course c1=new Course();
            c1.setDay(1);
            c1.setJieci(1);
            c1.setDes(va1);
                list.add(c1);

        Course c2=new Course();
        c2.setDay(1);
        c2.setJieci(3);
        c2.setDes(va2);
        list.add(c2);

        Course c3=new Course();
        c3.setDay(1);
        c3.setJieci(5);
        c3.setDes(va3);
        list.add(c3);

        Course c4=new Course();
        c4.setDay(1);
        c4.setJieci(7);
        c4.setDes(va4);
        list.add(c4);
//周二
        Course c5=new Course();
        c5.setDay(2);
        c5.setJieci(1);
        c5.setDes(va5);
        list.add(c5);

        Course c6=new Course();
        c6.setDay(2);
        c6.setJieci(3);
        c6.setDes(va6);
        list.add(c6);

        Course c7=new Course();
        c7.setDay(2);
        c7.setJieci(5);
        c7.setDes(va7);
        list.add(c7);

        Course c8=new Course();
        c8.setDay(2);
        c8.setJieci(7);
        c8.setDes(va8);
        list.add(c8);
//周三
        Course c9=new Course();
        c9.setDay(3);
        c9.setJieci(1);
        c9.setDes(va9);
        list.add(c9);

        Course c10=new Course();
        c10.setDay(3);
        c10.setJieci(3);
        c10.setDes(va10);
        list.add(c10);

        Course c11=new Course();
        c11.setDay(3);
        c11.setJieci(5);
        c11.setDes(va11);
        list.add(c11);

        Course c12=new Course();
        c12.setDay(3);
        c12.setJieci(7);
        c12.setDes(va12);
        list.add(c12);
//周四
        Course c13=new Course();
        c13.setDay(4);
        c13.setJieci(1);
        c13.setDes(va13);
        list.add(c13);

        Course c14=new Course();
        c14.setDay(4);
        c14.setJieci(3);
        c14.setDes(va14);
        list.add(c14);

        Course c15=new Course();
        c15.setDay(4);
        c15.setJieci(5);
        c15.setDes(va15);
        list.add(c15);

        Course c16=new Course();
        c16.setDay(4);
        c16.setJieci(7);
        c16.setDes(va16);
        list.add(c16);
//周五
        Course c17=new Course();
        c17.setDay(5);
        c17.setJieci(1);
        c17.setDes(va17);
        list.add(c17);

        Course c18=new Course();
        c18.setDay(5);
        c18.setJieci(3);
        c18.setDes(va18);
        list.add(c18);

        Course c19=new Course();
        c19.setDay(5);
        c19.setJieci(5);
        c19.setDes(va19);
        list.add(c19);

        Course c20=new Course();
        c20.setDay(5);
        c20.setJieci(7);
        c20.setDes(va20);
        list.add(c20);
        courseTableView.updateCourseViews(list);
         }

    }





