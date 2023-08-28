package com.abhinandan.lokalproducts

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/products")
    suspend fun getProducts() : Response<ResponseModel>

}