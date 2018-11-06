package com.uuch.android_zxinglibrary.QR;

import android.Manifest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;


import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.uuch.android_zxinglibrary.LoginAndReg.Config;

import com.uuch.android_zxinglibrary.LoginAndReg.LoginActivity;
import com.uuch.android_zxinglibrary.LoginAndReg.WebUtil;

import com.uuch.android_zxinglibrary.R;
import com.uuch.android_zxinglibrary.Timetabel.Timetable;
import com.uuch.android_zxinglibrary.utils.CheckPermissionUtils;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * 这是学生界面
 */

public class MainActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks{

    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;
    /**
     * 选择系统图片Request Code
     */
    public static final int REQUEST_IMAGE = 112;

    public Button button1 = null;
    public Button button2 = null;
    public Button button3 = null;
    public Button button4 = null;
    public Button button5 = null;
    private String extra_data = null;
    private String rec1=null;
    private String rec2=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        extra_data=intent.getStringExtra("extra_data");
        Toast.makeText(MainActivity.this, "传输结果:" + extra_data, Toast.LENGTH_LONG).show();
        /**
         * 初始化组件
         */
        initView();
        //初始化权限
        initPermission();
    }

    /**
     * 初始化权限事件
     */
    private void initPermission() {
        //检查权限
        String[] permissions = CheckPermissionUtils.checkPermission(this);
        if (permissions.length == 0) {
            //权限都申请了
            //是否登录
        } else {
            //申请权限
            ActivityCompat.requestPermissions(this, permissions, 100);
        }
    }
    /**
     * 初始化组件
     */
    private void initView() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        /**
         * 打开默认二维码扫描界面
         *
         * 打开系统图片选择界面
         *
         * 定制化显示扫描界面
         *
         * 查看公告
         *
         * 查看课表
         */
        button1.setOnClickListener(new ButtonOnClickListener(button1.getId()));
        button2.setOnClickListener(new ButtonOnClickListener(button2.getId()));
        button3.setOnClickListener(new ButtonOnClickListener(button3.getId()));
        button4.setOnClickListener(new ButtonOnClickListener(button4.getId()));
        button5.setOnClickListener(new ButtonOnClickListener(button5.getId()));


    }

    private void sign(final String username) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                JSONArray reqValue;
                try {
                    //将用户名和密码封装到JSONArray中，进行HTTP通信
                    reqValue = new JSONArray().put(new JSONObject().put("username", username));

                    String rec = WebUtil.getJSONArrayByWeb(Config.METHOD_SIGN,
                            reqValue);


                } catch (JSONException e) {

                    e.printStackTrace();
                }

            }
        }).start();

    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);

                    if(result.equals("123")){
                        sign(extra_data);
                        Intent intent = new Intent(this,successActivity.class);
                        startActivity(intent);

                    }
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }

        /**
         * 选择系统图片并解析
         */
        else if (requestCode == REQUEST_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                try {
                    CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), new CodeUtils.AnalyzeCallback() {
                        @Override
                        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                            Toast.makeText(MainActivity.this, "解析结果:" + result, Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onAnalyzeFailed() {
                            Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        else if (requestCode == REQUEST_CAMERA_PERM) {
            Toast.makeText(this, "从设置页面返回...", Toast.LENGTH_SHORT)
                    .show();
        }
    }


    /**
     * 请求CAMERA权限码
     */
    public static final int REQUEST_CAMERA_PERM = 101;


    /**
     * EsayPermissions接管权限处理逻辑
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @AfterPermissionGranted(REQUEST_CAMERA_PERM)
    public void cameraTask(int viewId) {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
            // Have permission, do the thing!
            onClick(viewId);
        } else {
            // Ask for one permission
            EasyPermissions.requestPermissions(this, "需要请求camera权限",
                    REQUEST_CAMERA_PERM, Manifest.permission.CAMERA);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Toast.makeText(this, "执行onPermissionsGranted()...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast.makeText(this, "执行onPermissionsDenied()...", Toast.LENGTH_SHORT).show();
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this, "当前App需要申请camera权限,需要打开设置页面么?")
                    .setTitle("权限申请")
                    .setPositiveButton("确认")
                    .setNegativeButton("取消", null /* click listener */)
                    .setRequestCode(REQUEST_CAMERA_PERM)
                    .build()
                    .show();
        }
    }


    /**
     * 按钮点击监听
     */
    class ButtonOnClickListener implements View.OnClickListener{

        private int buttonId;

        public ButtonOnClickListener(int buttonId) {
            this.buttonId = buttonId;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.button2) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMAGE);
            }
            else {
                cameraTask(buttonId);
            }
        }
    }


    /**
     * 按钮点击事件处理逻辑
     * @param buttonId
     */
    private void onClick(int buttonId) {
        switch (buttonId) {
            case R.id.button1:
                Intent intent = new Intent(getApplication(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.button3:
                intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;

            case R.id.button4:

                Intent intent4=new Intent(MainActivity.this,ChakanActivity.class);

                startActivity(intent4);
                break;
            case R.id.button5:
     login("123","123");
            default:
                break;
        }
    }

    private void login(final String id, final String password) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                JSONArray reqValue;
                try {
                    //将用户名和密码封装到JSONArray中，进行HTTP通信
                    reqValue = new JSONArray().put(new JSONObject().put("id", id).put("password", password));

                    String rec = WebUtil.getJSONArrayByWeb(Config.METHOD_KEBIAO,
                            reqValue);
                    if (rec != null) {


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

    public static final int MSG_SUCESS=0;
    public static final int MSG_FAIL=1;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case MSG_SUCESS:


                    String data=msg.obj.toString();
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,Timetable.class);
                    intent.putExtra("extra_data",data);
                    startActivity(intent);
                    break;
                case MSG_FAIL:

                    break;


            }
        };
    };

}
