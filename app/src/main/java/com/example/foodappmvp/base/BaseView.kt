package com.example.foodappmvp.base

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun checkInternet(): Boolean
    fun internetError(hasInternet: Boolean)
    fun serverError(message:String)
}