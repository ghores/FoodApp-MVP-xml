package com.example.foodappmvp.ui.home

import com.example.foodappmvp.base.BasePresenter
import com.example.foodappmvp.base.BaseView
import com.example.foodappmvp.data.model.home.ResponseCategoriesList
import com.example.foodappmvp.data.model.home.ResponseFoodList

interface HomeContracts {
    interface View : BaseView {
        fun loadFoodRandom(data: ResponseFoodList)
        fun loadCategoriesFoodList(data: ResponseCategoriesList)
    }

    interface Presenter : BasePresenter {
        fun callFoodRandom()
        fun callCategoriesFoodList()
    }
}