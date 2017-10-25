package com.bawei.zhoukao2.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2017/10/16.
 */

public class Utils {
    /**
     * 获取设备屏幕尺寸
     * @param context
     * @return
     */
    public static Point getDisplayInfomation(Context context){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return new Point(dm.widthPixels,dm.heightPixels);
    }
}
