package client.com.baselib.util

import android.util.Log
import client.com.baselib.BuildConfig

/**
Author:打印日志工具类
Date:2019/3/30
Email:zxh1786619259@163.com
Desc:
 */
object LogUtils {
    private val isDebug:Boolean=BuildConfig.DEBUG
    private const val TAG:String="LogUtils"
    fun syso(str: String) {
        if (isDebug)
            println(str)
    }

    fun syso(i: Int) {
        if (isDebug)
            println(i)
    }

    /**
     * 默认tag的函数
     * @param msg 打印信息
     */
    fun v(msg: String) {
        if (isDebug) Log.v(TAG, msg)
    }

    fun d(msg: String) {
        if (isDebug) Log.d(TAG, msg)
    }

    fun i(msg: String) {
        if (isDebug) Log.i(TAG, msg)
    }

    fun w(msg: String) {
        if (isDebug) Log.w(TAG, msg)
    }

    fun e(msg: String) {
        if (isDebug) Log.e(TAG, msg)
    }

    /**
     * 自定义lag的函数
     * @param tag tag
     * @param msg 打印信息
     */
    fun v(tag: String, msg: String) {
        if (isDebug) Log.v(tag, msg)
    }

    fun d(tag: String, msg: String) {
        if (isDebug) Log.d(tag, msg)
    }

    fun i(tag: String, msg: String) {
        if (isDebug) Log.i(tag, msg)
    }

    fun w(tag: String, msg: String) {
        if (isDebug) Log.w(tag, msg)
    }

    fun e(tag: String, msg: String) {
        if (isDebug) Log.e(tag, msg)
    }

    /**
     * 自定义lag的函数
     * @param clazz 类
     * @param msg 打印信息
     */
    fun v(clazz: Class<*>, msg: String) {
        if (isDebug) Log.v(clazz.simpleName, msg)
    }

    fun d(clazz: Class<*>, msg: String) {
        if (isDebug) Log.d(clazz.simpleName, msg)
    }

    fun i(clazz: Class<*>, msg: String) {
        if (isDebug) Log.i(clazz.simpleName, msg)
    }

    fun w(clazz: Class<*>, msg: String) {
        if (isDebug) Log.w(clazz.simpleName, msg)
    }

    fun e(clazz: Class<*>, msg: String) {
        if (isDebug) Log.e(clazz.simpleName, msg)
    }
}