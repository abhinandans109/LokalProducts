package com.abhinandan.lokalproducts

import java.io.Serializable

data class productModel(
   var id: Int?,
   var price: Double?,
   var discountPercentage: Double?,
   var rating: Double?,
   var stock: Double?,
   var title: String?,
   var  description: String?,
   var  brand: String?,
   var category: String?,
   var thumbnail: String?,
   var images: List<String>?
) :Serializable
