package com.example.myapplication

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.WindowManager


object Util {

    fun getScreenWidth(context: Context): Int {
        val manager = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = manager.defaultDisplay
        return display.width
    }

    /**
     * 获取屏幕的高度
     *
     * @param context
     * @return
     */
    fun getScreenHeight(context: Context): Int {
        val resources: Resources = context.resources
        val dm: DisplayMetrics = resources.displayMetrics
        return dm.heightPixels
    }
}