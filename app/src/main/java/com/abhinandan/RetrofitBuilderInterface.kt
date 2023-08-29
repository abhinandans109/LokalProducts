package com.abhinandan

import com.abhinandan.lokalproducts.models.RetrofitBuilder
import dagger.Component

@Component
interface RetrofitBuilderInterface {
    fun getRetrofitInstance () : RetrofitBuilder
}