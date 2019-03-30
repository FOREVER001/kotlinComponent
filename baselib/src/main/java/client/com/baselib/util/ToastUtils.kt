package client.com.baselib.util

import android.widget.Toast
import client.com.baselib.app.BaseApp

/**
Author:Toast工具类
Date:2019/3/30
Email:zxh1786619259@163.com
Desc:
 */
object ToastUtils {
    private var mToast:Toast?=null
    fun showToast(msg:String){
        if(mToast==null){
            mToast= Toast.makeText(BaseApp.getBaseAppContext(),msg,Toast.LENGTH_LONG)
        }else{
            mToast?.setText(msg)
        }
        mToast?.show()
    }
}
