package com.example.foodappmvp.ui.home

import com.example.foodappmvp.base.BasePresenterImpl
import com.example.foodappmvp.data.repository.HomeRepository
import com.example.foodappmvp.utils.applyIoScheduler
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val repository: HomeRepository,
    val view: HomeContracts.View
) : BasePresenterImpl(), HomeContracts.Presenter {
    override fun callFoodRandom() {
        if (view.checkInternet()) {
            disposable = repository.getFoodRandom()
                .applyIoScheduler()
                .subscribe({ response ->
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                view.loadFoodRandom(it)
                            }
                        }

                        422 -> {

                        }

                        in 400..499 -> {

                        }

                        in 500..599 -> {

                        }
                    }

                }, {
                    view.serverError(it.message.toString())
                })
        }
    }

    override fun callCategoriesFoodList() {
        if (view.checkInternet()) {
            view.showLoading()
            disposable = repository.getCategoriesFoodList()
                .applyIoScheduler()
                .subscribe({ response ->
                    view.hideLoading()
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                if (it.categories.isNotEmpty()) {
                                    view.loadCategoriesFoodList(it)
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

    override fun callFoodList(letter: String) {
        if (view.checkInternet()) {
            view.foodsLoadingState(true)
            disposable = repository.getFoodList(letter)
                .applyIoScheduler()
                .subscribe({ response ->
                    view.foodsLoadingState(false)
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                if (it.meals != null && it.meals.isNotEmpty()) {
                                    view.loadFoodList(it)
                                }
                            }
                        }
                    }

                }, {
                    view.foodsLoadingState(false)
                    view.serverError(it.message.toString())
                })
        }
    }

    override fun callSearchFoodList(letter: String) {
        if (view.checkInternet()) {
            view.foodsLoadingState(true)
            disposable = repository.getSearchFoodList(letter)
                .applyIoScheduler()
                .subscribe({ response ->
                    view.foodsLoadingState(false)
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                if (it.meals != null && it.meals.isNotEmpty()) {
                                    view.loadFoodList(it)
                                }
                            }
                        }
                    }

                }, {
                    view.foodsLoadingState(false)
                    view.serverError(it.message.toString())
                })
        }
    }

    override fun callFoodsByCategory(letter: String) {
        if (view.checkInternet()) {
            view.foodsLoadingState(true)
            disposable = repository.getFoodsByCategory(letter)
                .applyIoScheduler()
                .subscribe({ response ->
                    view.foodsLoadingState(false)
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                if (it.meals != null && it.meals.isNotEmpty()) {
                                    view.loadFoodList(it)
                                }
                            }
                        }
                    }

                }, {
                    view.foodsLoadingState(false)
                    view.serverError(it.message.toString())
                })
        }
    }
}