package com.example.foodappmvp.data.repository

import com.example.foodappmvp.data.model.home.ResponseCategoriesList
import com.example.foodappmvp.data.model.home.ResponseFoodList
import com.example.foodappmvp.data.server.ApiServices
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: ApiServices) {
    fun getFoodRandom(): Single<Response<ResponseFoodList>> = api.getFoodRandom()
    fun getCategoriesFoodList(): Single<Response<ResponseCategoriesList>> = api.getCategoriesFoodList()
}