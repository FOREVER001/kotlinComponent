package client.com.baselib.http

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
Author:Http管理类
Date:2019/3/30
Email:zxh1786619259@163.com
Desc:
 */
class Http  private constructor(){
    private val retrofit:Retrofit
    private val defeaultTime:Long=30L
    init {
        retrofit=Retrofit.Builder()
                .baseUrl(HttpAddress.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build()
    }
    companion object {
        val instance by lazy {
            Http()
        }

    }

    private fun initClient():OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor())
                .addInterceptor(initCommonIntercept())
                .connectTimeout(defeaultTime, TimeUnit.SECONDS)
                .readTimeout(defeaultTime,TimeUnit.SECONDS)
                .writeTimeout(defeaultTime,TimeUnit.SECONDS)
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build()
    }


    /**
     *
     * 设置公共的header配置
     * */
    fun initCommonIntercept():Interceptor{
        return object :Interceptor{
            override fun intercept(chain: Interceptor.Chain?): Response {
                val request=chain!!.request()
                        .newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("charset", "UTF-8")
                        .build()
                return chain.proceed(request)
            }
        }
    }
    /**
     * getApiService
     * */
   fun getApiService():ApiService{
       return retrofit.create(ApiService::class.java)
   }

}