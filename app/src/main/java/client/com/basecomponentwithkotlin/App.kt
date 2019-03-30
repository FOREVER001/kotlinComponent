package client.com.basecomponentwithkotlin

import android.content.Context
import client.com.baselib.app.BaseApp
/**
 * 自定义application
 *
 * */
class App : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        context=this@App
    }
    companion object {
        var context:Context?=null
        fun getAppContext():Context?{
            return context
        }

    }
}