package com.abhinandan.lokalproducts.models

import com.abhinandan.lokalproducts.models.ResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/products")
    suspend fun getProducts() : Response<ResponseModel>

}