package client.com.baselib.http

import client.com.baselib.util.LogUtils
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit


/**
Author:自定义日志拦截器
Date:2019/3/30
Email:zxh1786619259@163.com
Desc:
 */
class LoggingInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain?): Response {
        //获得请求信息，此处如有需要可以添加headers信息

        var request = chain?.request()
        var method = request?.method()
        var url = request?.url()
        var headerStr = request?.headers().toString()
        //打印请求信息
        LogUtils.e("url:======$url")
        LogUtils.e("method:=======$method")
        LogUtils.e("headers-body:=====$headerStr" )
        printQuestParams(method,request)

        //记录请求耗时
        val startNs=System.nanoTime()
        val response:okhttp3.Response
        try {
            //发送请求，获得相应，
            response = chain!!.proceed(request)
        } catch (e: Exception) {
            throw e
        }
        val tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs)
        //打印请求耗时
        LogUtils.e("耗时:" + tookMs + "ms")
          printResponse(response)
         return response

    }

    private fun printResponse(response: Response) {
        //使用response获得headers(),可以更新本地Cookie。
        val headers = response.headers()
        LogUtils.e(headers.toString())

        //获得返回的body，注意此处不要使用responseBody.string()获取返回数据，原因在于这个方法会消耗返回结果的数据(buffer)
        var responseBody = response.body()

        //为了不消耗buffer，我们这里使用source先获得buffer对象，然后clone()后使用
        var source = responseBody?.source()
        source?.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
        //获得返回的数据
        var buffer = source?.buffer()
        //使用前clone()下，避免直接消耗
        LogUtils.e("=====response:======" + buffer?.clone()?.readString(Charset.forName("UTF-8")))

    }

    /**
     * 打印请求参数
     *
     * */
    private fun printQuestParams(method: String?, request: Request?) {
        when(method){
            "POST" ->{ //post请求
                val sb=StringBuilder()
                if(request?.body() is FormBody){
                    val formBody:FormBody=request.body() as FormBody
                    sb.append("{")
                    for (i in 0 until formBody.size()){
                         sb.append("${formBody.encodedName(i)}:${formBody.encodedValue(i)},")
                    }
                    sb.append("}")
                    sb.delete(sb.length-1,sb.length)
                    LogUtils.e("=post请求参数==,${sb.toString()}")
                }
            }
            else ->{ //get等其他请求
                LogUtils.e("request-body:===get==${request?.url()}")

            }
        }
    }
}