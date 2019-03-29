package client.com.basecomponentwithkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import client.com.baselib.constant.Constants
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * kotlin组件化打造电商app
 * @author zxh
 * @version 1.0
 * */
@Route(path = Constants.MIAIN_ACTIVITY_PATH)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          initEvent()
    }
    private fun initEvent(){
        btn.setOnClickListener {
            ARouter.getInstance().build(Constants.HOME_ACTIVITY_PATH).navigation()
        }
    }
}
