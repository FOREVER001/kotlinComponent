package client.com.baselib.app

import android.app.Application
import client.com.baselib.BuildConfig
import com.alibaba.android.arouter.launcher.ARouter

 abstract class BaseApp : Application() {
     private val isDebug:Boolean=BuildConfig.DEBUG
    override fun onCreate() {
        super.onCreate()
        initArouter()
    }

    /**
     * 初始化ArouterSdk
     * */
    private fun initArouter() {
        if(isDebug){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}