package com.zmy.broadcasttest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengmanyan on 2018/7/1.
 */

public class ActivitController {

    private static List<BaseActivity> activities = new ArrayList<>();

    public static void addActivity(BaseActivity activity) {
        if (activity != null && !activity.isFinishing()) {
            activities.add(activity);
        }
    }

    public static void removeActivity(BaseActivity activity) {
//        if (activity!=null && !activity.isFinishing()){
        activities.remove(activity);
//        }
    }

    public static void existAcftivit() {
        for (BaseActivity activity : activities) {
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
    }

}
