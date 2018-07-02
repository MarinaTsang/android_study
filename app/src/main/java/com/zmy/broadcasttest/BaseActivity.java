package com.zmy.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zengmanyan on 2018/7/1.
 * 基类Activity ，可以不必每个Activity  注册广播及取消广播 并出现强制下线提示框
 * <p>
 * 在onResume注册和onPuase取消注册是为了保证只有在栈顶的Activity才接收到这条广播
 */

public class BaseActivity extends AppCompatActivity {

    private OfflineReceiver offlineReceiver;

    private BaseActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mActivity = this;
        ActivitController.addActivity(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("com.zmy.broadcasttest.OFFLINE");
        offlineReceiver = new OfflineReceiver();
        registerReceiver(offlineReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (offlineReceiver != null) {
            unregisterReceiver(offlineReceiver);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivitController.removeActivity(this);
    }

    class OfflineReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Utils.showToast(mActivity, "action: " + action);
//            if ("com.zmy.broadcasttest.OFFLINE".equals(action)) {
//                showDialog();
                AlertDialog.Builder dialog = new AlertDialog.Builder(mActivity);
                dialog.setTitle("提示")
                        .setMessage("您确定要退出登录吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                //1.退出登录
                                //2.关闭Activity
                                ActivitController.existAcftivit();
                                //3.重新启动登录页
                                LoginActivity.actionStartLoginAc(mActivity);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();

//            }

        }
    }
}
