package com.android.toolbar.utils;

import android.util.Log;

/**
 * Created by li on 2016/5/18.
 */
public class LogUtils {
    static boolean flag = true;
    public static void logE(Class clazz, String msg) {
        try {
            if (flag)
                Log.e(clazz.getName(), msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
