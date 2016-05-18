package com.android.toolbar.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by li on 2016/5/18.
 */
public class ToastUtils {
    private static Toast toast = null;
    public static void showToast(String msg,Context context)
    {
        if(toast == null)
        {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        else
        {
            toast.setText(msg);
        }
        toast.show();
    }
}
