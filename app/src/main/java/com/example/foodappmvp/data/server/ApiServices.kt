package com.example.foodappmvp.data.server

import com.example.foodappmvp.data.model.home.ResponseFoodList
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("random.php")
    fun getFoodRandom(): Single<Response<ResponseFoodList>>
}
