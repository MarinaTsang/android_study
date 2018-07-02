package com.zmy.broadcasttest;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zengmanyan on 2018/7/1.
 */

public class Utils {

    public static void showToast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
