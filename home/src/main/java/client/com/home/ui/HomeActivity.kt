package client.com.home.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import client.com.baselib.constant.Constants
import client.com.home.R
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * home页面
 * @author zxh
 * @version
 * */
@Route(path = Constants.HOME_ACTIVITY_PATH)
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_home)
    }
}