package com.example.foodappmvp.ui.detail

import com.example.foodappmvp.base.BasePresenter
import com.example.foodappmvp.base.BaseView
import com.example.foodappmvp.data.model.home.ResponseFoodList

interface DetailContracts {
    interface View : BaseView {
        fun loadFoodDetails(data: ResponseFoodList)
    }

    interface Presenter : BasePresenter {
        fun callFoodDetails(id: Int)
    }
}
