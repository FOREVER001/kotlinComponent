package client.com.baselib.http

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


/**
 * Name: Transformer
 * Author: zxh17
 * Email:
 * Comment:  控制操作线程的辅助类
 * Date: 2018-07-25 09:33
 */
object Transformer {
    fun <T> switchSchedulers(): ObservableTransformer<T, T> {
        return object :ObservableTransformer<T, T>{
            override fun apply(upstream: Observable<T>): ObservableSource<T> {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .doOnSubscribe(Consumer {

                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }
    }
}