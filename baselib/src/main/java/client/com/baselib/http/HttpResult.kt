package client.com.baselib.http

/**
Author:Http返回统一结果
Date:2019/3/30
Email:zxh1786619259@163.com
Desc:
 */
data class HttpResult <T>(var code:Int,var msg:String,var data:T)