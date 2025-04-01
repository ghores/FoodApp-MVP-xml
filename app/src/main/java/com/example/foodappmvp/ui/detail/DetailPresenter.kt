package com.example.foodappmvp.ui.detail

import com.example.foodappmvp.base.BasePresenterImpl
import com.example.foodappmvp.data.repository.DetailRepository
import com.example.foodappmvp.utils.applyIoScheduler
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val repository: DetailRepository,
    val view: DetailContracts.View
) : BasePresenterImpl(), DetailContracts.Presenter {
    override fun callFoodDetails(id: Int) {
        if (view.checkInternet()) {
            view.showLoading()
            disposable = repository.getFoodDetails(id)
                .applyIoScheduler()
                .subscribe({ response ->
                    view.hideLoading()
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                if (it.meals != null && it.meals.isNotEmpty()) {
                                    view.loadFoodDetails(it)
                                }
                            }
                        }
                    }

                }, {
                    view.hideLoading()
                    view.serverError(it.message.toString())
                })
        }
    }
}