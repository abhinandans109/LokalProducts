package com.abhinandan.lokalproducts.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private lateinit var instance: RetrofitBuilder
    var baseUrl="https://dummyjson.com/"

    fun getInstance(): ApiInterface {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }

}