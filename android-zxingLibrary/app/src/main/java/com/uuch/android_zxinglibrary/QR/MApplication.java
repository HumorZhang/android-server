package com.uuch.android_zxinglibrary.QR;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;



public class MApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        ZXingLibrary.initDisplayOpinion(this);
    }
}
