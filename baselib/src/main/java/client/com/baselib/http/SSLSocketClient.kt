package client.com.baselib.http

import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

/**
Author:Administrator
Date:2019/3/30
Email:zxh1786619259@163.com
Desc:
 */
object SSLSocketClient {
    fun getSSLSocketFactory(): SSLSocketFactory {
        var sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, getTrustManager(), SecureRandom())
        return sslContext.getSocketFactory();
    }

    //获取TrustManager
    private fun getTrustManager(): Array<TrustManager> {
        return arrayOf(object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}

            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        })
    }

    //获取HostnameVerifier
    fun getHostnameVerifier(): HostnameVerifier {
        return object : HostnameVerifier {
            override fun verify(s: String, sslSession: SSLSession): Boolean {
                return true
            }
        }
    }
}