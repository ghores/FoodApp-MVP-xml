package com.example.foodappmvp.utils

import android.content.Context
import android.net.ConnectivityManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

//RxJava
fun <T : Any> Single<T>.applyScheduler(scheduler: Scheduler): Single<T> =
    subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())

fun <T : Any> Single<T>.applyIoScheduler(): Single<T> = applyScheduler(Schedulers.io())

//Check network
fun Context.isNetworkAvailable(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = cm.activeNetworkInfo
    return info != null && info.isConnected
}