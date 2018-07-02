package com.zmy.broadcasttest;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 测试全局广播，强制下线功能
 */

public class MainActivity extends BaseActivity {


    @BindView(R.id.offline)
    Button offline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * 与xml同名方法点击，pubic 参数View
     * @param view
     */
    public void onClick(View view){
        //发送广播
        Intent intentFilter = new Intent("com.zmy.broadcasttest.OFFLINE");
        sendBroadcast(intentFilter);
    }


    public static void actionStartMainAc(Context context){
        context.startActivity(new Intent(context,MainActivity.class));
    }

}
