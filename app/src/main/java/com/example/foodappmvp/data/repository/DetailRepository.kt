package com.example.foodappmvp.data.repository

import com.example.foodappmvp.data.model.home.ResponseFoodList
import com.example.foodappmvp.data.server.ApiServices
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class DetailRepository @Inject constructor(private val api: ApiServices) {
    fun getFoodDetails(id: Int): Single<Response<ResponseFoodList>> = api.getFoodDetails(id)
}